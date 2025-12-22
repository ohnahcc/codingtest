package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class SignalRepeaterInstallation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //중계소 개수
        int C = sc.nextInt();   //중계기 개수

        int[] xi = new int[N];  //중계소 위치배열
        int lo = 1;
        int mid = 0;
        int hi = 0;
        int answer = 0;
        for(int i=0; i<N; i++) {
            xi[i] = sc.nextInt();
        }
        Arrays.sort(xi);
        hi = xi[N-1] - xi[0];

        while(lo<=hi) {
            mid = lo + (hi - lo)/2;
            if (canInstall(xi, C, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

    }

    public static boolean canInstall(int[] xi, int C, int mid) {
        int count = 1;
        int last = xi[0];

        for(int i=1; i<xi.length; i++) {
            if(xi[i] - last >= mid) {
                count++;
                last = xi[i];
            }
        }
        return count >= C;
    }
}
