package study.inflearn.lecture01.section3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정답.
 * 15분.
 *
 * 10
 * 23 10 46 62 42 39 11 98 71 41
 * > 4
 * 첫번째 학생은 무조건 보이므로, 첫번째 기준으로 큰 아이들 카운팅
 *
 */
public class Ex03_02_보이는학생 {

    public int solution(int N, int[] array) {
        int count = 1;
        int temp = array[0]; // 첫번째 학생

        for (int i = 1; i < N; i++) {
            if (temp < array[i]) {
                count++;
                temp = array[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Ex03_02_보이는학생 T = new Ex03_02_보이는학생();
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(T.solution(N, array));
    }
}
