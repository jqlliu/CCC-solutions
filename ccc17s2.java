import java.util.*;

/**
 *
 * @author sovie
 */
public class CCC17S2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		 Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        
        int input[] = new int[total];
	  int output[] = new int[total];
        for(int i = 0; i < total; i ++){
            
            input[i] = in.nextInt();
        }
	  
	  Arrays.sort(input);
	  
	  int low = (int)Math.ceil(total/2.0)-1;
	  
	  int high = low + 1;
	  int a = low;
	  for(int i = 0; i <= a; i ++){
		  output[i*2] = input[low - i];
	  }
	  
	  for(int i = 0; i < total- a-1; i ++){
		  output[1 + i*2] = input[high + i];
	  }
	  for (int v:output){
		  System.out.print(v + " ");
	  }
        
	}
	
}