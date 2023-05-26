package study.inflearn.lecture02;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 수열 찾기 - Sorting & Thinking
 */
public class Ex04_02_Answer {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> map = new HashMap<>(); // note HashMap 자료구조 사용해야겠다는 생각 못함. 기존수열과 2배한 수열 찾아서 삭제해봐야겠다는 해법은 생각 해봄..

        // 현수가 만든 수열 정렬
        Arrays.sort(nums);

        // 수열의 빈도수 해싱
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 선생님이 적은 원래 수열 찾기
        int idx = 0;
        for (int ele : nums) { // 현수배열
            if (map.get(ele) == 0) continue; // 빈도수가 0이면 원래 수열 찾았다는 의미로 건너뛰기
            answer[idx] = ele; // 가장 작은 수열은 원래 칠판에 적혀 있던 값
            idx++;
            // 원래 수열과 2배한 수열 찾았으므로 삭제한 효과
            map.put(ele, map.get(ele) - 1); // 원래 수열 빈도수 -1 감소
            map.put(ele*2, map.get(ele*2) - 1); // 2배한 수열 빈도수 -1 감소
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_02_Answer T = new Ex04_02_Answer();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
