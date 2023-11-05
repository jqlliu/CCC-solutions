import java.util.*;
import java.io.*;

public class CCC18S3 {

	/**
	 * @param args the command line arguments
	 */
	static char[][] grid;

	static node[][] map;
	static int x, y;
	static boolean[][] checked;
	static int[][] output;
	static boolean impossible = false;

	public static void main(String[] args) throws IOException {
		//initial setup
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(in);
		String[] first = buf.readLine().split(" ");
		x = Integer.parseInt(first[0]);
		y = Integer.parseInt(first[1]);
		grid = new char[x][y];
		map = new node[x][y];
		output = new int[x][y];
		ArrayList<coord> thisLayer = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			String ln = buf.readLine();
			for (int j = 0; j < y; j++) {
				grid[i][j] = ln.charAt(j);
				map[i][j] = new node();
			}
		}

		//Convert all camera lines into O
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (grid[i][j] == 'C') {
					convertCamera(i, j);
				}
			}
		}
		//Initiate nodes

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (grid[i][j] == '.') {
					if (checkTile(i, j - 1)) {
						map[i][j].move[0] = true;
					}
					if (checkTile(i, j + 1)) {
						map[i][j].move[1] = true;
					}
					if (checkTile(i - 1, j)) {
						map[i][j].move[2] = true;
					}
					if (checkTile(i + 1, j)) {
						map[i][j].move[3] = true;
					}
					//finished ++;
				} else {
					switch (grid[i][j]) {
						case 'U':
							if (checkTile(i - 1, j)) {
								map[i][j].move[2] = true;
							}
							break;
						case 'D':
							if (checkTile(i + 1, j)) {
								map[i][j].move[3] = true;
							}
							break;
						case 'L':
							if (checkTile(i, j - 1)) {
								map[i][j].move[0] = true;
							}
							break;
						case 'R':
							if (checkTile(i, j + 1)) {
								map[i][j].move[1] = true;
							}
							break;
						case 'S':
							output[i][j] = 0;
							thisLayer.add(new coord(i, j));
							if (checkTile(i, j - 1)) {
								map[i][j].move[0] = true;
							}
							if (checkTile(i, j + 1)) {
								map[i][j].move[1] = true;
							}
							if (checkTile(i - 1, j)) {
								map[i][j].move[2] = true;
							}
							if (checkTile(i + 1, j)) {
								map[i][j].move[3] = true;
							}
							break;

					}
				}
			}
		}
		boolean canMove = false;
		int layer = 0;
		/*
		for(int i = 0; i < x; i ++){
			for(int j = 0; j < y; j ++){
				System.out.print(grid[i][j]);
			}
			System.out.println("");
		}
		 */
		if (impossible == false) {
			do {
				canMove = false;
				ArrayList<coord> nextLayer = new ArrayList<>();
				for (int i = 0; i < thisLayer.size(); i++) {
					int ax = thisLayer.get(i).x;
					int ay = thisLayer.get(i).y;
					int convey = 1;
					//for (int a = 0; a < thisLayer.size(); a++) {
					//	System.out.println(thisLayer.get(i).x + " " + thisLayer.get(i).y);
					//}
					if (grid[ax][ay] == 'U' || grid[ax][ay] == 'D' || grid[ax][ay] == 'L' || grid[ax][ay] == 'R') {
						convey = 0;
					}
					if (map[ax][ay].move[0] && (output[ax][ay - 1] == 0 || output[ax][ay - 1] > output[ax][ay] + convey)) {
						nextLayer.add(new coord(ax, ay - 1));
						output[ax][ay - 1] = output[ax][ay] + convey;
						canMove = true;
					}
					if (map[ax][ay].move[1] && (output[ax][ay + 1] == 0 || output[ax][ay + 1] > output[ax][ay] + convey)) {
						nextLayer.add(new coord(ax, ay + 1));
						output[ax][ay + 1] = output[ax][ay] + convey;
						canMove = true;
					}
					if (map[ax][ay].move[2] && (output[ax - 1][ay] == 0 || output[ax - 1][ay] > output[ax][ay] + convey)) {
						nextLayer.add(new coord(ax - 1, ay));
						output[ax - 1][ay] = output[ax][ay] + convey;
						canMove = true;
					}
					if (map[ax][ay].move[3] && (output[ax + 1][ay] == 0 || output[ax + 1][ay] > output[ax][ay] + convey)) {
						nextLayer.add(new coord(ax + 1, ay));
						output[ax + 1][ay] = output[ax][ay] + convey;
						canMove = true;
					}

				}

				layer++;
				thisLayer = nextLayer;
			} while (canMove);
		}
		//output[2][2] = 6;
		//output[2][1] = 7;
		/*
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println("");
		}
		 */
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (grid[i][j] == '.' || grid[i][j] == 'O') {
					if (output[i][j] != 0 && grid[i][j] != 'O') {
						System.out.println(output[i][j]);
					} else {
						System.out.println(-1);
					}
				}
			}
		}

	}

	static void convertCamera(int i, int j) {
		int cx = i;
		int cy = j;
		while (grid[cx][cy] != 'W') {
			cx--;
			if (grid[cx][cy] == '.') {
				//O is equivilant to wall
				grid[cx][cy] = 'O';
			}
			if (grid[cx][cy] == 'S') {
				impossible = true;
			}
		}
		cx = i;
		while (grid[cx][cy] != 'W') {
			cx++;
			if (grid[cx][cy] == '.') {
				grid[cx][cy] = 'O';
			}
			if (grid[cx][cy] == 'S') {
				impossible = true;
			}
		}
		cx = i;
		while (grid[cx][cy] != 'W') {
			cy--;
			if (grid[cx][cy] == '.') {
				//O is equivilant to wall
				grid[cx][cy] = 'O';
			}
			if (grid[cx][cy] == 'S') {
				impossible = true;
			}
		}
		cy = j;
		while (grid[cx][cy] != 'W') {
			cy++;
			if (grid[cx][cy] == '.') {
				//O is equivilant to wall
				grid[cx][cy] = 'O';
			}
			if (grid[cx][cy] == 'S') {
				impossible = true;
			}
		}
	}

	static boolean checkTile(int i, int j) {
		if (i >= 0 && i < x && j >= 0 && j < y) {
			if (grid[i][j] == '.' || grid[i][j] == 'U' || grid[i][j] == 'D' || grid[i][j] == 'L' || grid[i][j] == 'R') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

class node {

	boolean[] move;
	int[] conv;

	//Up down left right
	node() {
		this.move = new boolean[4];
		this.conv = new int[3];
	}

}

class coord {

	int x, y;

	coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

}