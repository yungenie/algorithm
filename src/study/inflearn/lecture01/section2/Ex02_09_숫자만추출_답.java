package study.inflearn.lecture01.section2;

import java.util.Scanner;


public class Ex02_09_숫자만추출_답 {

    public int solution1(String input) {
        int result = 0;
        for (char x : input.toCharArray()) {
            if (x >= 48 && x <= 57) result = result * 10 + (x-48);
        }
        return result;
    }

    public int solution2(String input) {
        String result = "";
        for (char x : input.toCharArray()) {
            if (Character.isDigit(x)) result += x;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Ex02_09_숫자만추출_답 T = new Ex02_09_숫자만추출_답();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution1(input));
        System.out.println(T.solution2(input));
    }
}
