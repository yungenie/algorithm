package study.inflearn.lecture01.section2;


import java.util.Scanner;

/**
 * 정답.
 * 1시간 10분 - 처음에 문제 잘못 이해함.
 */
public class Ex02_11_문자열압축 {

    public String solution(String text) {

        StringBuilder result = new StringBuilder();

        int count = 1;
        String[] strArr = text.split("");
        String beforeS = strArr[0];

        for (int i = 1; i < strArr.length; i++) {
            if (!beforeS.equals(strArr[i])) {
                if (count == 1) {
                    result.append(beforeS);
                } else {
                    result.append(beforeS).append(count);
                    count = 1;
                }
            } else {
                count++;
                if (i == strArr.length - 1) {
                    result.append(beforeS).append(count);
                }
            }
            beforeS = strArr[i];
        }

        return result.toString();
    }


    public static void main(String[] args) {
        Ex02_11_문자열압축 T = new Ex02_11_문자열압축();
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println(T.solution(text));
    }
}
