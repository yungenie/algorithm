package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 동적프로그래밍01_거리두기 {
    static final int MOD = 100000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][5];
        dp[1][0] = 1;		//000
        dp[1][1] = 1;		//#00
        dp[1][2] = 1;		//0#0
        dp[1][3] = 1;		//00#
        dp[1][4] = 1;		//#0#

        for (int i = 2; i <= N; i++){
            // 전 줄에 스티커 하나도 붙어 있지 않는 경우(000)는 모든 경우 올 수 있음
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3] + dp[i-1][4]) % MOD;

            // 전 줄에 왼쪽 테이블만 스티커 붙어 있는 경우(#00)는 000, 0#0, 00# 경우만 올 수 있음.
            dp[i][1] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % MOD;

            // 전 줄에 가운데 테이블만 스티커 붙어 있는 경우(0#0)는 000, #00, 00#, #0# 경우만 올 수 있음.
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % MOD;

            // 전 줄에 오른쪽 테이블만 스티커 붙어 있는 경우(00#)는 000, #00, 0#0 경우만 올 수 있음.
            dp[i][3] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % MOD;

            // 전 줄에 양쪽 테이블에 스티커가 붙어 있는 경우(#0#)는 000, 0#0 경우만 올 수 있음.
            dp[i][4] = (dp[i-1][0] + dp[i-1][2]) % MOD;
        }

        long answer = (dp[N][0] + dp[N][1] + dp[N][2] + dp[N][3] + dp[N][4]) % MOD;

        System.out.println(answer);



    }
}
