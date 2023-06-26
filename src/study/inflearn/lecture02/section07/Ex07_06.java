package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 숲속의 기사 - 넓이우선탐색 : BFS
 * 강사님 해법 듣고 재도전
 */
public class Ex07_06 {
    public int solution(int[][] board){
        int answer = 0;
        int xLen = board.length;
        int yLen = board[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> Q = new LinkedList<>();
        int[][] dist  = new int[xLen][yLen]; // 거리
        int[][] ch; // 방문지점 체크
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) { // 영희/기사 => 영희로 보기
                    ch = new int[xLen][yLen]; // 영희/기사 각각 방문지점 초기화
                    Q.offer(new int[]{i, j});
                    ch[i][j] = 1; // 방문지점 체크 안했는데 정답나옴.
                    int L = 0;
                    while(!Q.isEmpty()){
                        L++;
                        // 레벨 탐색
                        int len = Q.size();
                        for(int k = 0; k < len; k++){
                            int[] cur = Q.poll();
                            // 자식레벨 탐색
                            for(int z = 0; z < 4; z++){
                                int nx=cur[0]+dx[z];
                                int ny=cur[1]+dy[z];

                                if (nx < 0 || ny < 0 || nx >= xLen || ny >= yLen || board[nx][ny] == 1) continue;
                                if (nx >= 0 && ny >= 0 && nx < xLen && ny < yLen && ch[nx][ny] == 0){
                                    dist[nx][ny] += L;
                                    ch[nx][ny] = 1;
                                    Q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        // 산딸기 지점 최단거리 구하기
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) { // dist[i][j] > 0 동서남북 다 막혔을 경우
                    answer = Math.min(answer,dist[i][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex07_06 T = new Ex07_06();
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
