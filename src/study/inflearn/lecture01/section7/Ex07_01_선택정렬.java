package study.inflearn.lecture01.section7;

import java.util.Scanner;

public class Ex07_01_선택정렬 {

    /**
     * 선택 정렬
     * - 시간 복잡도 : O(N^2)
     * - 작은 데이터 집합에는 효율적이지만 큰 데이터 집합에는 효율적이지 않습니다. (제자리 정렬 알고리즘)
     *
     * 선택 정렬 알고리즘 동작
     * - 입력 요소들을 두 부분으로 나눕니다.
     * - 선택된 메인 값 1개(첫번째 부분)와 나머지 여러 후보 값 중(두번째 부분)에 제일 작은 값을 골라 비교하여 교환합니다.
     * - 첫번째 부분 i가 0부터 n-1까지 인덱스를 1씩 증가하며 메인 값으로 선택합니다.
     * - 두번째 부분 j는 i+1부터 n까지 후보군 중에 제일 작은 값의 인덱스를 구합니다.
     * - 첫번째와 두번째 부분을 교환하며 반복합니다.
     */
    public int[] selectSort(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            int minIndex = getMinIndex(n, i, arr);
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    int getMinIndex(int n, int startIndex, int[] arr) {
        int minIndex = startIndex;
        for (int j = startIndex + 1; j < n; j++) {
            if (arr[minIndex] > arr[j]) {
                minIndex = j;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Ex07_01_선택정렬 T = new Ex07_01_선택정렬();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.selectSort(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
