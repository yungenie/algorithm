package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적프로그래밍03_징검다리건너기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] water = new int[N+2];
        int[] dp = new int[N+2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = water[1];
        dp[2] = water[2];
        dp[3] = water[3];

        int min = 0;
        for (int i = 4; i < N+2; i++) {
            min = dp[i-1] + water[i];
            for (int j = i-3; j < i-1; j++) {
                min = Math.min(dp[j] + water[i], min);
            }
            dp[i] = min;
        }

        System.out.println(dp[N+1]);

    }
}
