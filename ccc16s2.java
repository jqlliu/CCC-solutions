import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
        
        int total = in.nextInt();
        
        int[] dmoj = new int[total];
        int[] peg = new int[total];
        
        for(int i = 0; i < total; i ++){
            dmoj[i] = in.nextInt();
        }
         for(int i = 0; i < total; i ++){
            peg[i] = in.nextInt();
        }
        
        Arrays.sort(dmoj);
        Arrays.sort(peg);
        int output = 0;
        if(q == 2){
        for(int i = 0; i < total; i ++){
            output += Math.max(peg[i],dmoj[total-1-i]);
        }
            
            
        }
        else{
           for(int i = 0; i < total; i ++){
            output += Math.max(peg[i],dmoj[i]);
        } 
            
        }
        
        System.out.println(output);
    }
}