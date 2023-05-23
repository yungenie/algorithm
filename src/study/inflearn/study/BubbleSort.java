package study.inflearn.study;

import java.util.Arrays;

/**
 * 버블정렬 - 오름차순
 *  - 이웃한 두 요소를 비교하여 오름차순일 경우 앞에가 크고 뒤에가 작으면 교환하는 알고리즘입니다.
 *  - 회전이 끝날 때마다 배열의 마지막 위치 거꾸로 부터 원소가 정해지므로 n-1-i까지 돕니다.
 *  - 그러므로 점점 비교횟수가 줄어든다.
 */
public class BubbleSort {
    public int[] bubbleSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        BubbleSort T = new BubbleSort();
        System.out.println("결과 = " + Arrays.toString(T.bubbleSort(new int[]{13, 5, 11, 7, 23, 15})));
    }

}
