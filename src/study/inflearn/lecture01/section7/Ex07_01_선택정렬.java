package study.inflearn.lecture01.section7;

import java.util.Scanner;

public class Ex07_01_선택정렬 {

    public int[] solution(int n, int[] arr) {

        /**
         * 이중 for문으로
         * i부터 j=i+1~ n까지 비교하면서
         * idx = i 세팅하고
         * arr[idx]보다 작은 arr[j] 값 구해서 idx 초기화
         * arr[idx]랑 arr[i] 교환
         */
        for (int i = 0; i < n-1; i++) {
            int idx = i; // 작은 값 담기
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
