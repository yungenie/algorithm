package study.inflearn.lecture02.section08;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 방향 바꾸기 - 그래프 최단거리 : Graph
 * 강사님 정답코드 보면서 08_05 리팩토리
 */
public class Ex08_05_Answer {
    public int solution(int[][] board, int[] s, int[] e){
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)

        // 다익스트라 비용 초기화
        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[s[0]][s[1]] = 0; // 출발지점 비용 초기화

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{s[0], s[1], 0});

        // 다익스트라 최소 격자 이동 수
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[2] > cost[cur[0]][cur[1]]) continue;// BFS에서 체크한 지점 안가는 것도 동일한 효과의 역할
            if (cur[0] == e[0] && cur[1] == e[1]) return cost[cur[0]][cur[1]]; // 도착지점에 도착했을 때 반환

            // 겪자밖 또는 벽을 만날때까지 이동
            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) { // 방향 배열 (상하좌우)
                int nx = cur[0]; // 행
                int ny = cur[1]; // 열
                int cnt = cur[2]; // 이동거리

                // 빈공간일 경우에만 쭉 이동해서 벽의 지점까지 도착해서 멈춘다.
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dir[0]; // 멈추는 행 지점
                    ny += dir[1];  // 멈추는 열 지점
                    cnt++; // 멈추는 지점까지 이동거리
                }
                // 그러므로 벽 지점의 위치와, 이동거리를 빼준다.
                nx -= dir[0];
                ny -= dir[1];
                cnt--;

                if (cost[nx][ny] > cnt) {
                    cost[nx][ny] = cnt;
                    pq.offer(new int[]{nx, ny, cnt});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Ex08_05_Answer T = new Ex08_05_Answer();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
