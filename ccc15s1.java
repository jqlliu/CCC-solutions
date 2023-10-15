import java.util.*;

public class CCC15S1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		int n = in.nextInt();
		int tot = 0;
		for(int i = 0; i < n; i ++){
			int num = in.nextInt();
			if(num == 0){
				tot -= a.get(a.size() - 1);
				a.remove(a.size()-1);
			
			}else{
			a.add(num);
			tot += num;
			}
		}
			
		System.out.println(tot);
		
	}
	
}