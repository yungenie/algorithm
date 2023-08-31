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
            // ✨ 꺼낸 지점의 최신화된 비용보다 꺼낸 지점의 비용이 더 크다면 다음 레벨 뻗지 않는다.
            // 최소값을 구하는 문제이므로, 이미 최소비용이 있기 때문에 더 이상 다음 레벨을 계산하지 않는다.
            if (cur[2] > cost[cur[0]][cur[1]]) continue;

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
        // 문제 : 현수가 (0, 0) 지점에서 (n-1, m-1)지점까지 가기 위해서 허물어야 하는 최소 벽의 개수
        Ex08_03_03_Answer T = new Ex08_03_03_Answer();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
