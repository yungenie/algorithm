package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지를 잡자 - 넓이우선탐색 : BFS
 * 강사님 해법 듣고 재도전
 */
public class Ex07_03_02 {
    public int solution(int s, int e){
        int[] dx = new int[]{-1, 1, 2};
        int[][] ch = new int[2][200001]; // 행(0:홀수, 1:짝수) 레벨로 나누기

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        ch[0][s] = 1;

        int L = 0;
        int calfLoc = 1;
        while(!Q.isEmpty()) {
            e = e + calfLoc; // 송아지 위치

            // 레벨탐색
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int hs = Q.poll();

                // 자식레벨 (앞1, 뒤-1, 점프*2) 탐색
                /*for (int j = 0; j < dx.length; j++) {
                    int nx = hs;
                    if (j == 2) nx = nx * dx[j];
                    else nx += dx[j];

                    if (nx == e) return L + 1;
                    if (nx < 0 || nx > 200000) continue;
                    if (nx >= 0 && e <= 200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }*/

                for(int nx : new int[]{hs-1, hs+1, hs*2}){ // note 향상된 반복문으로 1차원 배열 생성 및 초기화 가능
                    if (nx == e) return L + 1;
                    if (nx < 0 || nx > 200000) continue;
                    if (nx >= 0 && e <= 200000 && ch[L%2][nx] == 0) {
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
            calfLoc++;
        }

        return -1;
    }

    public static void main(String[] args){
        Ex07_03_02 T = new Ex07_03_02();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
        System.out.println(T.solution(2, 200002));
    }
}
