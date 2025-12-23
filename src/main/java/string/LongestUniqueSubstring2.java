package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestUniqueSubstring2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthSubstring(s));
    }

    public static int lengthSubstring(String s){
        Set<Character> set = new HashSet<>();
        int maxlen = 0;
        int l = 0;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);

            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);

            int winlen = r - l + 1;
            if(maxlen < winlen){
                maxlen = winlen;
            }

        }
        return maxlen;
    }
}
