package study.etc.study.sort_algorithm;

import java.util.Arrays;

/**
 * 버블정렬 - 오름차순
 *  - 개념 :
 *  - 이웃한 두 요소를 비교하여 오름차순일 경우 앞에가 크고 뒤에가 작으면 교환하는 알고리즘입니다.
 *  - 회전이 끝날 때마다 배열의 마지막 위치 거꾸로 부터 원소가 정해지므로 n-1-i까지 돕니다. 그러므로 점점 비교횟수가 줄어든다.
 *  - 시간복잡도 n(n-1)/2이므로 O(n^2), 정렬이 돼있던 안돼있던 2개의 원소를 비교하기 때문에 최선, 평균, 최악의 경우 모두 시간복잡도가 O(n^2) 으로 동일하다
 *  - 주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 O(n) 입니다.
 *  - 장점 :
 *  - 배열 안에서 교환하며 정렬하는 방식이므로, 다른 메모리 공간을 필요로 하지 않다. => 제자리 정렬(in-place sorting)
 *  - 단점 :
 *  - 시간복잡도가 최악, 최선, 평균 모두 O(n^2)으로, 굉장히 비효율적이다.
 *  - 정렬 돼있지 않은 원소가 정렬 됐을때의 자리로 가기 위해서, 교환 연산(swap)이 많이 일어나게 된다.
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
