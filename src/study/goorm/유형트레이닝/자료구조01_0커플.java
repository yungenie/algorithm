package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 자료구조01_0커플 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(people); // 오름차순 정렬

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // 해당 값이 있으면 삭제하고, 없으면 넣어.
            int absValue = Math.abs(people[i]);
            if (hashMap.get(absValue) != null && hashMap.get(absValue) >= -200000) {
                hashMap.remove(absValue);
            } else {
                hashMap.put(absValue, people[i]);
            }
        }

        int sum = 0;
        for (Integer value : hashMap.values()) {
            sum+=value;
        }

        System.out.println(sum);
    }
}
/**
 * 입력값 int 배열로 받기.
 * 오름차순 정렬
 * HashMap 넣기
 * - 양수로 변환해서 넣기. 원래값은 value에 넣기.
 * - 양수로 변환해서 똑같은 값 있으면 지워.
 */