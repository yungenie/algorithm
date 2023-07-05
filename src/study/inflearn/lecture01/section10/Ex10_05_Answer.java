package study.inflearn.lecture01.section10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전교환(냅색 알고리즘) - dynamic programming(동적계획법)
 * 소요시간 : 23분
 */
public class Ex10_05_Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 동전종류 개수
        int n = sc.nextInt();

        // 동전종류
        int[] mArr = new int[n];
        for (int i = 0; i < n; i++) {
            mArr[i] = sc.nextInt();
        }

        // 금액
        int m = sc.nextInt();
        int[] dp = new int[m+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //dp[0] = 0; //왜?

        for (int money : mArr) {
            // DP탐색
            for (int i = money; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], i/money + i%money); // 거슬러 줄 동전의 최소개수
                //dp[i] = Math.min(dp[i], dp[i-money] + 1); // 거슬러 줄 동전의 최소개수
            }
        }
        System.out.println(">> " + dp[m]);
    }
}
