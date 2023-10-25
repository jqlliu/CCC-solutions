import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        
        int[] letters = new int[26];
        int astr = 0;
        boolean can = true;
        if(line1.length() != line2.length()){
            can = false;
            
        }
        for(int i = 0; i < line1.length(); i ++){
            
            letters[(int)line1.charAt(i)-'a'] ++;
        }
        
        for(int i = 0; i < line2.length(); i ++){
            if (line2.charAt(i) != '*'){
            int index = (int)line2.charAt(i)-'a';
            letters[index] --;
            if(letters[index] < 0){
                
                can = false;
            } 
        }
        else{
            
            astr ++;
        }
        }
        //boolean can = true;
        for(int i = 0; i < letters.length; i ++){
                astr -= letters[i];
                
        }
        if( can == false || astr < 0 || astr > 0){
            System.out.println("N");
            
        }
        else if(astr == 0){
            System.out.println("A");
            
        }

    }
}