import java.util.*;

public class CCC11S3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic hereS
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0; i < t; i ++){
			int m = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			
			boolean can = generateResult(x,y,m);
			if(can){
				System.out.println("crystal");
			}else{
				System.out.println("empty");
			}
		}
		
		
	}
	static boolean generateResult(int x, int y, int m){
			int grid = (int)Math.pow(5, m);
			
			int sector = grid/5;
			//System.out.println(grid + " " + sector + " " + m);
			int rx = x/sector;
			int ry = y/sector;
			
			if(  (ry == 0 && rx != 0 && rx != 4) || (ry == 1 && rx == 2)   ){
				return true;
			}else{
				if(( ry == 1 && (rx == 1 || rx == 3) || ry == 2 && rx == 2 )  && m > 1 ){
					return generateResult( x - rx*sector, y - ry * sector, m - 1);
				}else{
					
			return false;
				}
				
			}
			
			//return false;
	}
	
}