package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 집을 짓자 - 넓이우선탐색 : BFS
 */
public class Ex07_05_02_Answer {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length; // 지도의 크기
        int[][] dist = new int[n][n]; // 각 빌딩에서 i행,j열 지점으로 오는 이동거리의 합 (최소이동횟수)

        Queue<int[]> Q = new LinkedList<>(); // 빌딩의 이동거리 (빈땅으로만 이동가능)

        // 빌딩 배열에서 빌딩 찾아 빈땅으로 이동하며 각 빌딩으로부터 최적의 거리의 집 좌표 구하기
        int emptyLand = 0; // 빈땅, 각 빌딩들 빈땅으로의 거리 구할 때마다 감소
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) { // 빌딩 찾기
                    answer = Integer.MAX_VALUE; // 빌딩마다 초기화
                    Q.offer(new int[]{i, j}); // 빌딩의 좌표

                    int L = 0;
                    while(!Q.isEmpty()){
                        L++; // L레벨 먼저 증가 (자식노드 레벨)
                        int len = Q.size();
                        for(int k = 0; k < len; k++){
                            int[] cur = Q.poll();
                            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향 배열 (인접한 4방향)
                                int nx = cur[0] + dir[0]; // 이동하는 행좌표
                                int ny = cur[1] + dir[1]; // 이동하는 열좌표
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){ //시간복잡도를 줄이기 위해서 한번 방문했던 빈땅 체크하기
                                    board[nx][ny]--; // 규칙에 의해서 빈땅 감소하기
                                    dist[nx][ny] += L; // 모든 빌딩에서 이동하는 좌표의 이동거리 누적
                                    Q.offer(new int[]{nx, ny}); // 이동하는 좌표 넣기
                                    answer = Math.min(answer, dist[nx][ny]); // 이동거리의 최소합
                                }
                            }
                        }
                    }
                    emptyLand--; // 빌딩의 개수 만큼 감소된다.
                }
            }
        }
        // 빈땅이 없어서 막혔을 경우 -1 반환
        return answer == Integer.MAX_VALUE? -1 : answer;
    }

    public static void main(String[] args){
        Ex07_05_02_Answer T = new Ex07_05_02_Answer();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
