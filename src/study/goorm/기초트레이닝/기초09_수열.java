package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 기초09_수열 {

    static int sum = 0;

    private static int DFS(int n) {

        if (n == 2) return 1;
        if (n == 1) return 0;

        return DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        System.out.println(DFS(K)%1000000007);
    }
}
/**
 * 재귀적 피보나치 수열 계산해서 K값 커질 수록 메서드 호출이 많아지므로, 시간초과(timeout), 스택 오버플로우(RuntimeError) 발생
 */