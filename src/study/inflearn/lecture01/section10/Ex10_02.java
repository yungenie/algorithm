package study.inflearn.lecture01.section10;

import java.util.Scanner;

/**
 * 돌다리 건너기 (백준)
 * 틀려서 강사님 강의 듣고 수정함.
 * - 계단 오르기를 풀었다면 간파를 하고 바로 풀어버렸어야하는 문제. 간파를 못했다..
 * - 계단 오르기와 다른 점은 계단 오르기는 마지막 계단까지 올라갈 수 있는 방법으로 dp[N]까지 계산하면 된다.
 * - 돌다리 건너기는 모든 돌다기를 건너야하기 때문에 마지막 돌다리를 건너 땅까지 도착했을때의 경우의 수 dp[N+1]를 구해야한다.
 * - 마지막 돌다리 건너는 수까지 생각하지 못했다. 그래서 다른 점화식을 계속 생각해봤음.
 */
public class Ex10_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp[i]는 i번째 돌다리까지 건너뛰는 경우의 수
        int[] dp = new int[N + 2]; // 개울 만나기 전/후 땅까지 포함해야함.
        dp[1] = 1; // 돌다리 첫번째
        dp[2] = 2; // 돌다리 두번째
        for (int i = 3; i <=N + 1 ; i++) { // 돌다리 세번째부터 도착한 땅까지 탐색
            dp[i] = dp[i - 1] + dp[i - 2]; // 이전 + 전전 경우의 수 합산
        }

        System.out.println(dp[N+1]); // 도착한 땅
    }
}

