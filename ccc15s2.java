import java.util.*;
import java.io.*;

public class CCC15S2 {


	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		
		HashMap<String,Integer> h = new HashMap<>();

		h.put("S", 1);
		h.put("M", 2);
		h.put("L", 3);
		
		int j = Integer.parseInt(buf.readLine());
		int a = Integer.parseInt(buf.readLine());
		
		int total = 0;
		
		int[] l = new int[j];
		
		for (int i = 0; i < j; i ++){
			l[i] = h.get( buf.readLine());
		}
		
		for (int i = 0; i < a; i ++){
			String[] line = buf.readLine().split(" ");
			int ha = Integer.parseInt(line[1])-1;
			int lol = l[ha];
			if(lol != 0){
				if( h.get(line[0]) <= lol ){
					total ++;
					l[ha] = 0;
				}
			}
		}
		System.out.println(total);
		
	}
	
}