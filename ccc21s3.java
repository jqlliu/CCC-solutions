import java.util.*;
import java.io.*;

public class Main {


	static long[] pos, spd, dis;
	static long largest = 0;
	public static void main(String[] args) {
		// TODO code application logic here

		Scanner input = new Scanner(System.in);
		int total = input.nextInt();
		pos = new long[total];
		spd = new long[total];
		dis = new long[total];

		boolean looping = true;

		for (int i = 0; i < total; i++) {
			int position = input.nextInt();
			int walk = input.nextInt();
			int distance = input.nextInt();
			pos[i] = position;
			spd[i] = walk;
			dis[i] = distance;
			
		}

		long[] sortedPos = pos.clone();
		Arrays.sort(sortedPos);
		long currentL = sortedPos[0];
		long currentR = sortedPos[total - 1];
		largest = currentR;
		while (looping) {
			long point = (currentL + currentR) / 2;

			long t = getTotalTime(point);

			long before = getTotalTime(point-1);
			long after = getTotalTime(point+1);
			
			//System.out.println(t + " " + before + " " + after);
			//System.out.println(point + " " + currentL + " " + currentR);
			if (before < t && before <=  after) {
				currentR = point;
			} else if (after < t && before > after ) {
				currentL = point;
			} 
			if(before >= t && after >= t) {
				System.out.println(t);
				looping = false;
			}
		}
	}

	static long getTotalTime(long position) {
		long r = 0;
		if (position >= 0 && position < largest) {
		//System.out.println(position);
			for (int i = 0; i < pos.length; i++) {

				if (Math.abs(position - pos[i]) - dis[i] > 0) {
					r += (Math.abs(position - pos[i]) - dis[i]) * spd[i];
					//System.out.println((Math.abs(position - pos[i]) - dis[i]) * spd[i]);
				}

			}
		}
		
		return r;
	}

}