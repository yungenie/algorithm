package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 집으로 이동 - 넓이우선탐색 : BFS
 * 소요시간 : 43분
 */
public class Ex07_02 {
    public int solution(int[] pool, int a, int b, int home){
        //int answer = 0;
        int ch[] = new int[10001]; // 배열의 크기 얼만큼 잡아야 하는 지? 잘잡았음.
        int[] jump = new int[]{a, -b};
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        ch[0] = 1;
        int L = 0;

        // 부모 레벨 탐색
        while(!q.isEmpty()) {
            int len = q.size();

            // 자식 레벨 탐색
            for (int i = 0; i < len; i++) {
                int x = q.poll();

                //boolean flag = false; // 점프 앞, 뒤마다 따로 적용되게 해야함.
                // 점프 앞,뒤 경우의 수
                for (int j = 0; j < jump.length; j++) {
                    int nx = x + jump[j];

                    // 뒤로 점프 수직선 벗어나면 건너뛰기
                    if (nx < 0) continue; // 음수면 무조건 건너뛰기

                    // 집으로 도착
                    if (nx == home) return L + 1;

                    // 웅덩이 만나면 건너뛰기
                    boolean flag = false;
                    for (int k = 0; k < pool.length; k++) {
                        if (nx == pool[k]) {
                            flag = true;
                        }
                    }
                    if (flag) continue;

                    // 한번 방문한 점프위치 체크
                    if (ch[nx] == 0) { // 뒤로 두번 가는 경우의 수 체크 안했는데 답이 나옴.
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Ex07_02 T = new Ex07_02();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
