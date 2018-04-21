package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
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

	/* Counter for serial number */
	private static long nextSerialNumber = 1000000;
	/* A comparator for valuable */
	private static Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Configure and test sorting.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		// Testing Max with String
		String max1 = max("dog", "zebra", "cat");
		System.out.println(max1); // return zebra

		// Testing Max with Integer
		int max2 = max(1, 5, 10);
		System.out.println(max2); // return 10

		// Testing Max with Money
		Money m1 = new BankNote(100, "Baht", nextSerialNumber++);
		Money m2 = new BankNote(500, "Baht", nextSerialNumber++);
		Money m3 = new Coin(20, "Baht");
		Money max = max(m1, m2, m3);
		System.out.println(max); // return m2

		// Testing sortMoney with bank note
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD", nextSerialNumber++));
		list.add(new BankNote(500.0, "Baht", nextSerialNumber++));
		sortMoney(list); // sorted money by currency before value

		// Testing filterByCurrency with coin
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht"); // Error
		System.out.println(result); // return 5 baht coin
	}

	/**
	 * Returns a List of Valuable that contains only the valuable from vals (the
	 * parameter) that have same currency as the currency parameter.
	 * 
	 * @param vals is a List of Valuable
	 * @param currency the currency that select
	 * @return a list of valuables that already filtered
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<? extends E> vals, String currency) {
		List<E> templist = new ArrayList<E>();
		for (E val : vals)
			if (val.getCurrency().equals(currency))
				templist.add(val);
		return templist;
	}

	/**
	 * Sorts a List of valuables and print the result on the console.
	 * 
	 * @param money is a List of valuables that is/isn't sort yet
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		Collections.sort(money, comp);
		printMoney(money);
	}

	/**
	 * Prints each of elements in a List to console.
	 * 
	 * @param money is a List of valuables to print out
	 */
	public static void printMoney(List<? extends Valuable> money) {
		for (Valuable val : money)
			System.out.println(val);
	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		try {
			E max = args[0];
			for (E each : args)
				if (each.compareTo(max) > 0)
					max = each;
			return max;
		} catch (NullPointerException ex) {
			throw new IllegalArgumentException();
		}
	}
}