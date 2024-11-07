package study.etc.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySortTest {
    public static void main(String[] args) {
        // 1차원 배열 정렬 (기본타입)
        int[] intArr = new int[3]; // int[] arrTest = {10, 1, 7}
        intArr[0] = 10;
        intArr[1] = 1;
        intArr[2] = 7;

        // 오름차순
        /*
         정렬 성능을 높이기 위한 다양한 정렬 알고리즘이 존재한다.
         자바는 초기에는 퀵소트를 사용했다가 지금은 데이터가 작을 때(32개 이하)는 듀얼 피벗 퀵소트(Dual-Pivot QuickSort)를 사용하고,
         데이터가 많을 때는 팀소트(TimSort)를 사용한다. 이런 알고리즘은 평균 O(n log n)의 성능 을 제공한다.
         */
        Arrays.sort(intArr); // 기본 타입 배열(int[], double[], char[])과 참조 타입 배열 대해 기본적인 오름차순 정렬 알고리즘 제공


        // 1차원 배열 정렬 (기본타입) 내림차순 - 방법1
        intArr = Arrays.stream(intArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        // 1차원 배열 정렬 (기본타입) 내림차순 - 방법2
        Integer[] integerArr = Arrays.stream(intArr)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(integerArr, Collections.reverseOrder());


        // 1차원 배열 정렬 (참조 및 Wrapper 래퍼 타입) Wrapper : 기본 타입을 객체로 감싼 것.
        Integer[] aaa = {9, 2, 6};
        Arrays.sort(aaa);
        System.out.println(Arrays.toString(aaa));


        // 2차원 배열 정렬
        /**
         * Integer.compare() 사용하는 이유
         * a[0] - b[0] 뺄셈의 결과로 타입의 범위가 초과될때 오버플로우 될 수 있어
         * 뺄셈이 아닌 비교연산을 사용하는 compare() 이나 comparingInt() 메서드를 사용하면 안전하다.
         * Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
         */
        int[][] events = new int[2][2];
        // 시작시간 오름차순
//        Arrays.sort(events); // error
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(events, (a, b) -> Integer.compare(a[0],b[0]));
        // 시작시간 내림차순
        //Arrays.sort(events, (a, b) -> b[0] - a[0]);
        //Arrays.sort(events, (a, b) -> Integer.compare(b[0],a[0]));

        // 끝나는 시간 오름 차순
        // int[][] line = new int[n+1][2];
        // Arrays.sort(line, Comparator.comparingInt(a -> a[0])); //(a, b) -> a[0] - b[0]



        String[] strArr = {"b", "f", "a"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));




    }
}
