package coinpurse.strategy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Withdraw strategy using greedy algorithm. To simplify a simple withdrawal.
 * 
 * @author Visurt Anuttivong
 */
public class GreedyWithdraw implements WithdrawStrategy {

	private Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Withdraw valuable in a list of valuable. By selecting the largest amount
	 * first then smaller come over.
	 * 
	 * @param amount is the amount of valuable that we want to withdraw
	 * @param items is a list of valuable
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		if (amount == null || items == null || items.size() <= 0)
			return null;
		
		if (amount.getValue() == 0)
			return new ArrayList<Valuable>();

		double amount_value = amount.getValue();
		String amount_curr = amount.getCurrency();

		items.sort(comp);

		List<Valuable> templist = new ArrayList<Valuable>();

		for (int i = items.size() - 1; i >= 0; i--) {
			double value = items.get(i).getValue();
			String currency = items.get(i).getCurrency();

			if (amount_value >= value && amount_curr.equals(currency)) {
				templist.add(items.get(i));
				Double diff = amount_value - value;
				DecimalFormat formatter = new DecimalFormat("0.00");
				String diff_str = formatter.format(diff);
				amount_value = Double.parseDouble(diff_str);
			}
		}

		templist.sort(comp);

		if (amount_value == 0)
			return templist;

		return null;
	}
}