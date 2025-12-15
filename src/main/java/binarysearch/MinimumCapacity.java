package binarysearch;

import java.util.Scanner;

public class MinimumCapacity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];

        int lo = 0;
        int hi = 0;

        for(int i=0; i<n; i++) {
            weights[i] = sc.nextInt();
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }

        int D = sc.nextInt();

        int answer = binarySearchMinCapacity(weights, D, lo, hi);
        System.out.println(answer);
    }

    public static int binarySearchMinCapacity(int[] weights, int D, int lo, int hi) {
        int ans = hi;

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(canShipWithinDays(weights, D, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static boolean canShipWithinDays(int[] weights, int D, int capacity) {
        int days = 1;
        int load = 0;

        for(int w : weights) {
            if(load + w <= capacity) {
                load += w;
            } else {
                days++;
                load = w;
                if(days > D) {
                    return false;
                }
            }
        }
        return true;
    }
}
