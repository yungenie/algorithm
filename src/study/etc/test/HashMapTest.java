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
        System.out.println("========값 가져오기========");
        System.out.println(map.get("A"));
        System.out.println(map.get("FF"));
        System.out.println(map.getOrDefault("F", -1));

        // 값 확인 후 반환 테스트
        System.out.println("========값 저장하기========");
        System.out.println(map.putIfAbsent("A", 7)); // key 존재하는 경우 기존 value 반환
        System.out.println(map.putIfAbsent("D", 4)); // key 존재하지 않는 경우 지정한 value 저장하고 null 반환
        System.out.println(map.computeIfAbsent("C", v -> 7)); // key 존재하는 경우 mappingFunction 무시하고 기존 value 반환
        System.out.println(map.computeIfAbsent("E", v -> 7)); // key 존재하지 않는 경우 mappingFunction 진행 후 변경 value 반환
        System.out.println(map.computeIfPresent("A", (key, value) -> value + 100)); // key 존재하는 경우 remappingFunction 진행 후 변경 value 반환
        System.out.println(map.computeIfPresent("G", (key, value) -> value + 100)); // key 존재하지 않는 경우 null 반환
        System.out.println(map.compute("B", (key, value) -> value + 9)); // key 존재하는 경우만 remappingFunction 진행, key 없으면 예외 발생
        System.out.println(map);

        // 반복문 key, value 출력
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        HashMap<Integer, HashMap<Integer, Integer>> mapMap = new HashMap<>();
        HashMap<Integer, Integer> innerMap = mapMap.computeIfAbsent(1, value -> new HashMap<>());
        innerMap.put(2, innerMap.getOrDefault(2, 0) + 1);
        System.out.println(mapMap);

    }
}
