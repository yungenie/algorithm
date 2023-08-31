package study.inflearn.lecture02.section08;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex08_03_03_Answer {
    public int solution(int[][] board) {
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)

        int[][] cost = new int[n][m]; // 비용
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = board[0][0]; // 출발지점 비용 초기화

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 비용 오름차순
        pq.offer(new int[]{0, 0, board[0][0]}); // {행, 열, 비용}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[2] > cost[cur[0]][cur[1]]) continue; // 이미 최대값으로 초기화 되어 있는데, 그것보다 크면 스킵해야된다.

            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int nextCost = cur[2] + board[nx][ny];
                if (cost[nx][ny] > nextCost) {
                    cost[nx][ny] = nextCost;
                    pq.offer(new int[]{nx, ny, nextCost});
                }
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args){
        Ex08_03_03_Answer T = new Ex08_03_03_Answer();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
