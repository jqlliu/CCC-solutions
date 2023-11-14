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
            for(int i = 0; i < m; i ++){
                String ln = buf.readLine();
                String[] s = ln.split(" ");
                for(int j = 0; j < n; j ++){
                    map[i+1][j+1] = Integer.parseInt(s[j]);
                }

            }

        }catch(IOException e){
            System.out.println(e);

        }

        //bfs
        Queue<Vector> next = new LinkedList<>();
        next.add(new Vector(1,1));
        ArrayList<Integer> primes = new ArrayList<>();
        int p = 2;
        while(p <= 500000){
            if(checkPrime(p, primes)){
                primes.add(p);
            }
            p ++;
        }
        for(int i = 0; i < primes.size(); i ++) {

            System.out.println(primes.get(i));
        }

    }

    static boolean checkPrime(int n, ArrayList<Integer> primes){

        for(int i = 0; i < primes.size(); i ++){

            if(n%primes.get(i) != 0){
                return false;

            }

        }

        return true;
    }

}

class Vector{

    int x, y;
    Vector(int x, int y){
        this.x = x;
        this.y=y;

    }

}