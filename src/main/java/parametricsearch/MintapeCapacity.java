package parametricsearch;

import java.util.Scanner;

public class MintapeCapacity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //로그파일 개수
        int M = sc.nextInt();   //테이프 최대 개수

        int[] Ai = new int[N];  //파일 크기 배열

        long lo = 0;     //최소 테이프 용량
        long hi = 0;     //최대 테이프 용량
        for(int i=0; i<N; i++) {
            Ai[i] = sc.nextInt();
            lo = Math.max(lo, Ai[i]);
            hi += Ai[i];
        }

        long answer = hi;

        while(lo <= hi) {
            long mid = lo + (hi - lo)/2;     //가능한 테이프 용량
            if(canStore(Ai, M, mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean canStore(int[] Ai, int M, long mid) {
        int count = 1;      //저장한 테이프 개수
        long sum = 0;        //저장한 용량
        for(int a : Ai) {
            if(sum + a <= mid) {
                sum = sum + a;
            } else {
                count++;
                sum = a;
                if(count > M) return false;
            }
        }
        return true;
    }
}
