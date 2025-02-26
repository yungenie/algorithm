package study.inflearn.lecture01.section7;

import java.util.Scanner;

public class Ex07_01_선택정렬 {

    public int[] solution(int n, int[] arr) {

        /**
         * i는 0부터 n-1까지 메인 값을 선택하고
         * j는 i+1부터 n까지 비교 후보 값 중 제일 작은 값의 인덱스를 구해
         * 배열을 교환한다.
         */
        for (int i = 0; i < n-1; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[idx] > arr[j]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Ex07_01_선택정렬 T = new Ex07_01_선택정렬();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
}
