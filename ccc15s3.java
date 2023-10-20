import java.util.*;
import java.io.*;

public class CCC15S3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		
		int g = Integer.parseInt(buf.readLine());		
		int p = Integer.parseInt(buf.readLine());		
		
		int[] gate = new int[g+1];
		
		int output = 0;
		for(int i = 0; i < p; i ++){
			int a = Integer.parseInt(buf.readLine());
			int o = a;
			boolean complete = false;
			if(gate[a] == 0){
				gate[a] = a-1;
				if(gate[o] == 0){
					gate[o] = -1;
				}
				output ++;
			}
			else{
				//System.out.println("THING");
				while(gate[a] != 0){
					a = gate[a];
					if(a == -1){
						break;
					}
				}
				//System.out.println(a);
				if(a > 0 ){
					gate[a] = o;
					gate[o] = a-1;
					if(a - 1 == 0){
						gate[o] = -1;
					}
					output ++;
				}else{
					break;
				}
				
			}
			
	 /*for(int j = a; j > 0; j -- ){
				
				
				if(gate[j] == 0){
					gate[j] = 1;
					output ++;
					complete = true;
					break;
				}
			}
*/
		}
		
//		for (int i = gate.length-1; i > 0; i --){
//			n += gate[i];
//			if(n > 0){
//				n --;
//				output ++;
//			}else{
//				break;
//			}
//
//		}
		
		System.out.println(output);
		
	}
	
}