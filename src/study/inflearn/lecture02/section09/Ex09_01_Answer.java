package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 사탕 가게 - 다이나믹 프로그래밍
 */
public class Ex09_01_Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(); // 사탕 종류
            int m = (int) Math.round(sc.nextDouble() * 100); // 돈의 양
            if (n == 0 && m == 0) {
                break;
            }

            int[] dy = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int c = sc.nextInt(); // 사탕 칼로리
                int p = (int) Math.round(sc.nextDouble() * 100); // 사탕 가격
                // DP탐색
                for (int j = p; j <= m; j++) {
                    dy[j] = Math.max(dy[j], dy[j - p] + c);
                }
            }
            System.out.println(dy[m]);
        }
    }
}
/*
예제 입력1
2 8.00
700 7.00
199 2.00
3 8.00
700 7.00
299 3.00
499 5.00
0 0.00

예제 출력1
796
798
 */