package study.inflearn.lecture02.section05;

import java.util.Arrays;

/**
 * 침몰하는 타이타닉 - greedy : 탐욕법
 */
public class Ex05_01_Answer {
    public int solution(int[] nums, int m){
        int answer = 0;

        // 승객 몸무게 오름차순
        Arrays.sort(nums);

        // 구명보트 태우기
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= m) { // 승객 2명 태우기
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--; // 무거운 승객 혼자 태우기
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_01_Answer T = new Ex05_01_Answer();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
