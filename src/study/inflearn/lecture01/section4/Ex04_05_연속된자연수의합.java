package study.inflearn.lecture01.section4;

import java.util.Scanner;

public class Ex04_05_연속된자연수의합 {

    public int solution(int n) {
        int answer = 0;

        // 연속된 자연수 배열
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        // 슬라이딩 윈도우 + 투 포인터스 알고리즘
        int sum = 0, lt = 1;
        for (int rt = 1; rt < n; rt++) {
            sum += arr[rt]; // 합산
            if (sum == n) answer++; // 같은 지 비교
            while (sum > n) { // 기준보다 크면
                sum -= arr[lt]; // 왼쪽부터 제외
                if (sum == n) { // 제외하면서 같은 지 비교
                    answer++;
                }
                lt++; // 왼쪽 증감
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Ex04_05_연속된자연수의합 T = new Ex04_05_연속된자연수의합();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}

/**
 * 2개 이상.
 * 대신, 연속된
 * 1 2 3 4 5 6 7... N
 *
 *
 *
 */