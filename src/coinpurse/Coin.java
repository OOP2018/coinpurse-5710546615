package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class Coin extends Money {

	/* The value of the coin */
	private double modifyValue;
	/* The currency of the coin */
	private String modifyCurrency;

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
		modify(getValue(),getCurrency());
		return (int) modifyValue + "-" + modifyCurrency + " coin";
	}

	/**
	 * Helper method to set and modify the value and currency for some country.
	 * 
	 * @param value is the value to modify
	 * @param currency is the currency to modify
	 */
	public void modify(double value, String currency) {
		modifyValue = value;
		modifyCurrency = currency;
		if (value < 1 && currency.equals("Ringgit")) {
			modifyValue *= 100;
			modifyCurrency = "Sen";
		}
	}
}