package study.inflearn.lecture02;

import java.util.Arrays;

/**
 * 카드가져가기 - Sorting & Thinking
 * 강사님 해법 듣고 재도전
 */
public class Ex04_03 {
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length;

        // 카드 내림차순 정렬
        Integer[] number = Arrays.stream(nums).boxed().toArray(Integer[]::new); // note 정수형 배열의 내림차순은 기본형인 int형은 안되고, 클래스 형인 Integer형으로 해야 됨
        Arrays.sort(number, (a,b) -> b - a);

        // 카드 가져오기
        int round = n / 2;
        Integer[] diff = new Integer[round];
        for (int i = 0; i < round; i++) {
            answer += number[i*2+1]; // 영희 먼저 양보한 두번째 카드 가져오기
            diff[i] = number[i*2] - number[i*2+1]; // 영희와 현수 카드숫자 차이
        }

        // 우선권 사용
        Arrays.sort(diff, (a, b) -> b - a); // 카드숫자 차이 내림차순
        for (int i = 0; i < k; i++) {
            answer += diff[i]; // 차이값이 큰 요소만큼 더해주기
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_03 T = new Ex04_03();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
