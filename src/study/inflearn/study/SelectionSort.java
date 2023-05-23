package study.inflearn.study;

import java.util.Arrays;

/**
 * 선택정렬 - 오름차순
 * - 해당 자리를 선택하고 그 자리에 오는 값을 찾는 알고리즘 입니다.
 * - 해당 자리를 선택하고 그 자리에 올 다른 값을 loop돌며 찾아 교환이 이루어지는 정렬 알고리즘입니다.
 * - 장점 :
 *   정렬을 위한 비교 횟수는 많지만, Bubble Sort에 비해 실제로 교환하는 횟수는 적어, 많은 교환이 일어나야 하는 자료상태에서 비교적 효율적입니다.
 *   주어진 배열 안에서 교환(swap)을 통해 정렬이 수행되므로 공간복잡도 O(n) 입니다.
 *   다른 메모리 공간을 필요로 하지 않으므로 제자리 정렬 in-place sorting 이라고 합니다.
 * - 단점 :
 *   시간복잡도 n(n-1)/2 O(n^2)으로, 비효울적이므로 불안정 정렬 (Unstable Sort)에 속합니다.
 */
public class SelectionSort {

    public int[] selectionSort(int[] arr){
        System.out.println("원본 = " + Arrays.toString(arr));
        int n = arr.length;

        int indexMin, temp;
        for (int i = 0; i < n - 1; i++) { //위치(index)를 선택합니다.
            indexMin = i;
            for (int j = i + 1; j < n; j++) { //i+1번째 원소부터 선택한 위치(index)의 값과 비교를 합니다.
                if (arr[j] < arr[indexMin]) { //오름차순이므로 현재 선택한 자리에 있는 값보다 순회하고 있는 값이 작다면, 위치(index)를 갱신합니다.
                    indexMin = j;
                }
            }
            // swap(arr[indexMin], arr[i]) 선택한 위치(index)에 들어가야하는 값의 위치를 갖고 있으므로 서로 교환(swap)해줍니다.
            temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        SelectionSort T = new SelectionSort();
        System.out.println("결과 = " + Arrays.toString(T.selectionSort(new int[]{13, 5, 11, 7, 23, 15})));
    }

}
