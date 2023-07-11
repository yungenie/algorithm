package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 수확 - 다이나믹 프로그래밍 (백준 - 1823)
 * 강사님 해법 강의 듣고 재도전
 * 메모리 : 33980KB, 시간 : 328ms
 */
public class Ex09_06_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 벼의 가치 0 ~ n+1
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        // 벼의 가치 누적합
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += nums[j];
            }
            sums[i] = sum;
        }
        // dp정의
        int[][] dp = new int[n + 1][n + 1];
        // 벼 1개 경우
        for (int i = 1; i <= n; i++) {
            dp[i][i] = nums[i];
        }
        // 벼 2개이상 경우
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= n-i; j++) {
                if (j + 1 == j + i) {
                    dp[j][j + i] = Math.max(dp[j][j], dp[j + i][j + i]) + (sums[j + i] - sums[j - 1]);
                } else {
                    dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i]) + (sums[j + i] - sums[j - 1]);
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
