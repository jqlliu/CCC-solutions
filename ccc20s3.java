
import java.util.*;
public class ccc20s3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String needle = in.nextLine();
        String haystack = in.nextLine();

        int total = 0;
        HashMap<String, Boolean> seen = new HashMap<String, Boolean>();
        int nl = needle.length();
        int hl = haystack.length();

        int[] counts = new int[26];
        for(int i = 0; i < needle.length(); i ++){
            counts[needle.charAt(i)-'a'] += 1;
        }
        int outOfSync = 0;
        for (int j : counts) {
            if (j != 0) {
                outOfSync += 1;
            }
        }
        for(int i = 0; i < hl; i ++){
            int at = haystack.charAt(i) - 'a';
            if(counts[at] == 0 ){
                outOfSync += 1;
            }
            if(counts[at] == 1 ){
                outOfSync -= 1;
            }
            counts[at] -= 1;
            if(i >= nl){
                int bef = haystack.charAt(i-nl) - 'a';
                if(counts[bef] == -1){
                    outOfSync -= 1;
                }
                if(counts[bef] == 0){
                    outOfSync += 1;
                }
                counts[bef] += 1;

            }
            if(i >= nl-1){
                if(outOfSync == 0){
                    String str = haystack.substring(i-nl+1,i+1);
                    if(seen.get(str) == null){
                        seen.put(str, true);
                        total += 1;
                    }

                }

            }



        }
        System.out.println(total);

    }
}