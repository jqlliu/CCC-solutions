import java.util.*;
import java.io.*;

public class CCC14S3 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {

		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);

		int t = Integer.parseInt(buf.readLine());

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(buf.readLine());
			Deque<Integer> branch = new LinkedList<>();
			Deque<Integer> track = new LinkedList<>();
			int next = 1;

			for (int j = 0; j < n; j++) {

				track.push(Integer.parseInt(buf.readLine()));

			}

			while (!track.isEmpty() || !branch.isEmpty()) {
				if (!track.isEmpty()) {
					int num = track.peek();
//					System.out.println("Current: " + num);
					if (num == next) {
						next++;
						track.remove();
//						System.out.println("Match " + num);
					} else {
						if (!branch.isEmpty() && branch.peek()== next) {
							next++;
							int a = branch.poll();
							
//							System.out.println("Out " + a);
							
						} else {

							branch.push(num);
							track.remove();

//							System.out.println("In "+num);
						}
					}
				}else{
//					System.out.println("Final " + branch.peek() + " Match? "  + next);
					if(!branch.isEmpty() && branch.peek() == next){
						next ++;
						branch.remove();
					}else{
						
						break;
						
						
					}
				}
			}

//			System.out.println(next + " " + n );
			if (next == n + 1) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}

		}

	}

}