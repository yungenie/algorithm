package study.programmers.hash;

import java.util.*;

/**
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1845">문제</a>
 */
public class Ex01_01_폰켓몬 {

    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int selectCnt = N/2;

        Set<Integer> hashSet = new HashSet<>();
        Arrays.stream(nums).forEach(hashSet::add);

        int typeCnt = hashSet.size();
        if (selectCnt < typeCnt) {
            answer = selectCnt;
        } else {
            answer = typeCnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex01_01_폰켓몬 T = new Ex01_01_폰켓몬();
        System.out.println(T.solution(new int[]{3,1,2,3}));
        System.out.println(T.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(T.solution(new int[]{3,3,3,2,2,2}));
    }
}
