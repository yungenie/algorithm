package study.inflearn.lecture02.section08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 벽 허물기 - 그래프 최단거리 : Graph
 * 타임리밋 나는 소스
 */
public class Ex08_03 {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length; // 행
        int m = board[0].length; // 열
        int[][] dist = new int[n][m];
        int[][] ch = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0}); // {행, 열}
        ch[0][0] = 1;
        dist[0][0] = 0;

        int L = 0;
        while (!Q.isEmpty()) {
            L++;
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx == (n-1) && ny == (m-1)) {
                    }

                    if (nx >= 0 && nx < n && ny >=0 && ny < m && ch[nx][ny] == 0) {
                        if (board[nx][ny] == 1) {
                        }
                        ch[nx][ny] = 1;
                        dist[nx][ny] = L;
                        Q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex08_03 T = new Ex08_03();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
