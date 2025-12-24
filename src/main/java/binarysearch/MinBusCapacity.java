package binarysearch;

import java.util.Scanner;

public class MinBusCapacity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] Wi = new int[N];

        long hi = 0;
        long lo = 0;
        for(int i=0; i<N; i++) {
            Wi[i] = sc.nextInt();
            lo = Math.max(lo, Wi[i]);
            hi += Wi[i];
        }
        long C = hi;
        while(lo <= hi) {
            long mid = lo + (hi - lo)/2;
            if(canSit(Wi, M, mid)) {
                C = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(C);
    }

    public static boolean canSit(int[] Wi, int M, long mid) {
        int count = 1;
        long sum = 0;

        for(int w : Wi) {
            if(sum + w <= mid) {
                sum += w;
            } else {
                count++;
                sum = w;
                if(count > M) return false;
            }
        }
        return true;
    }
}
