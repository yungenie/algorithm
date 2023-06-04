package study.inflearn.lecture02.section03;

import java.util.HashSet;

/**
 * 최대 길이 연속수열 - 자료구조 활용
 *
 * set : 중복된 원소를 제거하는 게 특징 입니다. (중복을 허용하지 않음)
 * HashSet : 기본적으로 해시로 구현되어 있습니다. 모든 검색, 삽입이 해싱으로 O(1)로 모든 연산들이 상수시간의 시간복잡도를 갖습니다.
 * Boolen HashSet.contains(Object o) : contains()로 값 유무 확인하면 해싱을 하기 때문에 시간복잡도가 O(1) 입니다.
 *
 */
public class Ex03_01_Answer {
    public int solution(int[] nums){
        int answer = 0;

        // 중복제거
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);

        // 가장 긴 연속 수열 찾기
        for(int x : set){
            // 연속수열의 시작지점 확인
            if(set.contains(x - 1)) continue; // 원소보다 작은 값이 있으면 연속수열의 시작지점이 아니므로, SKIP

            // 연속수열 찾기
            int cnt = 0;
            while(set.contains(x)){ // 연속수열이 거짓이면 멈춤
                cnt++;
                x++; // 원소의 1 증가한 숫자가 있는 지 확인
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex03_01_Answer T = new Ex03_01_Answer();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
