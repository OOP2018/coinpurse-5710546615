package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Valuable;

public class WithdrawTest {

	private WithdrawStrategy strategy;
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";
	private static long nextSerialNumber = 1000000;

	/**
	 * Code to run before each test. Setup the "test fixture".
	 */
	@Before
	public void setUp() {
		strategy = new GreedyWithdraw();
		// strategy = new RecursiveWithdraw();
	}

	/**
	 * Make a coin with the default currency. To save typing "new Coin(...)"
	 */
	private Valuable makeMoney(double value) {
		if (value >= 20)
			return new BankNote(value, CURRENCY, nextSerialNumber++);
		return new Coin(value, CURRENCY);
	}

	/**
	 * Withdraw is working as expect.
	 */
	@Test
	public void testIsWorking() {
		List<Valuable> items = new ArrayList<Valuable>();
		items.add(makeMoney(10));
		items.add(makeMoney(5));
		items.add(makeMoney(1));
		List<Valuable> result = strategy.withdraw(makeMoney(15), items);
		assertTrue(result.contains(makeMoney(10)));
	}

	/**
	 * Withdraw zero value from list.
	 */
	@Test
	public void testZeroValue() {
		List<Valuable> items = new ArrayList<Valuable>();
		items.add(makeMoney(1));
		items.add(makeMoney(2));
		items.add(makeMoney(5));
		List<Valuable> result = strategy.withdraw(makeMoney(0), items);
		assertEquals(result.size(), 0, TOL);
	}

	/**
	 * Withdraw negative value from list.
	 */
	@Test
	public void testNegativeValue() {
		List<Valuable> items = new ArrayList<Valuable>();
		items.add(makeMoney(20));
		items.add(makeMoney(100));
		items.add(makeMoney(50));
		assertNull(strategy.withdraw(makeMoney(-50), items));
	}

	/**
	 * Withdraw valuable from empty list.
	 */
	@Test
	public void testEmptyList() {
		List<Valuable> items = new ArrayList<Valuable>();
		items.add(makeMoney(100));
		items.add(makeMoney(500));
		items.add(makeMoney(1000));
		strategy.withdraw(makeMoney(1600), items);
		assertNull(strategy.withdraw(makeMoney(10), items));
	}

	/**
	 * Withdraw from null valuable and list.
	 */
	@Test
	public void testNullValuableAndList() {
		List<Valuable> items = null;
		Valuable amount = null;
		assertNull(strategy.withdraw(amount, items));
	}

	/**
	 * Withdraw different currency.
	 */
	@Test
	public void testDifferentCurrency() {
		List<Valuable> items = new ArrayList<Valuable>();
		items.add(new Coin(10, "Baht"));
		items.add(new Coin(5, "Baht"));
		items.add(new Coin(2, "US"));
		items.add(new Coin(1, "US"));
		assertNotNull(strategy.withdraw(new Coin(3, "US"), items));
		assertNull(strategy.withdraw(new Coin(3, "Baht"), items));
	}
}