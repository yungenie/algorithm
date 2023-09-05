package study.inflearn.lecture01.section10;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10_06_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 문제의 개수
        int M = sc.nextInt(); // 제한 시간

        // DP탐색 - 제한시간 안에 얻을 수 있는 최대 점수
        int[] dp = new int[M+1];
        for (int i = 0; i < N; i++) {
            int score = sc.nextInt(); // 얻는 점수
            int time = sc.nextInt(); // 걸리는 시간
            for (int j = M; j >= time ; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[M]);
    }
}
