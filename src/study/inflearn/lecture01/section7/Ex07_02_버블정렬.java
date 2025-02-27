package study.inflearn.lecture01.section7;

import java.util.Scanner;

public class Ex07_02_버블정렬 {

    /**
     * 버블 정렬
     * - 시간 복잡도 : O(N^2)
     * - 인접한 모든 요소를 비교하여 순서가 잘못된 경우 교환만 하면 되므로 매운 간단한 정렬 기술입니다.
     * - 원래 배열이 정렬되어 있어도 모든 쌍을 비교해야하기 때문에 시간복잡도가 O(N^2) 입니다.
     *
     * 버블 정렬 알고리즘 동작
     * - 인접한 두 요소를 비교하여 순서가 잘못되었을 경우 값을 교환합니다.
     * - 더 이상 교환이 필요 없을 때까지 목록을 반복합니다.
     * - 이름에서 알 수 있듯이, 가벼운 원소는 '거품처럼' 올라옵니다. (비교와 교환이 더 필요함)
     * - 무거운 원소는 이미 교환 후 배열의 마지막에 정해졌기 때문에 '가라앉은' 요소로 칭합니다.
     * - 그러므로 j는 0부터 n-i-1까지 역 피라미드 형태로 비교. 어차피 n-i-1 뒤의 값은 교환 후 정렬되었기 때문.
     */
    public int[] bubbleSort(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1 ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
        for (int x : T.bubbleSort(n, arr)) {
            System.out.println(x + " ");
        }
    }
}
