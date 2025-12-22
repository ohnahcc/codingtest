package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class RouterInstallation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] xi = new int[N];

        for(int i=0; i<N; i++) {
            xi[i] = sc.nextInt();
        }

        Arrays.sort(xi);

        int lo = 1;
        int hi = xi[N-1] - xi[0];
        int answer = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(canInstall(xi, C, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean canInstall(int[] xi, int C, int mid) {
        int count = 1;
        int last = xi[0];
        for(int i=1; i<xi.length; i++){
            if(xi[i] - last >= mid) {
                count++;
                last = xi[i];
            }
        }
        return count >= C;
    }
}
