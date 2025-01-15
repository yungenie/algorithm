package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_05_특정문자뒤집기_답 {

    public String solution(String str) {
        String answer = "";
        char[] charArray = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) lt++;
            else if (!Character.isAlphabetic(charArray[rt])) rt--;
            else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
            }
        }
        answer= String.valueOf(charArray);
        return answer;

    }

    public static void main(String[] args) {
        Ex02_05_특정문자뒤집기_답 T = new Ex02_05_특정문자뒤집기_답();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
