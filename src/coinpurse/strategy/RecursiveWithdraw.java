package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Withdraw strategy using recursive algorithm. To be a good running time.
 * 
 * @author Visurt Anuttivong
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	/**
	 * Withdraw valuable in a list of valuable. By recursively unordered in a list.
	 * 
	 * @param amount is the amount of valuable that we want to withdraw
	 * @param items is a list of valuable
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		if (amount == null || items == null)
			return null;
		
		if (amount.getValue() == 0)
			return new ArrayList<Valuable>();

		if (items.isEmpty())
			return null;

		Valuable last = items.get(items.size() - 1);
		Valuable remaining = new Money(amount.getValue() - last.getValue(), last.getCurrency());
		List<Valuable> result;

		if (amount.getCurrency().equals(last.getCurrency())) {
			result = withdraw(remaining, items.subList(0, items.size() - 1));
			if (result != null) {
				result.add(last);
				return result;
			}
			result = withdraw(amount, items.subList(0, items.size() - 1));
			if (result != null)
				return result;
		}
		return null;
	}
}