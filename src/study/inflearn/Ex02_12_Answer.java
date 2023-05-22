package study.inflearn;

import java.util.HashMap;
/**
 *  음수가 있는 부분수열 - 해싱,시간파싱
 */
public class Ex02_12_Answer {
    public int solution(int[] nums, int m){
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);
        for(int x : nums){
            sum += x;
            if(nH.containsKey(sum-m)) answer += nH.get(sum-m);
            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex02_12_Answer T = new Ex02_12_Answer();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
