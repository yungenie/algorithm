package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_06_중복문자제거_답 {

    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            // 인덱스 판별
            // 지금 현재 인덱스와 문자열에서 해당 문자의 인덱스가 동일한 지점이 최초 발견.
            if (i == str.indexOf(str.charAt(i))) {
                answer+=str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex02_06_중복문자제거_답 T = new Ex02_06_중복문자제거_답();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
 