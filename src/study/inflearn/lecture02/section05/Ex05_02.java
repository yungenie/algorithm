package study.inflearn.lecture02.section05;

import java.util.Arrays;

/**
 * 이동 횟수 - greedy : 탐욕법
 * 소요시간 - 11분
 */
public class Ex05_02 {
    public int solution(int[] nums){
        int answer = 0;

        // 물건 정렬
        Integer[] items = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(items, (a,b) -> b-a); // 내림차순 정렬

        int left = 0;
        int right = nums.length-1 ;

        while(left <= right) {
            if (items[left] + items[right] <= 5) { // 물건 2개 이동
                answer++;
                left++;
                right--;
            } else { // 무거운 물건만 이동
                answer++;
                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_02 T = new Ex05_02();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
