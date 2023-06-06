package study.inflearn.lecture02.section05;

import java.util.Arrays;

/**
 * 스프링 쿨러 - greedy
 */
public class Ex05_03_Answer {
    public int solution(int n, int[] nums){
        int answer = 0;
        System.out.println("nums = " + nums.length);
        //int[][] line = new int[nums.length + 1][2]; // todo N+1의미? new int[n+1] 아닌가?
        int[][] line = new int[n+1][2];
        for(int i = 0; i <= n; i++){
            line[i][0] = Math.max(0, i - nums[i]); // 음수인 경우 
            line[i][1] = Math.min(n, i + nums[i]); // n개를 넘는 경우
        }
        Arrays.sort(line, (a, b) -> a[0] - b[0]);
        System.out.println("Arrays.deepToString(l) = " + Arrays.deepToString(line));
        int start = 0, end = 0, i = 0;
        while(i < line.length){
            while(i < line.length && line[i][0] <= start){
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;
            if(end == n) return answer;
            if(start == end) return -1;
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
