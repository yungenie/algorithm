package study.etc.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) throws Exception {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // 값 가져오기 테스트
        System.out.println(map.get("A"));
        System.out.println(map.getOrDefault("F", -1));

        // 값 확인 후 반환 테스트
        System.out.println(map.putIfAbsent("A", 7)); // 값이 존재하는 경우 원래값 반환
        System.out.println(map.putIfAbsent("D", 4)); // 값이 없으면 null 반환

        // 반복문 key, value 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


    }
}
