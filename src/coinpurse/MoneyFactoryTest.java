package coinpurse;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the MoneyFactory using JUnit. This is a JUnit 4 test suite.
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4, but you have to
 * tell the IDE to add it to your project as a "Library". To run these tests,
 * right click on this file (in Project panel) and choose Run As -> JUnit test
 * 
 * @author Visurt Anuttivong
 */
public class MoneyFactoryTest {

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	@Test(timeout = 1000)
	public void testInstance() {
		assertNotNull(MoneyFactory.getInstance());
	}

	@Test(timeout = 1000)
	public void testSetFactory() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory_t = MoneyFactory.getInstance();

		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory_m = MoneyFactory.getInstance();
		assertNotEquals(factory_t.getClass(), factory_m.getClass());
	}

	@Test(timeout = 1000)
	public void testCurrency() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory_t = MoneyFactory.getInstance();
		assertEquals("Baht", factory_t.getCurrency());

		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory_m = MoneyFactory.getInstance();
		assertEquals("Ringgit", factory_m.getCurrency());
	}

	@Test(timeout = 1000)
	public void testCreateMoneyWithDouble() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory_t = MoneyFactory.getInstance();
		double[] arr_t = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		for (int i = 0; i < arr_t.length; i++) {
			assertNotNull(factory_t.createMoney(arr_t[i]));
		}

		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory_m = MoneyFactory.getInstance();
		double[] arr_m = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
		for (int i = 0; i < arr_m.length; i++) {
			assertNotNull(factory_m.createMoney(arr_m[i]));
		}
	}

	@Test(timeout = 1000)
	public void testCreateMoneyWithString() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory_t = MoneyFactory.getInstance();
		double[] arr_t = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		String[] arr_ts = { "1", "2", "5", "10", "20", "50", "100", "500", "1000" };
		for (int i = 0; i < arr_t.length; i++) {
			assertEquals(factory_t.createMoney(arr_t[i]), factory_t.createMoney(arr_ts[i]));
		}

		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory_m = MoneyFactory.getInstance();
		double[] arr_m = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
		String[] arr_ms = { "0.05", "0.10", "0.20", "0.50", "1", "2", "5", "10", "20", "50", "100" };
		for (int i = 0; i < arr_m.length; i++) {
			assertEquals(factory_m.createMoney(arr_m[i]), factory_m.createMoney(arr_ms[i]));
		}
	}

	@Test(timeout = 1000)
	public void testToStringInMalayCurrency() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		assertEquals("Ringgit", factory.createMoney(0.05).getCurrency());
		assertEquals("Ringgit", factory.createMoney(0.10).getCurrency());
		assertEquals("Ringgit", factory.createMoney(0.20).getCurrency());
		assertEquals("Ringgit", factory.createMoney(0.50).getCurrency());

		assertEquals("5-Sen coin", factory.createMoney(0.05).toString());
		assertEquals("10-Sen coin", factory.createMoney(0.10).toString());
		assertEquals("20-Sen coin", factory.createMoney(0.20).toString());
		assertEquals("50-Sen coin", factory.createMoney(0.50).toString());
	}

}
