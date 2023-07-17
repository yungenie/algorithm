package study.inflearn.lecture01.section10;

import java.util.Scanner;

/**
 * 가장 높은 탑 쌓기
 * 2시간 풀었다. 입력예제1은 통과, 코딩채점에서는 틀림
 */
public class Ex10_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] area = new int[n + 1];
        int[] height = new int[n + 1];
        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            area[i] = sc.nextInt();
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        // i번째 벽돌이 가장 높이 쌓을 수 있는 탑의 높이
        int[] dp = new int[n + 1];

        /*
            탑을 쌓을 수 있는 조건
            - 벽돌탑은 내려갈 수록 밑면이 넓고 무게가 무겁다.
         */

        for (int i = 1; i <= n ; i++) {
            int h = 0;
            if (area[i] < area[i-1] && weight[i] < weight[i-1]) {
                h = height[i-1];
            }
            for (int j = i-2; j > 0 ; j--) {
                if (area[i] < area[j] && weight[i] < weight[j]) {
                    h = Math.max(h, dp[j]);
                }
            }
            dp[i] = Math.max(dp[i], h + height[i]);
        }
        System.out.println(dp[n]);
    }
}
/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2
>> 10
 */