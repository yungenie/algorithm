package study.etc.study.sort_algorithm;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 15, 6};

        insertionSort(arr);

        System.out.println("정렬된 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int startValue = array[i];
            int compIndex= i - 1;

            // 현재 key 값보다 큰 값들을 오른쪽으로 이동
            while (compIndex >= 0 && array[compIndex] > startValue) {
                array[compIndex + 1] = array[compIndex];
                compIndex--;
            }
            // key 값을 정렬된 위치에 삽입
            array[compIndex + 1] = startValue;
        }
    }
}
