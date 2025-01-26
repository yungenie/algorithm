package study.inflearn.lecture01.section3;

import java.util.Scanner;

public class Ex03_09_격자판최대합 {

    public int solution(int n, int[][] array) {

        int maxSum = 0;
        int iSum = 0;
        int jSum = 0;
        int acrossSum = 0;
        int bcrossSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 행의 합
                iSum += array[i][j];
                // 열의 합
                jSum += array[j][i];
            }
            maxSum = Math.max(maxSum, iSum);
            maxSum = Math.max(maxSum, jSum);
            iSum = 0;
            jSum = 0;

            // 각 대각선
            acrossSum += array[i][i];
            bcrossSum += array[i][n-1-i];
        }
        maxSum = Math.max(maxSum, acrossSum);
        maxSum = Math.max(maxSum, bcrossSum);

        return maxSum;
    }

    public static void main(String[] args) {
        Ex03_09_격자판최대합 T = new Ex03_09_격자판최대합();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, array));
    }
}
