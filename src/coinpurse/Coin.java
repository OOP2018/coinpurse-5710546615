package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class Coin implements Comparable<Coin> {

	private double value;
	private String currency;

	/**
	 * Initializes a new coin.
	 * 
	 * @param value is the value of the coin.
	 * @param currency is the currency of the coin.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Gets the value of the coin.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Gets the currency of the coin.
	 * 
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Checks an object equal or not.
	 * 
	 * @param arg is the object compare with
	 * @return true if equal, false otherwise
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;

		Coin c = (Coin) arg;
		if (value == c.getValue() && currency == c.getCurrency())
			return true;
		return false;
	}

	/**
	 * Checks a coin with its value which is equal, more or less.
	 * 
	 * @param coin is the coin compare with
	 * @return 0 if equal, 1 if more, -1 if less
	 */
	public int compareTo(Coin coin) {
		return Integer.compare((int) value, (int) coin.getValue());
	}

	/**
	 * Returns a string description of the coin contents.
	 * 
	 * @return describe of the coin
	 */
	public String toString() {
		return value + "-" + currency;
	}
}