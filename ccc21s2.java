import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int m = Integer.parseInt(in.nextLine());
		int n = Integer.parseInt(in.nextLine());
		int k = Integer.parseInt(in.nextLine());
		int total = 0;
		//boolean[] canvas = new boolean[m];
		boolean[] paintedR = new boolean[m];
		boolean[] paintedC = new boolean[n];
		int goldV = 0;
		int goldH = 0;
		
		for(int i = 0; i < k; i ++){
			String[] next = in.nextLine().split(" ");
			int num = Integer.parseInt(next[1]);
			if (next[0].charAt(0) == 'R'){
				paintedR[num-1] = !paintedR[num-1];
			}
			if (next[0].charAt(0) == 'C'){
				paintedC[num-1] = !paintedC[num-1];
			}
		}
		
		for(int i  = 0; i < m; i ++){
			goldV += paintedR[i]?1:0;
		}
		for(int i  = 0; i < n; i ++){
			goldH += paintedC[i]?1:0;
		}
		total += goldH * (m - goldV);
		total += goldV * (n - goldH);
		System.out.println(total);

	}

}