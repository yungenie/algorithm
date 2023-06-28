package study.inflearn.lecture02.section08;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 방향 바꾸기 - 그래프 최단거리 : Graph
 * 틀림
 */
public class Ex08_04 {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        cost[0][0] = 0;
        for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;

            int d = board[cur[0]][cur[1]]-1; //3-> 2
            int nx = cur[0] + dx[d];
            int ny = cur[1] + dy[d];

            // 다음 지점이 격자 밖을 넘어갔을 때 해당 방향 제외하고 나머지 방향를 봐야함.
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                for(int k = 0; k < 4; k++) {
                    if (k == d) continue;

                    int mx = cur[0] + dx[k];
                    int my = cur[1] + dx[k];
                    if(mx < 0 || mx >= n || my < 0 || my >= m) continue;
                    if (cost[mx][my] > cur[2] + 1) {
                        cost[mx][my] = cur[2] + 1;
                        pq.offer(new int[]{mx, my, cur[2] + 1});
                    }
                }
            } else {
                // 격자 밖 넘지 않을 경우
                if (cost[nx][ny] > cur[2]) {
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx, ny, cur[2]});
                }
            }
        }
        return cost[n - 1][m - 1];
    }

    public static void main(String[] args){
        Ex08_04 T = new Ex08_04();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
