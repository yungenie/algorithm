package study.inflearn.lecture01.section2;

import java.util.Scanner;

public class Ex02_08_유효한팰린드롬_답 {

    public String solution(String str) {
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Ex02_08_유효한팰린드롬_답 T = new Ex02_08_유효한팰린드롬_답();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
