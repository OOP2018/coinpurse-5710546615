package coinpurse;

/**
 * Money represent monetary with a fixed value and currency.
 * 
 * @author Visurt Anuttivong
 */
public class Money implements Valuable {
	
	/* the value of money */
	private double value;
	/* the currency of money */
	private String currency;

	/**
	 * Initializes a new money.
	 * 
	 * @param value is the value of the money.
	 * @param currency is the currency of the money.
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Compares a valuable with its value and also currency
	 * 
	 * @param o is the valuable to compare with
	 * @return positive if more, negative if less, zero if equal
	 */
	public int compareTo(Valuable o) {
		int result = getCurrency().compareTo(o.getCurrency());
		if (result == 0)
			result = Double.compare(getValue(), o.getValue());
		return result;
	}

	/**
	 * Gets the value of the money.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Gets the currency of the money.
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
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		Money m = (Money) obj;
		if (getValue() == m.getValue() && getCurrency().equals(m.getCurrency()))
			return true;
		return false;
	}
}
