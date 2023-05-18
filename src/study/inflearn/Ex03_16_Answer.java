package study.inflearn;

import java.util.HashSet;

/**
 * 최대 길이 연속수열 - 자료구조 활용
 * HashSet contains()
 */
public class Ex03_16_Answer {
    public int solution(int[] nums){
        int answer = 0;

        // 중복제거
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);

        // 가장 긴 연속 수열 찾기
        for(int x : set){
            // 원소보다 작은 값이 있으면 SKIP
            if(set.contains(x - 1)) continue;

            // 연속수열 찾기
            int cnt = 0;
            while(set.contains(x)){
                cnt++;
                x++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex03_16_Answer T = new Ex03_16_Answer();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
