package study.inflearn.lecture01.section2;

import java.util.*;


public class Ex02_04_단어뒤집기 {

    /**
     * StringBuilder 이용
     */
    public String solution1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 직접 뒤집기
     * 1. 문자열 -> char 배열
     * 2. 문자열 객체(StringBuilder)에 char 배열의 마지막 요소부터 합산
     */
    public String solution2(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Ex02_04_단어뒤집기 T = new Ex02_04_단어뒤집기();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String text = sc.next();
            System.out.println(T.solution1(text));
            System.out.println(T.solution2(text));
        }

    }
}
