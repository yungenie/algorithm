package study.inflearn.lecture01.section2;

import java.util.Scanner;

/**
 * 정답.
 * 22분 16초
 */
public class Ex02_08_유효한팰린드롬 {

    public String solution(String[] inputs) {
        String result = "YES";

        for (int i = 0; i < inputs.length; i++) {
            char[] charArray = inputs[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : charArray) {
                if (Character.isAlphabetic(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }
            inputs[i] = sb.toString();
        }

        int lt = 0, rt = inputs.length - 1;
        while (lt <= rt) {
            StringBuilder sb = new StringBuilder(inputs[rt]);
            String reverseStr = sb.reverse().toString();
            if (!inputs[lt].equals(reverseStr)) {
                result = "NO";
            }
            lt++;
            rt--;
        }

        return result;
    }



    public static void main(String[] args) {
        Ex02_08_유효한팰린드롬 T = new Ex02_08_유효한팰린드롬();
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        System.out.println(T.solution(inputs));
    }
}
