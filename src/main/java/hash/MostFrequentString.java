package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] words = new String[n];
        for(int i=0; i<n; i++) {
            words[i] = sc.next();
        }

        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            map.put(w, map.getOrDefault(w,0) + 1);
        }

        String answer = null;
        int max = -1;

        for(String key : map.keySet()) {
            int count = map.get(key);
            if(count > max) {
                max = count;
                answer = key;
            } else if (count == max && key.compareTo(answer) < 0) {
                answer = key;
            }
        }
        System.out.println(answer);
    }
}
