package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 알고리즘 유형 : dp (동적 계획법)
 */
public class 기초21_RGB주차장_02 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기화: 이전 칸에서 R, G, B의 경우의 수
        int prevR = 1, prevG = 1, prevB = 1;
        final int MOD = 100_000_007;
        for (int i = 2; i <= N; i++) {
            int currR = (prevG + prevB) % MOD; // i번째 칸이 빨강일때, i-1번째 칸은 초록 또는 파랑의 경우의 수 합
            int currG = (prevR + prevB) % MOD; // i번째 칸이 초록일때, i-1번째 칸은 빨강 또는 파랑의 경우의 수 합
            int currB = (prevR + prevG) % MOD; // i번째 칸이 파랑일때, i-1번째 칸은 빨강 또는 초록의 경우의 수 합

            // 업데이트
            prevR = currR;
            prevG = currG;
            prevB = currB;
        }

        // 모든 경우의 수 합산
        int result = (prevR + prevG + prevB) % MOD;
        System.out.println(result);
    }
}
