import java.util.*;

/**
 *
 * @author sovie
 */
public class CCC18S1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();

		int[] locations = new int[total];

		for (int i = 0; i < total; i++) {
			locations[i] = in.nextInt();
		}
		Arrays.sort(locations);
		double min = 1000000000;
		for (int i = 1; i < total - 1; i++) {
			double size = 0;
			double avg1 = locations[i + 1] - locations[i];
			//Odd(+0)
			size += avg1 / 2.0;
			double avg2 = locations[i] - locations[i - 1];
			size += avg2 / 2.0;
			//size = Math.round(size*10)/10;
			if (size < min) {
				min = size;
			}
		}
		//System.out.println((double)Math.round(min*10)/10);
		System.out.printf("%.1f",min);
	}

}