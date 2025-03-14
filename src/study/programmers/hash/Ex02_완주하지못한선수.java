package study.programmers.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 정답. 13분 소요
 */
public class Ex02_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 참가자 HashMap
        // 완료자 for문 돌면서 key 삭제
        Map<String, Integer> map = new HashMap<>();
        for(String pName : participant) {
            map.put(pName, map.getOrDefault(pName, 0) + 1);
        }

        for(String cName : completion) {
            map.computeIfPresent(cName, (k, v) -> v - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
