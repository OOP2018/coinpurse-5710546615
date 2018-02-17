package coinpurse;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A valuable purse contains coins or bank note. You can insert coins or bank
 * notes, withdraw money, check the balance, and check if the purse is full.
 * 
 * @author Visurt Anuttivong
 */
public class Purse {

	/* singleton instance of MoneyFactory. */
	private MoneyFactory factory = MoneyFactory.getInstance();
	/* A list of valuable */
	private List<Valuable> money;
	/* A comparator for valuable */
	private Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of coins you can put in purse.
	 * @param factory is the MoneyFactory in which you are used
	 */
	public Purse(int capacity, MoneyFactory factory) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>(capacity);
		this.factory = factory;
	}

	/**
	 * Count and return the number of valuables in the purse. This is the number of
	 * valuables, not their value.
	 * 
	 * @return the number of valuables in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (int i = 0; i < count(); i++)
			sum += money.get(i).getValue();
		return sum;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (count() >= capacity)
			return true;
		return false;
	}

	/**
	 * Insert a valuable into the purse. The valuable is only inserted if the purse
	 * has space for it and the valuable has positive value. No worthless valuables!
	 * 
	 * @param v is a Valuable object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable v) {
		if (!isFull() && v.getValue() > 0) {
			money.add(v);
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested money. Return an array of Valuable withdrawn from
	 * purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the valuable to withdraw
	 * @return array of valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {
		if (amount == null || amount.getValue() <= 0)
			return null;

		double amount_value = amount.getValue();
		String amount_curr = amount.getCurrency();

		Collections.sort(money, comp);

		List<Valuable> templist = new ArrayList<Valuable>();

		for (int i = count() - 1; i >= 0; i--) {
			double value = money.get(i).getValue();
			String currency = money.get(i).getCurrency();

			if (amount_value >= value && amount_curr.equals(currency)) {
				templist.add(money.get(i));
				Double diff = amount_value - value;
				DecimalFormat formatter = new DecimalFormat("0.00");
				String diff_str = formatter.format(diff);
				amount_value = Double.parseDouble(diff_str);
			}
		}

		if (amount_value == 0) {
			for (int i = 0; i < templist.size(); i++)
				money.remove(templist.get(i));
			Valuable[] array = new Valuable[templist.size()];
			templist.toArray(array);
			return array;
		}
		return null;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		return withdraw(new Money(amount, factory.getCurrency()));
	}

	/**
	 * Returns a string description of the purse contents.
	 * 
	 * @return describe of the purse.
	 */
	public String toString() {
		return count() + " valuables with value " + getBalance();
	}
}
