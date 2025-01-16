package study.inflearn.lecture01.section2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex02_06_중복문자제거 {

    public void solution(String input) {
        String[] strArr = input.split("");
        Arrays.stream(strArr).distinct().forEach(System.out::print);
    }

    public static void main(String[] args) {
        Ex02_06_중복문자제거 T = new Ex02_06_중복문자제거();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        T.solution(input);
    }
}
