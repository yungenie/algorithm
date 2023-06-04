package study.inflearn.lecture02.section02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  서로 다른 빈도수 만들기 - 해싱 & 시간파싱
 *
 */
public class Ex02_03 {
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
        Ex02_03 T = new Ex02_03();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}

/*
 *배열과 리스트의 차이점
 * - 저장공간의 크기가 고정적 vs 동적 변환
 * - 배열은 최초로 지정된 크기를 변경할 수 없음. 크기를 무조건 지정해야함.
 * - 리스트는 크기를 지정하지 않아도 됨.
 *
 * ArrayList 삭제하면 size가 줄어드는 지?
 * - 맞다. 삭제하면 바로 데이터가 삭제되고 저장 공간 크기도 줄어든다.
 * - 위의 로직에서 for문 조건식은 ArrayList.size() 동적 사이즈 만큼 실행한다.
 *   예를 들어 첫번째 돌때 사이즈가 3이고, 실행구문에서 ArrayList가 삭제 되었다면
 *   데이터 삭제로 크기가 감소되기때문에 동적으로 사이즈 2로 변함
 *   만약 list.size()를 지역변수로 지정했을 경우는 고정 사이즈로 for문이 실행됩니다.
 *
 * 문제 파악할 때 하나하나 짚고 넘어가기 보다 전체 우선 다 읽고, 예시까지 보면서 파악하기!!
 */