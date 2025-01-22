package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_12_암호_답 {

    public String solution(int n, String s) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            // 2진수 변환
            String tmp = s.substring(0, 7)
                    .replace('#', '1')
                    .replace('*', '0');

            // 10진수 변환
            int num = Integer.parseInt(tmp, 2); // radix 2진수

            // 아스키코드 변환
            answer += (char) num;

            s = s.substring(7);
        }


        return answer;
    }

    public static void main(String[] args) {
        Ex02_12_암호_답 T = new Ex02_12_암호_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(T.solution(n, s));
    }
}
