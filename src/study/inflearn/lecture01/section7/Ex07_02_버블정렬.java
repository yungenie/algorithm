package study.inflearn.lecture01.section7;

import java.util.Scanner;

public class Ex07_02_버블정렬 {

    /**
     * 이웃한 두 값을 비교
     * i,j 둘다 0부터 n-i-1까지 역 피라미드 형태로 비교. 어차피 n-i-1 뒤의 값은 정렬 되어 있기 때문.
     */
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Ex07_02_버블정렬 T = new Ex07_02_버블정렬();
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
