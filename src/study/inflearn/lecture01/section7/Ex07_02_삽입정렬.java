package study.inflearn.lecture01.section7;

import java.util.Scanner;

public class Ex07_02_삽입정렬 {

    /**
     * 삽입 정렬
     * - 시간 복잡도 : O(N^2)
     * - 작은 데이터 집합에는 효율적이지만 큰 데이터 집합에는 효율적이지 않습니다.
     *
     * 삽입 정렬 알고리즘 동작
     * - 정렬된 부분(교환에 가까움)에서 기준이 되는 요소를 적절한 위치에 삽입하면서 정렬하는 방식입니다.
     */
    public int[] insertSort(int n, int[] arr) {
        for (int i = 1; i < n ; i++) {
            int temp = arr[i];
            for (int j = i - 1; j >= 0 ; j--) {
                if (arr[j] > temp) arr[j+1] = arr[j];
                else break;
            }
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
        Ex07_02_삽입정렬 T = new Ex07_02_삽입정렬();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.insertSort(n, arr)) {
            System.out.println(x + " ");
        }
    }

    
}
