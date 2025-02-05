package study.inflearn.lecture01.section4;

import java.util.Scanner;

/**
 * 수학적 방법
 */
public class Ex04_05_연속된자연수의합_답2 {

    public int solution(int n) {
        int answer = 0, cnt = 1;
        n--; // 1부터 시작함을 가정
        while (n > 0) {
            cnt++; // 연속된 수의 개수
            n = n - cnt;
            if (n % cnt == 0) answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Ex04_05_연속된자연수의합_답2 T = new Ex04_05_연속된자연수의합_답2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}

