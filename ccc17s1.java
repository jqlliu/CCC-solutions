import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int[] list1 = new int[total];
        int[] list2 = new int[total];
        for(int i = 0; i < total; i ++){
            list1[i] = in.nextInt();
            
        }
        for(int i = 0; i < total; i ++){
            
            list2[i] = in.nextInt();
        }
        int t1 = 0,t2=0;
        int output = 0;
        for(int i = 0; i < total; i ++){
            
            t1 += list1[i];
            t2 += list2[i];
            if(t1 == t2){
                output = i+1;
            }
        }
        System.out.println(output);
        
        
    }
}
