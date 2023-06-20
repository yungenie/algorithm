package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로의 최단거리 통로 - 넓이우선탐색 : BFS
 * 강사님 해법 듣고 재도전
 */
public class Ex07_04_02 {
    public int solution(int[][] board){
        int n = board.length;
        int[][] dist = new int[n][n]; // L레벨 저장
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        dist[0][0] = 1;
        int L = 0;

        // BFS 탐색
        while(!Q.isEmpty()){
            L++; // 자식레벨
            int len = Q.size();
            // 레벨탐색
            for (int i = 0; i < len; i++) {
                int[] x = Q.poll();
                // 자식레벨 탐색 (상하좌우 방향)
                for (int[] dxy : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                    int nx = x[0] + dxy[0];
                    int ny = x[1] + dxy[1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0 && dist[nx][ny] == 0) {
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;
                        board[nx][ny] = 1;
                    }
                }
            }
        }

        return dist[n-1][n-1] > 0? dist[n-1][n-1] : -1;
    }

    public static void main(String[] args){
        Ex07_04_02 T = new Ex07_04_02();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
        int[][] arr2={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr2));
    }
}
