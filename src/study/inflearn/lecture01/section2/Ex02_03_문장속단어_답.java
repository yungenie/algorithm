package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_03_문장속단어_답 {
    public String solution1(String str) {
        String answer = "";
        String[] s = str.split(" ");
        int m = Integer.MIN_VALUE;
        for (String x : s) {
            int len = x.length(); // 요소의 길이
            if (len > m) {
                m = len;
                answer = x;
            }
        }
        return answer;
    }
    
    public String solution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(' ')) !=-1){
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            // 문자열의 왼쪽부터 짤라내서 처리
            str = str.substring(pos+1);
        }
        if (str.length() > m) {
            answer = str;
        }

        return answer;
    }
    public static void main(String[] args) {
        Ex02_03_문장속단어_답 T = new Ex02_03_문장속단어_답();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution1(str));
        System.out.println(T.solution2(str));




    }
}
