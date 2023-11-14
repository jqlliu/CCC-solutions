import java.util.*;
import java.io.*;

public class ccc20s2 {

    public static void main(String args[]){

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);
        int m, n;
        int[][] map;

        try{
            m = Integer.parseInt(buf.readLine());
            n = Integer.parseInt(buf.readLine());
            map = new int[m+1][n+1];
            boolean yes = false;
            for(int i = 0; i < m; i ++){
                String ln = buf.readLine();
                String[] s = ln.split(" ");
                for(int j = 0; j < n; j ++){
                    map[i+1][j+1] = Integer.parseInt(s[j]);
                }
            }
                //bfs
                Queue<Vector> next = new LinkedList<>();
                next.add(new Vector(1,1));
                int it = 0;
                while(!next.isEmpty()){
                    it ++;
                    Vector a = next.poll();
                    //prime factor
                    if(a.x < m+1 && a.y < n+1 ) {
                        int num = map[a.x][a.y];
                        if (a.x == m && a.y == n) {
                            System.out.println("yes");
                            yes = true;
                            break;
                        }
                        if (num != -1) {
                            for (int v = 1; v <= Math.ceil(Math.sqrt(num)); v ++ ) {
                                if (num % v == 0) {

                                    next.add(new Vector((int) (num / v), v));

                                    next.add(new Vector(v, (int) (num / v)));
                                }

                            }
                        }
                        map[a.x][a.y] = -1;
                    }
                }
            if(!yes) {
                System.out.println("no");
            }
        }catch(Exception e){
            System.out.println(e);

        }



    }


}

class Vector{

    int x, y;
    Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    boolean compare(Vector c){

        return (c.x == x && c.y == y);

    }
}