package study.inflearn.lecture01.section3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정답.
 * 9분 36초
 *
 */
public class Ex03_03_가위바위보 {

    /*
    1 가위
    2 바위
    3 보

    1 2 2승 3
    1 3 1승 4
    2 3 3승 5
    1 1
    2 2
    3 3
     */

    public void solution(int n, int[] aInfo, int[] bInfo){

        for (int i = 0; i < n; i++) {
            int sum = aInfo[i] + bInfo[i];
            // 비기는 경우
            if (aInfo[i] == bInfo[i]) {
                System.out.println("D");
            }
            // 가위 vs 바위, 바위 vs 보
            else if (sum == 3 || sum == 5) {
                if (aInfo[i] > bInfo[i]) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            }
            // 가위 vs 보
            else if (sum == 4) {
                if (aInfo[i] < bInfo[i]) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            }

        }
    }



    public static void main(String[] args) {
        Ex03_03_가위바위보 T = new Ex03_03_가위바위보();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] aInfo = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bInfo = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        T.solution(n, aInfo, bInfo);
    }
}
