package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_01_문자찾기_답 {

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char x :  str.toCharArray()) {
            if (x == t) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex02_01_문자찾기_답 T = new Ex02_01_문자찾기_답();
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char findText = sc.next().charAt(0);
        System.out.println(T.solution(text, findText));
    }
}
