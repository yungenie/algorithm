package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기초15_M배배열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 방법1
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < N; i++) {
            if (array[i] % M != 0) {
                array[i] = array[i] * M;
            }
        }

        Arrays.stream(array).forEach(System.out::print);

        // 방법2
/*        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(a -> a % M !=0 ? a * 3 : a) // map 요소를 변환할때 사용. 조건에 다라 값을 수정할때 사용. filter는 조건에 따라 요소를 포함하거나 제거
                .toArray();

        Arrays.stream(array).forEach(System.out::print);*/

    }
}

/**
 * Stream map() vs filter() 차이!
 *
 * Stream API 활용하여 요소를 조작하려면 map 연산을 사용하면 됨.
 * 조건에 따라 변환할 수 있다.
 *
 * filter는 요소를 걸러내는 작업을 사용되며, 요소를 변환할 수 없음.
 * 조건에 맞는 요소를 남기거나 제외할때 사용한다.
 *
 */