package coinpurse;

/**
 * MoneyFactory is an abstract class for money factory.
 * 
 * @author Visurt Anuttivong
 */
public abstract class MoneyFactory {

	/* singleton instance of MoneyFactory. */
	private static MoneyFactory instance;

	/**
	 * Gets an instance of MoneyFactory.
	 * @return an object of a subclass
	 */
	public static MoneyFactory getInstance() {
		if (instance == null)
			instance = new ThaiMoneyFactory();
		return instance;
	}

	/**
	 * An abstract method for creating new money object in the local currency.
	 * @param value is the value of money
	 * @return a valuable with the value (parameter)
	 */
	public abstract Valuable createMoney(double value);

	/**
	 * Accepts money value as a String.
	 * @param value is a string value of money
	 * @return a valuable with the value (parameter)
	 */
	public Valuable createMoney(String value) {
		double val = 0;
		try {
			val = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The String does not contain a number");
		}
		return createMoney(val);
	}

	/**
	 * Sets the MoneyFactory object that is used.
	 * @param f is the factory to set
	 */
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}

	/**
	 * An abstract methods for getting the currency.
	 * 
	 * @return the currency
	 */
	public abstract String getCurrency();
}
