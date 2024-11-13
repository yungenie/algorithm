package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 기초09_수열_02 {

    public static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        if (K == 1) {
            System.out.println(0);
            return;
        } else if (K == 2) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[K+1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= K; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%MOD;
        }

        System.out.println(dp[K]);
    }
}
/**
 * 재귀적 피보나치 수열 계산해서 K값 커질 수록 메서드 호출이 많아지므로, 시간초과(timeout), 스택 오버플로우(RuntimeError) 발생
 * 동적 프로그래밍 Dynamic Programming 접근 방식 사용
 * 배열을 이용한 반복문 방식으로 이전에 계산한 값을 저장, 중복 계산 피하고, 시간복잡도 O(k)로 줄인다.
 */