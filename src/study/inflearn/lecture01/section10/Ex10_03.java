package study.inflearn.lecture01.section10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 최대 부분 증가수열
 * 강사님 해법 듣고 재도전
 */
public class Ex10_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N개의 자연수로 이루어진 수열
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // i번째 까지의 수열 중 부분증가수열의 최대 길이
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {

            /*
                error max = -1 초기화 해서 인프런 채점 사이트에서 컴파일 에러남.
                max = 0 으로 초기화 해야함.
                주어진 자연수가 4672인 경우
                    - nums[i]가 2인 경우 아래 if문에 걸리지 않으므로 max의 초기값이 셋팅된다.
                    - max + 1 -> -1 + 1로 0이 되버리기 때문에 0으로 초기화 해야한다.
             */
            int max = 0;
            for (int k = i-1; k >=0 ; k--) {
                /*
                 * 현재 수와 배열의 앞에 수열들 탐색하며 작은 값만 탐색
                 *  - nums[i-1...] < nums[i]
                 * 앞에 수열들 dp 값 중 최대값 선택
                 *  - dp[i-1..] vs dp[i-2..] 최대값 선택
                 */
                if (nums[k] < nums[i]) max = Math.max(dp[k], max);
            }
            dp[i] = max + 1;

        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}

/*
9
2 7 5 8 6 4 7 12 3
>> 5

8
5 3 7 8 6 2 9 4
>> 4
 */