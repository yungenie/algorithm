package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_01_문자찾기 {

    public int solution(String text, String findText) {
        // 입력받은 문자열, 특정문자 소문자로 변환
        text = text.toLowerCase();
        findText = findText.toLowerCase();

        // 반복문을 통해 문자 요소와 특정문자 비교 후 counting
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            String s = String.valueOf(text.charAt(i));
            if (findText.equals(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Ex02_01_문자찾기 T = new Ex02_01_문자찾기();
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String findText = sc.next();
        System.out.println(T.solution(text, findText));
    }
}
