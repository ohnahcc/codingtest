package graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class InfectionSpreadTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //행
        int M = sc.nextInt();   //열

        int[][] grid = new int[N][M];
        int[][] time = new int[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
                time[i][j] = -1;

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    time[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (grid[nr][nc] == 0) continue;

                if (grid[nr][nc] == 1 && time[nr][nc] == -1) {
                    grid[nr][nc] = 2;
                    time[nr][nc] = time[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int answer = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (grid[i][j] == 1) {
                    System.out.println(-1);
                    return;
                }

                if (time[i][j] > answer) {
                    answer = time[i][j];
                }
            }
        }

        System.out.println(answer);
    }
}