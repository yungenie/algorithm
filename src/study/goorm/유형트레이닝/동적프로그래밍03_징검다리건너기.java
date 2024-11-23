package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적프로그래밍03_징검다리건너기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] water = new int[N+2]; // 징검다리 출발전, 도착후까지 포함.
        int[] dp = new int[N+2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 징검다리 부분만 데이터 저장. 출발, 도착은 0으로 세팅
            water[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = water[1];
        dp[2] = water[2];
        dp[3] = water[3];

        // 최대 점프력 3으로, 징검다리 전에서 4까지가 최대 점프이므로 4부터 시작.
        int min = 0;
        for (int i = 4; i < N+2; i++) {
            min = water[i] + dp[i-1];
            for (int j = i-3; j < i-1; j++) {
                // 현재 + 전, 전전, 전전전 3가지 경우 중 제일 작은 값 세팅
                min = Math.min(water[i] + dp[j], min);
            }
            dp[i] = min;
        }

        System.out.println(dp[N+1]);

    }
}
