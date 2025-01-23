package study.inflearn.lecture01.section3;

import java.util.Scanner;

/**
 * 에라토스테네스의 체 (소수를 찾는 가장 빠른 방법) </br>
 * 출처 : <a href="https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4">...</a> </br>
 * 반복문의 i번째 부터 i의 배수들 모두 체크하고 체크하지 못한 남은 숫자는 모두 소수라는 성질을 이용.
 */
public class Ex03_05_소수_답 {

    public int solution(int n) {
        int count = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i < n; i++) {
            if (ch[i] == 0) {
                count++;
                for (int j = i; j <= n ; j = j + i) {
                    ch[j] = 1;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Ex03_05_소수_답 T = new Ex03_05_소수_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(T.solution(n));
    }
}
