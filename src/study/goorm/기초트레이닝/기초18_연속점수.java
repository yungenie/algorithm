package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 기초18_연속점수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 문제 풀고 S점수 받는데, 1문제만 푼다.
         * 연속해서 풀면 점수 얻을 수 없다. >> 연속된 번호와 점수가 1씩 동일하게 증가할때 점수의 합산.
         *
         * 최소한의 문제를 풀어서 최고의 점수를 얻는다..
         * dp
         */

        int N = Integer.parseInt(br.readLine());
        int[] problem = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        dp[0] = problem[0];
        for (int i = 1; i < N; i++) {
            if (problem[i] - problem[i-1] == 1) {
                dp[i] = dp[i-1] + problem[i];
            } else {
                // 연속되지 않는 점수는 무조건 "새로운 시작"으로 처리
                dp[i] = problem[i];
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}


/**
 * 반례 입력 예시
 * 10 11 12 20 21 22 23 30 31 32
 */