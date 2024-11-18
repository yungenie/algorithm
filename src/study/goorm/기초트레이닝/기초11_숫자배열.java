package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 기초11_숫자배열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];

        int value = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                value++;
                array[i][j] = value;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != N-1){
                    System.out.print(array[i][j] + " ");
                } else if (j == N-1) {
                    System.out.println(array[i][j]);
                }
                /**
                 * 조건문 2개에서 1개로 수정도 가능.
                 * System.out.print(array[i][j]);
                 * if (j < N-1) {
                 *  System.out.print(" ")
                 * }
                 */
            }
        }
    }
}
