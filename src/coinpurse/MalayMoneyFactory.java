package coinpurse;

import java.util.stream.DoubleStream;

/**
 * MalayMoneyFactory is the subclass of MoneyFactory. This factory create money using the local currency.
 * 
 * @author Visurt Anuttivong
 */
public class MalayMoneyFactory extends MoneyFactory {

	/* Counter for serial number */
	private static long nextSerialNumber = 1000000;
	/* Default currency */
	public static final String CURRENCY = "Ringgit";
	/* A list of coin */
	private double[] coins = { 0.05, 0.10, 0.20, 0.50 };
	/* A list of bank note */
	private double[] notes = { 1, 2, 5, 10, 20, 50, 100 };

	/**
	 * Creates money by coin or bank note.
	 * 
	 * @param value is the value to create
	 * @return the valuable with the value (parameter)
	 */
	public Valuable createMoney(double value) {
		if (DoubleStream.of(coins).anyMatch(x -> x == value)) {
			return new Coin(value, CURRENCY);
		} else if (DoubleStream.of(notes).anyMatch(x -> x == value)) {
			return new BankNote(value, CURRENCY, nextSerialNumber++);
		}
		throw new IllegalArgumentException(value + " is not a valid currency value in Malaysia");
	}

	/**
	 * Gets the currency in Malaysia.
	 * 
	 * @return the currency
	 */
	public String getCurrency() {
		return CURRENCY;
	}
}
