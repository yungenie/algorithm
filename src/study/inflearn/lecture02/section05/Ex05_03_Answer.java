package study.inflearn.lecture02.section05;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 스프링 쿨러 - greedy
 */
public class Ex05_03_Answer {
    public int solution(int n, int[] nums){
        int answer = 0;

        // 스프링 쿨러 범위 (시작, 끝) 2차원 배열에 초기화
        int[][] line = new int[n+1][2];
        for(int i = 0; i <= n; i++){
            line[i][0] = Math.max(0, i - nums[i]); // 시작 값이 음수인 경우 0으로 셋팅
            line[i][1] = Math.min(n, i + nums[i]); // 끝 값이 n개를 넘는 경우 n으로 셋팅
        }
        Arrays.sort(line, Comparator.comparingInt(a -> a[0])); //(a, b) -> a[0] - b[0]

        // 스프링 쿨러 최소개수
        int start = 0, end = 0, i = 0;
        // 잔디밭의 각 위치마다 체크
        while(i < line.length){
            // 스타트지점에서 범위가 오른쪽에서 가장 긴거 선택
            while(i < line.length && line[i][0] <= start){
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++; // 스프링쿨러 개수 카운팅
            if(end == n) return answer; //
            if(start == end) return -1; // 중간에 끊긴 경우는 end 값이 갱신되지 않아서 s==e가 같다.
            start = end;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex05_03_Answer T = new Ex05_03_Answer();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
