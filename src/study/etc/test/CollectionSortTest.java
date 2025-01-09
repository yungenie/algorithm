package study.etc.test;

import java.util.*;

public class CollectionSortTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(1);

        // List 타입이 래퍼타입으로 기본정렬 (오름차순)
        list.sort(null);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(Collections.min(list));

        // List 타입이 기본형 1차원 배열 타입으로 요소가 1개만 있는 경우 기본정렬 (오름차순)
        List<int[]> listIntArr1 = new ArrayList<>();
        listIntArr1.add(new int[]{18});
        listIntArr1.add(new int[]{10});
        listIntArr1.add(new int[]{1});
        listIntArr1.add(new int[]{7});

        System.out.println("오름차순 전");
        //listIntArr1.stream().forEach(value -> Arrays.stream(value).forEach(System.out::println)); // 모든 요소 출력
        listIntArr1.forEach(value -> System.out.println(Arrays.toString(value))); // int[] 타입의 배열 출력
//        listIntArr1.sort((a, b) -> a[0] - b[0]);
//        listIntArr1.sort((a,b) -> Integer.compare(a[0],b[0]));
        listIntArr1.sort(Comparator.comparingInt((int[] innerArr) -> innerArr[0])); // int[] 배열의 첫번째 요소만 비교
//        Collections.sort(listIntArr1, (a,b) -> Integer.compare(a[0],b[0]));

        System.out.println("오름차순 후");
        listIntArr1.forEach(value -> System.out.println(Arrays.toString(value)));


        // List 타입이 기본형 1차원 배열 타입으로 요소가 2개 있는 경우 기본정렬 (오름차순)
        List<int[]> listIntArr1_1 = new ArrayList<>();
        listIntArr1_1.add(new int[]{1, 3}); // a[0], a[1] ...
        listIntArr1_1.add(new int[]{1, 21}); // b[0], b[1] ...
        listIntArr1_1.add(new int[]{1, 5});
        listIntArr1_1.add(new int[]{18, 1});
        listIntArr1_1.add(new int[]{10, 4});
        listIntArr1_1.add(new int[]{1, 2});
        listIntArr1_1.add(new int[]{7, 9});

        System.out.println("오름차순 전");
        listIntArr1_1.forEach(value -> System.out.println(Arrays.toString(value)));
        // 첫번째 요소 기본정렬, 첫번째 요소가 같은 경우 두번째 요소 오름차순
        listIntArr1_1.sort(Comparator.comparingInt((int[] innerArr) -> innerArr[0])
                .thenComparingInt((int[] innerArr) -> innerArr[1]));

        System.out.println("오름차순 후");
        listIntArr1_1.forEach(value -> System.out.println(Arrays.toString(value)));

        System.out.println("내림차순 후");
        listIntArr1_1.sort(Comparator.comparingInt((int[] innerArr) -> innerArr[0]).reversed()
                .thenComparing(Comparator.comparingInt((int[] innerArr) -> innerArr[1]).reversed()));
        listIntArr1_1.forEach(value -> System.out.println(Arrays.toString(value)));

    }
}
