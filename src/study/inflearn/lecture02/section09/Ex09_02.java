package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 수도배관공사 - 다이나믹 프로그래밍 (백준 - 2073)
 * 강사님 해법 듣고 재도전 (소요시간 : 18분)
 */
public class Ex09_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(); // 수도관 길이
        int P = sc.nextInt(); // 파이프 수

        // DP탐색 - 가능한 최대 수도관 용량
        int[] dp = new int[D+1]; // 다이나믹 테이블
        for (int i = 0; i < P; i++) {
            int L = sc.nextInt(); // 파이프 길이
            int C = sc.nextInt(); // 파이프 용량
            for (int j = D; j >= L ; j--) {
                // 수도관 길이가 1개의 파이프 길이와 딱 떨어져 맞을 경우
                if (j == L) dp[j] = Math.max(dp[j], C); // 기존 용량과 변경할 파이프 용량 중 최대 용량
                // 수도관 길이에 맞춰서 만들 수 없을 경우
                if (dp[j - L] == 0) continue; // 없는 파이프로 만들 수 없음.
                // 최대 수도관 용량
                /// 변경할 수도관은 수도관 길이만큼 이루어진 파이프들 중 최소값
                /// 기존의 수도관과 변경할 수도관 중 최대 용량 선택
                dp[j] = Math.max(dp[j], Math.min(dp[j - L], C));
            }
        }
        System.out.println("dp = " + dp[D]);
    }
}
