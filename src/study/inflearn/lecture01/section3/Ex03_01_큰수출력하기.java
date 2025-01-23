package study.inflearn.lecture01.section3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정답
 * 24분
 */
public class Ex03_01_큰수출력하기 {

    public void solution(int N, int[] array) {
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                System.out.print(array[i]);
            } else {
                if (array[i-1] < array[i]) {
                    System.out.print(" " + array[i]);
                }
            }

        }
    }

    public static void main(String[] args) {
        Ex03_01_큰수출력하기 T = new Ex03_01_큰수출력하기();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        T.solution(N, array);
    }
}
