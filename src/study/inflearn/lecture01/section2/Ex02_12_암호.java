package study.inflearn.lecture01.section2;

import java.util.Scanner;

/**
 * 정답.
 * 43분
 */
public class Ex02_12_암호 {

    public String solution(int n, String s) {
        StringBuilder result = new StringBuilder();

        int beginIndex = 0;
        int endIndex = 7;
        while (s.length() >= endIndex) {

            // 7개 # or * -> 2진수
            String secretText = s.substring(beginIndex, endIndex);
            StringBuilder binaryText = new StringBuilder();
            for (String x : secretText.split("")) {
                if ("#".equals(x)) binaryText.append(1);
                else binaryText.append(0);
            }

            // 2진수 -> 10진수
            int total = 0;
            int multiply = 128;
            for (String xx : binaryText.toString().split("")) {
                int a = Integer.parseInt(xx);
                multiply = multiply/2;
                total += Math.multiplyExact(a, multiply);
            }


            // 10진수 -> 알파벳
            String alphabet = Character.getName(total).split(" ")[3];
            result.append(alphabet);

            beginIndex = beginIndex + 7;
            endIndex = endIndex + 7;

        }


        return result.toString();
    }

    public static void main(String[] args) {
        Ex02_12_암호 T = new Ex02_12_암호();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(T.solution(n, s));
    }
}
