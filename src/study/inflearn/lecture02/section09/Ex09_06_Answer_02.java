package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 수확 - 다이나믹 프로그래밍 (백준 - 1823)
 * 메모리 : 33824KB, 시간 : 284ms
 */
public class Ex09_06_Answer_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 벼의 가치 n+1 잡는 이유는 입력 데이터의 순서를 1부터하기 위함
        int[] nums = new int[n + 1]; //✨
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        // 벼의 가치 누적합
        int[] sums = new int[n + 1]; //✨
        sums[1] = nums[1]; //✨
        for (int i = 2; i <= n; i++) { //✨
            sums[i] = sums[i - 1] + nums[i]; //✨
        }

        // i번째 벼부터 j번째 벼까지 수확했을 때 얻는 최대 이익
        int[][] dp = new int[n + 1][n + 1]; //✨
        // 벼 1개 경우
        for (int i = 1; i <= n; i++) {
            dp[i][i] = nums[i];
        }
        // 벼 2개이상 경우
        for (int i = 1; i < n ; i++) { //✨
            for (int j = 1; j <= n-i; j++) { //✨
                /*
                    예시)
                    3 1 5 2 일 때
                        - 3 | 1 5 2, j+1번째부터 j+i번째까지의 dp값 + (3x1, 3을 먼저 수확) + (1+5+2, 나머지 벼들도 번째 증가되는 효과)
                        - 3 1 5 | 2, j번째부터 j+i+1번째까지의 dp값 + (2x1, 2를 먼저 수확) + (3+1+5, 나머지 벼들도 번째 증가되는 효과)
                        - 결국, 부분 경우의 수 전체(3+1+5+2)를 더하면 모두 한번씩 번째가 증가된다.
                            - 3 | 1 5 2, 1 5 2가 1x3 + 5x2 + 2x1의 순서로 벼를 수확했을 때
                                - 1 5 2 dp값에서 3의 벼를 첫번째로 수확하는 경우를 합산해야한다.
                                - 3x1 + 1x4 + 5x3 + 2x2로 계산되어야 하기 때문에 3+1+5+2 주어진 수를 모두 합하면 된다.
                        - 벼의 가치 누적합의 배열을 사용한다.
                            - j번째~j+i번째의 누적합은 누적배열의 j+i번째 - j-1번째를 빼면 된다.
                 */
                dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i])
                        + (sums[j + i] - sums[j - 1]); //✨
            }
        }

        System.out.println(dp[1][n]);
    }
}
