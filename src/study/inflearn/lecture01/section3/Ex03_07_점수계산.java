package study.inflearn.lecture01.section3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정답.
 * 13분 4초
 */
public class Ex03_07_점수계산 {

    public int solution(int n, int[] array) {
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            // 1번 문제 맞는 경우 1점
            if (i == 0 && array[i] == 1) scores[i] = 1;
            // 틀린 문제 0점
            else if (array[i] == 0) scores[i] = 0;
            else if (array[i] == 1) {
                if (array[i-1] == 1) {
                    scores[i] = scores[i-1] + 1;
                } else {
                    scores[i] = 1;
                }
            }
        }

        return Arrays.stream(scores).sum();
    }

    public static void main(String[] args) {
        Ex03_07_점수계산 T = new Ex03_07_점수계산();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(T.solution(n, array));
    }
}
