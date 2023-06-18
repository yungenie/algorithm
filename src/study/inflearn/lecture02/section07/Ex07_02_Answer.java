package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 집으로 이동 - 넓이우선탐색 : BFS
 */
public class Ex07_02_Answer {
    public int solution(int[] pool, int a, int b, int home){

        // 방문한 위치 체크 초기화
        int[][] ch = new int[2][10001]; // 행인덱스: 앞/뒤점프, 열인덱스: 점프 위치
        for (int x : pool) { // 웅덩이 지점 못가게 체크
            ch[0][x] = 1; // 0행:앞으로 점프
            ch[1][x] = 1; // 1행:뒤로 점프
        }

        Queue<int[]> Q = new LinkedList<>();
        ch[0][0] = 1;
        ch[1][0] = 1;
        Q.offer(new int[]{0, 0}); // {점프한 위치, 점프 앞(0)/뒤(1) 플러그}

        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            // 레벨 탐색
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L; // 집도착

                // 앞으로 점프
                int nx = cur[0] + a;
                if (nx <=10001 && ch[0][nx] == 0) {
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }

                // 뒤로 점프
                nx = cur[0] - b;
                if (nx >= 0 && ch[1][nx] == 0 && cur[1] == 0) { // cur[1] == 0 앞으로 가는 지점일 경우
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Ex07_02_Answer T = new Ex07_02_Answer();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
