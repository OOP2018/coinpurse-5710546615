package coinpurse;

/**
 * BankNote represent monetary with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class BankNote implements Valuable {

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;

	/**
	 * Initializes a new bank note.
	 * 
	 * @param value is the value of the bank note.
	 * @param currency is the currency of the bank note.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		serialNumber = nextSerialNumber++;
	}

	/**
	 * Gets the value of the bank note.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Gets the currency of the bank note.
	 * 
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Gets the serial number of the bank note.
	 * 
	 * @return the serial number
	 */
	public long getSerial() {
		return serialNumber;
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

		BankNote b = (BankNote) arg;
		if (value == b.getValue() && currency.equals(b.getCurrency()))
			return true;
		return false;
	}

	/**
	 * Returns a string description of the bank note contents.
	 * 
	 * @return describe of the bank note
	 */
	public String toString() {
		return value + "-" + currency + " note [" + serialNumber + "]";
	}

}
