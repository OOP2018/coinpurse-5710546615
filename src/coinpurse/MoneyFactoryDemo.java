package coinpurse;

/**
 * Test the MoneyFactory to create and call its methods. Print results on the
 * console. Shows MoneyFactory is a singleton and all methods works as
 * specified.
 * 
 * @author Visurt Anuttivong
 */
public class MoneyFactoryDemo {
	
	/**
	 * Starts testing
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Valuable m;

		System.out.println("--- THAILAND ---");
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory_t = MoneyFactory.getInstance();
		System.out.println("currency : " + factory_t.getCurrency());

		double[] arr_t = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

		for (int i = 0; i < arr_t.length; i++) {
			m = factory_t.createMoney(arr_t[i]);
			System.out.println(m);
		}

		System.out.println();

		System.out.println("--- MALAYSIA ---");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory factory_m = MoneyFactory.getInstance();
		System.out.println("currency : " + factory_m.getCurrency());

		double[] arr_m = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };

		for (int i = 0; i < arr_m.length; i++) {
			m = factory_m.createMoney(arr_m[i]);
			System.out.println(m);
		}
	}
}
