package study.inflearn.lecture01.section2;

import java.util.Scanner;

/**
 * 정답
 * 5분
 */
public class Ex02_09_숫자만추출 {

    public int solution(String input) {
        int result = 0;
        char[] charArray = input.toCharArray();
        StringBuilder sbNum = new StringBuilder();
        for (char c : charArray) {
            if (!Character.isAlphabetic(c)) {
                sbNum.append(c);
            }
        }
        result = Integer.parseInt(sbNum.toString());
        return result;
    }

    public static void main(String[] args) {
        Ex02_09_숫자만추출 T = new Ex02_09_숫자만추출();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution(input));
    }
}
