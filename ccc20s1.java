import java.util.*;

public class CCC20S1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		double max = 0;
		int[] time = new int[total];
		HashMap<Integer, Integer> position = new HashMap<>();
		for (int i = 0; i < total; i++) {
			time[i] = scan.nextInt();
			position.put(time[i], scan.nextInt());
		}
		Arrays.sort(time);
		for (int i = 1; i < time.length; i++) {
			double next = (double)  Math.abs(position.get(time[i]) - position.get(time[i - 1])) / Math.abs(time[i] - time[i - 1]) ;
			if (next > max) {
				max = next;
			}
		}
		System.out.println(max);

	}

}