package coinpurse;

import java.util.List;
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

	private List<Valuable> money;
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
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>(capacity);
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
	 * Withdraw the requested amount of money. Return an array of Valuable withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		if (amount <= 0)
			return null;

		Collections.sort(money, comp);

		List<Valuable> templist = new ArrayList<Valuable>();

		for (int i = count() - 1; i >= 0; i--) {
			double value = money.get(i).getValue();
			if (amount >= value) {
				templist.add(money.get(i));
				amount -= value;
			}
		}

		if (amount == 0) {
			for (int i = 0; i < templist.size(); i++)
				money.remove(templist.get(i));
			Valuable[] array = new Valuable[templist.size()];
			templist.toArray(array);
			return array;
		}
		return null;
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
