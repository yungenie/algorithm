package study.inflearn.lecture02.section08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 방향 바꾸기 - 그래프 최단거리 : Graph
 */
public class Ex08_04_Answer {
    public int solution(int[][] board) {
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)

        // 방향배열 (순서 : 오른쪽 > 왼쪽 > 아래 > 위)
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[0][0] = 0; // 출발지점

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0}); // {행, 열, 비용(방향을 바꿀 때 1의 비용이 든다)}

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            // ✨ 꺼낸 지점의 최신화된 비용보다 꺼낸 지점의 비용이 더 크다면 다음 레벨 뻗지 않는다.
            // 최소값을 구하는 문제이므로, 이미 최소비용이 있기 때문에 더 이상 다음 레벨을 계산하지 않는다.
            if(cur[2] > cost[cur[0]][cur[1]]) continue;

            for(int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int dir = board[cur[0]][cur[1]] - 1;
                if(k == dir && cost[nx][ny] > cur[2]) {
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx, ny, cur[2]});
                }
                else { // 해당 지점의 방향과 다른 방향일 때 1의 비용
                    if (cost[nx][ny] > cur[2] + 1) {
                        cost[nx][ny] = cur[2] + 1;
                        pq.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        return cost[n - 1][m - 1];
    }
    public static void main(String[] args){
        // 문제 : 현수가 (0, 0) 지점에서 (n-1, m-1)지점까지 가기 위해서 방향을 바꾸어야 하는 최소 격자의 개수
        Ex08_04_02 T = new Ex08_04_02();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
