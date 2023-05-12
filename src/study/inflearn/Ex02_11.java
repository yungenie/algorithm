package study.inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  서로 다른 빈도수 만들기 - 해싱 & 시간파싱
 *
 */
public class Ex02_11 {
    public int solution(String s){
        int answer = 0;

        // 입력 데이터의 문자열 빈도수
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 배열리스트에 문자열 빈도수 map 담기
        List<Map.Entry> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        // 지워야할 최소 개수 구하기
        int x = 0,y = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                x = (int)list.get(i).getValue();
                y = (int)list.get(j).getValue();

                if (x == 0 || y == 0) continue; //대상, 비교대상 값이 0이면 제외
                if (x == y ) {
                    list.get(j).setValue(y - 1); //빈도수가 같으면 비교대상 값 1 차감
                    answer++; //지워야할 개수 세기
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex02_11 T = new Ex02_11();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
