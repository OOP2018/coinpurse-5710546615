package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MoneyUtil demonstrate that compareTo is correct and can be sort the coins by
 * value.
 * 
 * @author Visurt Anuttivong
 */
public class MoneyUtil {

	/**
	 * Configure and test sorting.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(5.0, "US Dollar"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(1.0, "US Dollar"));
		coins.add(new Coin(10.0, "US Dollar"));
		coins.add(new Coin(5.0, "Baht"));

		List<Coin> THB = filterByCurrency(coins, "Baht");
		List<Coin> US = filterByCurrency(coins, "US Dollar");

		sortCoins(THB);
		sortCoins(US);
	}

	/**
	 * Returns a List of Coins that contains only the coins from coins (the
	 * parameter) that have same currency as the currency parameter.
	 * 
	 * @param coins is a List of Coin
	 * @param currency the currency that select
	 * @return a list of coins that already filtered
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> templist = new ArrayList<Coin>();
		for (Coin coin : coins)
			if (coin.getCurrency().equals(currency))
				templist.add(coin);
		return templist;
	}

	/**
	 * Sorts a List of coins and print the result on the console.
	 * 
	 * @param coins is a List of coin that is/isn't sort yet
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
		printCoins(coins);
	}

	/**
	 * Prints each of elements in a List to console.
	 * 
	 * @param coins is a List of coins to print out
	 */
	public static void printCoins(List<Coin> coins) {
		for (Coin coin : coins)
			System.out.println(coin);
	}
}