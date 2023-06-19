package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지를 잡자 - 넓이우선탐색 : BFS
 * 소요시간 : 50분 (입출력 예1번 틀림)
 */
public class Ex07_03 {
    public int solution(int s, int e){
        int[] dx = new int[]{1, -1, 2};
        int[][] ch = new int[3][200001];

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s, e}); // {현수위치, 송아지위치}
        ch[0][s] = 1;

        int L = 0;
        int calfLoc = 1;

        while(!Q.isEmpty()){
            e = e + calfLoc;

            // 레벨 탐색
            int len = Q.size();
            for(int i = 0; i < len; i++) {
                int[] cur = Q.poll();
                if (cur[0] == e) return L ;

                // 자식레벨 (앞1, 뒤-1, 점프*2) 탐색
                for (int j = 0; j < dx.length; j++) {
                    int nx = cur[0];
                    if (j == 2) nx = nx * dx[j];
                    else nx += dx[j];

                    if (nx == e) return L + 1;
                    if (nx < 0 || nx > 200000) continue;
                    if (nx > 0 && e<=200000 && ch[j][nx] == 0) {
                        ch[j][nx] = 1;
                        Q.offer(new int[]{nx, e});
                    }
                }
            }
            calfLoc++;
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Ex07_03 T = new Ex07_03();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
