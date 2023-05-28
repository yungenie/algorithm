package study.inflearn.lecture02;

import java.util.Arrays;

/**
 * 수열 찾기 - Sorting & Thinking
 * 소요시간 - 22분
 * 예외 케이스 추가 - 틀려서 로직 수정
 */
public class Ex04_02 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        // 현수가 만든 수열 정렬
        Arrays.sort(nums);
        //System.out.println("nums = " + Arrays.toString(nums)); // note 1차원 배열 출력은 Arrays.toString

        // 선생님이 칠판에 적은 원래의 수열 찾기
        int n = nums.length, idx = 0;
        for (int i = 0; i < n-1; i++) {
            int find = nums[i];
            if (find == 0) continue; // 지운 원소 넘어가기
            for (int j = i+1; j < n; j++) {
                if (nums[j] == 0) continue; // 지운 원소 넘어가기
                if ((find*2) == nums[j]) { // 원소를 2배한 값을 찾기
                    answer[idx] = find; // 원래 수열 담기
                    nums[i] = 0; // 원래 원소 지우기
                    nums[j] = 0; // 2배한 원소 지우기
                    idx++;
                    break; // 첫번째 조건이 같으면 다음 같은 값 찾을 필요 없음 (하나의 원소를 2배한 값은 1개뿐, 수열에 중복된 원소가 있다면 중복된 갯수 만큼 2배한 원소가 존재)
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
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14, 1, 2})));
    }
}
