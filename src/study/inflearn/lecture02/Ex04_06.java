package study.inflearn.lecture02;


/**
 * 멀티태스킹 - Sorting & Thinking
 * 소요시간 - 1시간 5분
 */
public class Ex04_06 {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int n = tasks.length;

        int time = 0,idx = 0;
        while (time <= k) {
            if (time == k) { // 정전 후 다시 시작처리해야 하는 작업번호
                if (tasks[idx] > 0) answer = idx+1;
                else answer = idx;
                break;
            }
            for (int i = 0; i < n; i++) {
                if(time == k) {
                    if (tasks[i] > 0) idx = i; // 작업번호 반환
                    else idx = -1; // 처리할 작업 없음 반환
                    break;
                }
                if(tasks[i] > 0) {
                    tasks[i] = tasks[i] - 1;
                    time++;
                    idx = i; // 작업번호 기억하기
                    continue;

                }
                if (tasks[i] == 0) continue;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_06 T = new Ex04_06();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
