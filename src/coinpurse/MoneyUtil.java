package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * MoneyUtil demonstrate that compareTo is correct and can be sort the coins by
 * value.
 * 
 * @author Visurt Anuttivong
 */
public class MoneyUtil {

	private static Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Configure and test sorting.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		List<Valuable> vals = new ArrayList<Valuable>();
		vals.add(new Coin(10.0, "Baht"));
		vals.add(new Coin(0.5, "Baht"));
		vals.add(new Coin(5.0, "US Dollar"));
		vals.add(new Coin(2.0, "Baht"));
		vals.add(new Coin(1.0, "Baht"));
		vals.add(new Coin(1.0, "US Dollar"));
		vals.add(new Coin(10.0, "US Dollar"));
		vals.add(new Coin(5.0, "Baht"));

		vals.add(new BankNote(10.0, "Baht"));
		vals.add(new BankNote(0.5, "Baht"));
		vals.add(new BankNote(5.0, "US Dollar"));
		vals.add(new BankNote(2.0, "Baht"));
		vals.add(new BankNote(1.0, "Baht"));
		vals.add(new BankNote(1.0, "US Dollar"));
		vals.add(new BankNote(10.0, "US Dollar"));
		vals.add(new BankNote(5.0, "Baht"));

		List<Valuable> THB = filterByCurrency(vals, "Baht");
		List<Valuable> US = filterByCurrency(vals, "US Dollar");

		sortCoins(THB);
		sortCoins(US);
	}

	/**
	 * Returns a List of Valuable that contains only the valuable from vals (the
	 * parameter) that have same currency as the currency parameter.
	 * 
	 * @param vals is a List of Valuable
	 * @param currency the currency that select
	 * @return a list of valuables that already filtered
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> vals, String currency) {
		List<Valuable> templist = new ArrayList<Valuable>();
		for (Valuable val : vals)
			if (val.getCurrency().equals(currency))
				templist.add(val);
		return templist;
	}

	/**
	 * Sorts a List of valuables and print the result on the console.
	 * 
	 * @param vals is a List of valuables that is/isn't sort yet
	 */
	public static void sortCoins(List<Valuable> vals) {
		Collections.sort(vals, comp);
		printCoins(vals);
	}

	/**
	 * Prints each of elements in a List to console.
	 * 
	 * @param vals is a List of valuables to print out
	 */
	public static void printCoins(List<Valuable> vals) {
		for (Valuable val : vals)
			System.out.println(val);
	}
}