package study.inflearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex02_10 {
    public int[] solution(String s){
        int[] answer = new int[5];

        // a,b,c,d,e 빈도수 초기화
        String str = "abcde";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0));
        }

        // 입력 데이터 s 기준으로 빈도수 셋팅
        for (char sc : s.toCharArray()) {
            map.put(sc, map.getOrDefault(sc, 0) + 1);
        }

        // a,b,c,d,e 최대 빈도수 찾기
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        // a,b,c,d,e 추가한 빈도수 구하기 (최대 빈도수 기준)
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            answer[count] = max - entry.getValue();
            count++;
        }

        return answer;
    }

    public static void main(String[] args){
        Ex02_10 T = new Ex02_10();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
