package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_05_특정문자뒤집기_답 {

    public String solution(String str) {
        String answer = "";
        char[] charArray = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            /*
               lt        rt
                a#b!GE*T@S
                왼쪽, 오른쪽 문자가 특수문자일 경우 왼쪽(lt)은 증가, 오른쪽(rt)은 감소
                왼쪽, 오른쪽 둘다 알파벳일 때 교환.
             */
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
