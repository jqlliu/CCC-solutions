import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		double[] m = new double[total+1];
		double[] n = new double[total];
		double area = 0;
		for(int i  = 0; i < m.length; i ++){
			
			m[i] = (double)in.nextInt();
		}
		for(int i  = 0; i < n.length; i ++){
			double add = (m[i] + m[i + 1])/2.0 * (double)in.nextInt() ;
			area += add;
		}
		System.out.println(area);
		
	}
	
}