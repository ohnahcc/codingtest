package binarysearch;

import java.util.Map;
import java.util.Scanner;

public class MinUsbCapacity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] Ai = new int[N];
        long lo = 0;
        long hi = 0;
        for(int i=0; i<N; i++) {
            Ai[i] = sc.nextInt();
            lo = Math.max(lo, Ai[i]);
            hi += Ai[i];
        }

        long answer = hi;
        while(lo <= hi) {
            long mid = lo + (hi - lo)/2;
            if(canStore(Ai, M, mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean canStore(int[] Ai, long M, long mid) {
        int used = 1;
        long sum = 0;

        for(int a : Ai) {
            if(sum + a <= mid) {
                sum = sum + a;
            } else {
                used++;
                sum = a;

                if (used > M) return false;
            }
        }
        return true;
    }
}
