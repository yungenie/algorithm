package study.inflearn.lecture01.section2;

import java.util.Scanner;


public class Ex02_07_회문문자열_답 {

    //문자열을 반 나눠서 왼쪽과 오른쪽 비교 ex) gooG, gouoG
    public String solution1(String input) {
        String result = "YES";
        input = input.toUpperCase();
        int len = input.length();
        for (int i = 0; i < len/2; i++) {
            if (input.charAt(i) != input.charAt(len-i-1)) result = "NO";
        }

        return result;
    }

    // 기존 문자열과 회문 문자열 비교
    public String solution2(String input) {
        String result = "NO";
        String tmp = new StringBuilder(input).reverse().toString();
        if (input.equalsIgnoreCase(tmp)) result = "YES";
        return result;
    }

    public static void main(String[] args) {
        Ex02_07_회문문자열_답 T = new Ex02_07_회문문자열_답();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution1(input));
        System.out.println(T.solution2(input));
    }
}
