package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로의 최단거리 통로 - 넓이우선탐색 : BFS
 * 소요시간 : 22분 (입력케이스 2번 틀림 -> 방문한 지점 벽으로 만든 후 해결)
 */
public class Ex07_04 {
    public int solution(int[][] board){
        int n = board.length;
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        int L = 0;

        // BFS 탐색
        while(!Q.isEmpty()){
            // 레벨탐색
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] x = Q.poll();
                // 자식레벨 탐색 (상하좌우 방향)
                for (int[] dxy : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                    int nx = x[0] + dxy[0];
                    int ny = x[1] + dxy[1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;

                    if (nx == 6 && ny == 6) return L+1;

                    Q.offer(new int[]{nx, ny});
                    board[nx][ny] = 1;
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Ex07_04 T = new Ex07_04();
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
