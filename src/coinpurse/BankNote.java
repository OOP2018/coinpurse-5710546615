package coinpurse;

/**
 * BankNote represent monetary with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class BankNote extends Money {
	/* The serial number of the bank note*/
	private long serialNumber;

	/**
	 * Initializes a new bank note.
	 * 
	 * @param value is the value of the bank note.
	 * @param currency is the currency of the bank note.
	 * @param serialNumber is the specific serial number of the bank note.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Returns a string description of the bank note contents.
	 * 
	 * @return describe of the bank note
	 */
	public String toString() {
		return (int)getValue() + " " + getCurrency() + " note [" + serialNumber + "]";
	}

}
