package study.inflearn.lecture01.section3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03_07_점수계산_답 {

    public int solution(int n, int[] array) {
        int answer = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                cnt++;
                answer+=cnt;
            } else cnt = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03_07_점수계산_답 T = new Ex03_07_점수계산_답();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(T.solution(n, array));
    }
}
