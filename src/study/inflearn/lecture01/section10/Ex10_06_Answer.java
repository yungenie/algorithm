package study.inflearn.lecture01.section10;

import java.util.Scanner;

/**
 * 최대점수 구하기(냅색 알고리즘) - dynamic programming(동적계획법)
 * 소요시간 : 6분
 */
public class Ex10_06_Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제개수
        int m = sc.nextInt(); // 제한시간


        int[] dp = new int[m+1];
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt(); // 점수
            int time = sc.nextInt(); // 걸리는 시간

            /*
             * DP탐색
             * 한 유형단 한개만 풀 수 있다.
             * - 제한개수가 1개 또는 유한으로 정해져 있을 경우
             * - 뒤에서부터 탐색해야 중복을 회피합니다.
             */
            for (int j = m; j >= time; j--) {
                // 제한 시간안에 얻을 수 있는 최대 점수
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }
        System.out.println(">> " + dp[m]);
    }
}
