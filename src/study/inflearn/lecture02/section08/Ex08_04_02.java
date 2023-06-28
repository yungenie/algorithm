package study.inflearn.lecture02.section08;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 방향 바꾸기 - 그래프 최단거리 : Graph
 * 소요시간 : 18분 (강사님 해법 영상 보고 재도전)
 */
public class Ex08_04_02 {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE); //error 최대값 초기화 안해줬음
        cost[0][0] = 0; // 현수 출발지점 방향변경개수 초기화

        Queue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pQ.offer(new int[]{0, 0, 0}); // 현수 출발지점 초기화

        while (!pQ.isEmpty()) {
            int[] cur = pQ.poll();

            // 시간복잡도 제한 걸기 - 뻗지 않게
            if (cur[2] > cost[cur[0]][cur[1]]) continue;
            if (cur[0] == (n-1) && cur[1] == (m-1)) return cost[cur[0]][cur[1]];

            // 방향이동
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                // 격자 밖
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 격자표시방향과 이동방향이 동일한 경우
                // cost[nx][ny] > cur[2] 이동하는 기존비용보다 작은 비용으로 교체 (최소를 구하는 문제이므로 더 작은 값으로 교체)
                if ((board[cur[0]][cur[1]]-1) == k && cost[nx][ny] > cur[2]){
                    cost[nx][ny] = cur[2];
                    pQ.offer(new int[]{nx, ny, cur[2]});
                } // 이동방향 변경한 경우
                else if (cost[nx][ny] > cur[2] + 1){
                    cost[nx][ny] = cur[2] + 1;
                    pQ.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }

        //return cost[n-1][m-1]; // error board[n-1][m-1];로 해놈
        return answer;
    }

    public static void main(String[] args){
        Ex08_04_02 T = new Ex08_04_02();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
