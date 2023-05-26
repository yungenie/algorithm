package study.inflearn.lecture02;

import java.util.Arrays;

/**
 * 수열 찾기 - Sorting & Thinking
 * 소요시간 - 22분
 */
public class Ex04_02 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        // 정렬
        Arrays.sort(nums);
        //System.out.println("nums = " + Arrays.toString(nums)); // note 1차원 배열 출력은 Arrays.toString

        // 선생님이 칠판에 적은 원래의 수열 찾기
        int n = nums.length, idx = 0;
        for (int i = 0; i < n-1; i++) {
            int find = nums[i];
            for (int j = i+1; j < n; j++) {
                if ((find*2) == nums[j]) { // 선택정렬 알고리즘을 활용해서 원소를 두배한 값을 찾기
                    answer[idx] = find; // 원래 수열 담기
                    idx++;
                    break; // 첫번째 조건이 같으면 다음 같은 값 찾을 필요 없음
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_02 T = new Ex04_02();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
