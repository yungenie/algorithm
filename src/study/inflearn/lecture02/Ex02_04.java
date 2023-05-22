package study.inflearn.lecture02;

/**
 *  음수가 있는 부분수열 - 해싱,시간파싱
 */
public class Ex02_04 {
    public int solution(int[] nums, int m){
        int answer = 0;
        int n = nums.length;
        int sum = 0;

        // 연속부분수열의 합이 M인 경우의 수
        // 이중 for문 첫번째 (첫번째 ~ 마지막), 두번째 (두번째 ~ 마지막) ..
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == m) answer++; // 원소 1개가 m과 같은 경우
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == m) answer++; // 연속부분수열의 합이 m과 같은 경우
            }
            sum = 0; // 합 초기화
        }

        return answer;
    }

    public static void main(String[] args){
        Ex02_04 T = new Ex02_04();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }

}
