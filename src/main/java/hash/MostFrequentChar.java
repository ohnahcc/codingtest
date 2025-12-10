package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        char answer = 'z';
        int max = -1;

        for(char key : map.keySet()) {
            int count = map.get(key);


            if(count > max) {
                max = count;
                answer = key;
            } else if (count == max && key < answer) {
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
