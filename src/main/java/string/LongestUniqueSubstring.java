package string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int result = LenthofLongestUniqueSubstring(str);
        System.out.println(result);
    }

    public static int LenthofLongestUniqueSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for(int right=0; right<str.length(); right++) {
            char c = str.charAt(right);

            while(set.contains(c)) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(c);

            int windowLen = right - left + 1;
            if (windowLen > maxLen) {
                maxLen = windowLen;
            }
        }
        return maxLen;
    }
}
