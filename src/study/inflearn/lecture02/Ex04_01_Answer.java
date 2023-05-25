package study.inflearn.lecture02;

import java.util.Arrays;

/**
 * 이진수 정렬 - Sorting & Thinking
 */
public class Ex04_01_Answer {
    public int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        int[][] result = new int[n][2];

        // 2차원 배열 값 초기화 {십진수, 이진수 1의 총 갯수}
        for (int i = 0; i < n; i++) {
            int tmp = nums[i], cnt = 0;
            while (tmp > 0) {
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }
            result[i][0] = nums[i]; // note tmp로 담으면 안됨. 이진수를 구할 때 십진수의 몫을 2로 계속 나누기 때문에 몫은 계속 변환함. 기존의 이진수가 아님.
            result[i][1] = cnt;
        }

        // 정렬 (1의 총 갯수 오름차순, 십진수 오름차순)
        Arrays.sort(result, (a,b) -> a[1] == b[1]? a[0] - b[0] : a[1] - b[1]);

        // 십진수 반환
        for (int x = 0; x < result.length; x++) {
            answer[x] = result[x][0];
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_01_Answer T = new Ex04_01_Answer();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
