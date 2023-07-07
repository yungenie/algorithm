package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 계단 오르기 - 다이나믹 프로그래밍 (백준 - 2579)
 * 강사님 해법 듣고 재도전 (소요시간 : 19분)
 */
public class Ex09_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 계단의 개수
        int[] score = new int[N+1]; // 계단 점수 배열
        for (int i = 1; i <= N; i++) {
            score[i] = sc.nextInt(); // 계단 점수 초기화
        }

        // DP탐색
        int[] dp = new int[N+1]; // 다이나믹 테이블
        for (int i = 1; i < dp.length; i++) {
            if (i == 1) { // 첫번째 계단
                dp[1] = score[1];
                continue;
            }
            if (i == 2) { // 두번째 계단 (두계단씩 오르는 것 보다, 2개의 계단을 밟는게 점수가 더 큼)
                dp[2] = score[1] + score[2];
                continue;
            }
            dp[i] = Math.max(dp[i - 2] + score[i], dp[i - 3] + score[i - 1] + score[i]);
        }
        System.out.println("dp = " + dp[N]);
    }
}
/*
6
10
20
15
25
10
20
>> 75
 */