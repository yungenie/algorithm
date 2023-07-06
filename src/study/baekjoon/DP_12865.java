package study.baekjoon;

import java.util.Scanner;

public class DP_12865 {
    public int solution(int N, int K, int[][] WV) {

        // DP탐색
        int[] dp = new int[K + 1]; // idx 버틸무게, value 가치
        for (int i = 0; i < N; i++) {
            int W = WV[i][0]; // 각 물건 무게 W
            int V = WV[i][1]; // 각 물건의 가치 V

            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }
        return dp[K];
    }

    public static void main(String[] args) {
        DP_12865 T = new DP_12865();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 물품 수 N
        int K = sc.nextInt(); // 버틸 무게 K

        int[][] WV = new int[N][2];
        for (int i = 0; i < N; i++) {
            WV[i][0] = sc.nextInt(); // 각 물건 무게 W
            WV[i][1] = sc.nextInt(); // 각 물건의 가치 V
        }
        System.out.println(T.solution(N, K, WV));
    }
}
