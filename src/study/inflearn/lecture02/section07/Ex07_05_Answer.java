package study.inflearn.lecture02.section07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 집을 짓자 - 넓이우선탐색 : BFS
 */
public class Ex07_05_Answer {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;
        int[][] dist = new int[n][n]; // 모든 빌딩에서 i행 j열의 빈땅으로 가는 최소 이동거리의 총합

        Queue<int[]> Q = new LinkedList<>(); // 빌딩의 이동거리 (빈땅으로만 이동가능)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int emptyLand = 0;

        // 빌딩지점에서 각 빈땅으로 가는 최단 거리 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer = Integer.MAX_VALUE;
                    Q.offer(new int[]{i, j});
                    int L = 0;
                    // BFS 돌기
                    while(!Q.isEmpty()){
                        L++; // L레벨 먼저 증가 (자식노드 레벨)
                        // 레벨 탐색
                        int len = Q.size();
                        for(int k = 0; k < len; k++){
                            int[] cur = Q.poll();
                            // 자식레벨 탐색
                            for(int x = 0; x < 4; x++){
                                int nx=cur[0]+dx[x];
                                int ny=cur[1]+dy[x];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){ //시간복잡도를 줄이기 위해서 한번 방문했던 빈땅 체크하기
                                    board[nx][ny]--; // 규칙에 의해서 체크 해야함
                                    dist[nx][ny] += L; // 모든 빌딩에서 이동거리 누적
                                    Q.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, dist[nx][ny]);
                                }
                            }
                        }
                    }
                    emptyLand--; // 빌딩의 개수 만큼 감소된다.
                }
            }
        }

        return answer == Integer.MAX_VALUE? -1 : answer;
    }

    public static void main(String[] args){
        Ex07_05_Answer T = new Ex07_05_Answer();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
