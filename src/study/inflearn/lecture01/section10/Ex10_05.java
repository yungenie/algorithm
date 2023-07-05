package study.inflearn.lecture01.section10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전교환(냅색 알고리즘) - dynamic programming(동적계획법)
 * 소요시간 : 23분
 * -> dp[0] = 0 안해서 틀림
 * -> 추가 입력케이스 틀림
 * -> dp배열의 Interger.MAX_VALUE 초기화 틀림
 * -> 이 문제는 Ex10_05_Answer보기
 */
public class Ex10_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 동전종류 개수
        int n = sc.nextInt();

        // 동전종류
        int[] mArr = new int[n];
        for (int i = 0; i < n; i++) {
            mArr[i] = sc.nextInt();
        }

        // 금액
        int m = sc.nextInt();
        int[] dp = new int[m+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // note MAX_VALUE로 초기화 되었기 때문에 dp[0]은 0으로 초기화 해줘야한다.

        for (int money : mArr) {
            // DP탐색
            for (int i = money; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], i/money + i%money); // 틀림
            }
        }
        System.out.println(">> " + dp[m]);
    }
}

/*
입력예제1
3
1 2 5
15
>> 3

입력예제2
3
2 3 4
15
>> 4
 */