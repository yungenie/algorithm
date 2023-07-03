package study.inflearn.lecture02.section08;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 벽 허물기 - 그래프 최단거리 : Graph
 * 강사님 해법 및 정답코드 보면서 리팩토리
 */
public class Ex08_03_02 {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], 100000);
        }
        cost[0][0] = 0; // error 현수지점 초기화 안함

        Queue<int[]> PQ = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        PQ.offer(new int[]{0, 0, 0});

        while(!PQ.isEmpty()) {
            int len = PQ.size();
            for (int i = 0; i < len; i++) {
                int[] cur = PQ.poll();
                //System.out.println("Arrays.toString(cur) = " + Arrays.toString(cur));
                if (cost[cur[0]][cur[1]] < cur[2]) continue; // error 큐에서 나온 최소비용이 해당 지점의 최소비용보다 크면 자식 레벨까지 뻗을 필요가 없다.
                if (cur[0] == (n-1) && cur[1] == (m-1)) return cost[cur[0]][cur[1]];

                // 자식레벨 탐색
                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    //if (cost[nx][ny] < cur[2]) continue; // error

                    if (board[nx][ny] == 1 && cost[nx][ny] > cur[2] + 1) {
                        cost[nx][ny] = cur[2] + 1;
                        PQ.offer(new int[]{nx, ny, cost[nx][ny]});
                    } else if (board[nx][ny] == 0 && cost[nx][ny] > cur[2]){
                        cost[nx][ny] = cur[2];
                        PQ.offer(new int[]{nx, ny, cost[nx][ny]});
                    }
                }
                /*for (int[] ints : PQ) {
                    System.out.print("PQ = " + Arrays.toString(ints));
                }
                System.out.println();*/
            }
        }
        return answer;
        //return cost[n - 1][m - 1];
    }

    public static void main(String[] args){
        Ex08_03_02 T = new Ex08_03_02();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
