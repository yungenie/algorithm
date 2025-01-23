package study.inflearn.lecture01.section3;

import java.util.Scanner;

public class Ex03_04_피보나치수열_답 {

    /**
     * 배열로 풀지 않고 손코딩 용
     */
    public void solution(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

    }

    public static void main(String[] args) {
        Ex03_04_피보나치수열_답 T = new Ex03_04_피보나치수열_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        T.solution(n);
    }
}
