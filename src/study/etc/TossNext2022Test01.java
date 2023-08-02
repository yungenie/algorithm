package study.etc;

import java.util.Scanner;

/**
 * [토스 NEXT] 2022년 코딩테스트 기출문제
 * https://toss.im/career/article/next-developer-2023-sample-questions
 */
public class TossNext2022Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int biggest = -1;
        for (int i = 0; i < s.length()-2; i++) {
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)) {
                biggest = Math.max(biggest, Integer.parseInt(s.substring(i, i + 3)));
            }
        }
        System.out.println("biggest = " + biggest);
    }
}
