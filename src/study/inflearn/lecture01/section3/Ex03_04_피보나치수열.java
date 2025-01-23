package study.inflearn.lecture01.section3;

import java.util.Scanner;

/**
 * 정답.
 * 8분 11초
 */
public class Ex03_04_피보나치수열 {

    public int[] solution(int n) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        return result;
    }

    public static void main(String[] args) {
        Ex03_04_피보나치수열 T = new Ex03_04_피보나치수열();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int x : T.solution(n)) {
            System.out.print(x + " ");
        }
    }
}
