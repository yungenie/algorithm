package study.inflearn.lecture01.section2;

import java.util.Scanner;

/**
 * 정답.
 * 7분 24초
 */
public class Ex02_07_회문문자열 {

    public String solution(String input) {
        String result = "";
        String lowInput = input.toLowerCase();
        StringBuilder sb = new StringBuilder(lowInput);
        sb.reverse();
        String reverseInput = sb.toString();

        if (lowInput.equals(reverseInput)) result = "YES";
        else result = "NO";

        return result;
    }

    public static void main(String[] args) {
        Ex02_07_회문문자열 T = new Ex02_07_회문문자열();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution(input));
    }
}
