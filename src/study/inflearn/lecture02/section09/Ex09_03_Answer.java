package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 계단 오르기 - 다이나믹 프로그래밍 (백준 - 2579)
 */
public class Ex09_03_Answer {
    public int solution(int n, int[] score) {
        int[] dy = new int[n + 1];
        dy[1] = score[1]; // 첫번째 계단 점수
        if (n > 1) dy[2] = score[1] + score[2]; // 두번째 계단 점수 (두 계단 점프 하는 것 보다 연속으로 오르는 점수가 항상 큼)
        for (int i = 3; i <=n ; i++) {
            dy[i] = Math.max(dy[i - 2] + score[i], dy[i - 3] + score[i - 1] + score[i]);
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Ex09_03_Answer T = new Ex09_03_Answer();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 총 계단의 개수
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt(); // 각 계단에 씌여진 점수
        }
        System.out.println(T.solution(n, score));
    }
}
/*
6
10
20
15
25
10
20
>> 75
 */