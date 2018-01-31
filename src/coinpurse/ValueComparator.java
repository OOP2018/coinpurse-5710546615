package coinpurse;

import java.util.Comparator;

/**
 * ValueComparator acts as comparator to order all kind of money.
 * 
 * @author Visurt Anuttivong
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two objects that implement Valuable. First compare them by currency.
	 * If both objects have the same currency, order them by values.
	 */
	public int compare(Valuable a, Valuable b) {
		int result = a.getCurrency().compareTo(b.getCurrency());
		if (result == 0)
			result = Double.compare(a.getValue(), b.getValue());
		return result;
	}
}