package study.inflearn.lecture02;

import java.util.Arrays;

/**
 * 멀티태스킹 - Sorting & Thinking
 */
public class Ex04_06_Answer {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int n = tasks.length;
        int[] process = new int[n + 1];
        System.arraycopy(tasks, 0, process, 1, n);
        Arrays.sort(process);

        int rotate = n;
        for (int i = 1; i < process.length; i++) {
            long time = (long)(process[i] - process[i-1]) * rotate; // 작업이 완료되는 시간
            if (time <= k) {
                k -= time; // 남은 시간
                rotate--; // 남은 횟수
            } else {
                long idx = k % rotate; // 회전하고 남은 수 == 남은 작업번호 수
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (process[i] <= tasks[j]) {
                        if (cnt == idx) {
                            return j + 1;
                        }
                        cnt++;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Ex04_06_Answer T = new Ex04_06_Answer();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }

}
