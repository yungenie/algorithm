package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 숲속의 기사 - 넓이우선탐색 : BFS
 */
public class Ex07_06_02_Answer {
    public int solution(int[][] board){ // 숲의 지도 정보
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)
        int[][] dist = new int[n][m]; // dist[i][j]는 영희와 기사가 딸기지점까지 가는 최소이동거리
        Queue<int[]> Q = new LinkedList<>(); // 영희와 기사의 이동좌표

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) { //2:영희, 3:기사(기사를 영희가 움직이는 것 처럼 생각하기)
                    Q.offer(new int[]{i, j});
                    int[][] ch = new int[n][m]; // 영희,기사 각각 체크배열 생성
                    ch[i][j] = 1;

                    int L = 0;
                    while (!Q.isEmpty()) {
                        L++;
                        int len = Q.size();
                        for (int k = 0; k < len; k++) {
                            int[] cur = Q.poll();
                            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향배열 상하좌우
                                int nx = cur[0] + dir[0]; // 이동하는 행좌표
                                int ny = cur[1] + dir[1]; // 이동하는 열좌표
                                if (nx >= 0 && nx < n && ny >=0 && ny < m && board[nx][ny] != 1) { // 지도 범위 넘어가지 않게, 움직일 수 없는 곳을 제외
                                    if(ch[nx][ny] == 0){
                                        ch[nx][ny] = 1;
                                        dist[nx][ny] += L; // 영희와 기사가 지도에서 이동하는 지점의 이동거리 누적 합
                                        Q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 영희와 기사가 각 산딸기 지점까지의 최소이동거리(최소 날수)
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) { // 산딸기 지점을 못간 경우는 거르기
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex07_06_02_Answer T = new Ex07_06_02_Answer();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
