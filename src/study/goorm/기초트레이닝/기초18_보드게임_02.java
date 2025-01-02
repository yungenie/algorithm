package study.goorm.기초트레이닝;

import java.util.Scanner;

public class 기초18_보드게임_02 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 도착 지점 칸

        // DP 배열 생성
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 1; // 시작점에서 시작점으로 가는 방법은 1가지

        // DP 점화식 계산
        /**
         * DP i점마다 이동하는 경우의 수 : DP[i-1](전 칸에서 1칸 이동) + DP[i-3](3칸 이동)
         */
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // 1칸 이동하는 경우
            if (i >= 3) {
                dp[i] = (dp[i] + dp[i - 3]) % MOD; // 3칸 이동하는 경우
            }
        }

        // 결과 출력
        System.out.println(dp[n]);
    }
}