package study.inflearn.lecture01.section3;

import java.util.*;

public class Ex03_08_등수구하기_답 {

    public int[] solution(int n, int[] array) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (array[i] < array[j]) cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03_08_등수구하기_답 T = new Ex03_08_등수구하기_답();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int x : T.solution(n, array)) System.out.print(x + " ");
    }
}
