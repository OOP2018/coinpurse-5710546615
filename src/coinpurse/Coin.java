package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class Coin extends Money {

	/**
	 * Initializes a new coin.
	 * 
	 * @param value is the value of the coin.
	 * @param currency is the currency of the coin.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Returns a string description of the coin contents.
	 * 
	 * @return describe of the coin
	 */
	public String toString() {
		return getValue() + "-" + getCurrency();
	}
}