package coinpurse;

/**
 * BankNote represent monetary with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class BankNote extends Money {

	private static long nextSerialNumber = 1000000;
	private long serialNumber = 1000000;

	/**
	 * Initializes a new bank note.
	 * 
	 * @param value is the value of the bank note.
	 * @param currency is the currency of the bank note.
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		serialNumber = nextSerialNumber++;
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
	 * Returns a string description of the bank note contents.
	 * 
	 * @return describe of the bank note
	 */
	public String toString() {
		return getValue() + "-" + getCurrency() + " note [" + serialNumber + "]";
	}

}
