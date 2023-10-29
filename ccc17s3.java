import java.util.*;
import java.io.*;

/**
 *
 * @author sovie
 */
public class CCC17S3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		int[] heights = new int[2001];

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		int max = 1;
		int maxTotal = 0;
		int total = Integer.parseInt(buf.readLine());
		String[] nl = buf.readLine().split(" ");
		for (String v : nl) {
			int n = Integer.parseInt(v);
			heights[n]++;
		}
		int a = 0;
		int b = 0;
		for (int i = 2000; i >= 0; i--) {
			if (heights[i] > 0) {
				b += i;
				a += 1;
			}
			if (heights[i] > 1) {
				b += i;
				a += 1;
			}
			if (a >= 2) {
				break;
			}

		}
		for (int h = 1; h < 4001; h++) {
			//int[] ch = new int[2001];
			int c = 0;
			boolean[] ch = new boolean[2001];
			for (int i = 1; i < 2001; i++) {
				
				if (h - i >= 0 && h - i < 2001 && h-i != i && ch[i] == false&& ch[h-i] == false) {
					int add = Math.min(heights[i], heights[h - i]);
					c += add;
					ch[i] = true;
					ch[h-i] = true;
					//System.out.println(i +" " + j + " " + h);
					//System.out.println(heights[i] + " " + heights[h-i] );
					//ch[i] += add;
					//ch[h-i] += add;

				}else if(h - i >= 0 && h - i < 2001 && h-i==i){
					int add = heights[i]/2;
					c += add;
				}
			}
			if (c > max) {
				max = c;
				maxTotal = 1;
			} else if (c == max) {
				maxTotal++;
			}

		}

		System.out.print(max + " " + maxTotal);

	}

}