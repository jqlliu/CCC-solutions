import java.util.*;
import java.io.*;


public class CCC18S2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		//INPUT
		int total = Integer.parseInt(buf.readLine());
		int[][] list = new int[total][total];

		for (int i = 0; i < total; i++) {
			String ln = buf.readLine();
			String[] lnSpt = ln.split(" ");
			for (int j = 0; j < lnSpt.length; j++) {
				list[i][j] = Integer.parseInt(lnSpt[j]);
			}
		}
		//Get direction
		int[][] output = dupe(list);
		int rotation = 0;
		if (list[0][0] < list[0][1] && list[0][0] < list[1][0]) {
			rotation = 0;
		}
		if (list[0][0] > list[0][1] && list[0][0] > list[1][0]) {
			rotation = 2;
		}
		if (list[0][0] < list[0][1] && list[0][0] > list[1][0]) {
			rotation = 1;
		}
		if (list[0][0] > list[0][1] && list[0][0] < list[1][0]) {
			rotation = 3;
		}
		for (int a = 0; a < rotation; a++) {
			for (int i = 0; i < total; i++) {
				for (int j = 0; j < total; j++) {

					output[j][total-1-i] = list[i][j];
				}
			}
			list = dupe(output);
		}
		for(int[] v:output){
			for(int w:v){
				System.out.print(w + " ");
			}
			System.out.print("\n");
		}
	}
	static int[][] dupe(int[][] list){
		int[][] ret = new int[list.length][list[0].length];
		for(int i = 0; i < list.length; i ++){
			for(int j = 0; j < list[i].length; j ++){
				ret[i][j] = list[i][j];
			}
		}
		return ret;
	}

}
