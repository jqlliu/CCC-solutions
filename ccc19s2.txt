import java.util.*;
public class CCC19S2 {

	/**
	 * @param args the command line arguments
	 */
	static ArrayList<Integer> primes = new ArrayList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		for (int i = 0; i < total; i++) {

			int n = in.nextInt();
			int c = 0;
			while (prime(n + c) == false || prime(n - c) == false) {
				c++;
			}
			System.out.println((n + c) + " " + (n - c));

		}
	}

	static boolean prime(int n) {

		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}