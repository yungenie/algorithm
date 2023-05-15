package study.inflearn;

import java.util.*;

/**
 * 회장 선거 - 해싱,시간파싱
 * 풀이 시간 초과
 */
public class Ex02_13 {
    public String solution(String[] votes, int k){
        String answer = " ";
        int n = votes.length;

        // 회장후보목록 : 후보에 따른 추천한 학생명단
        HashMap<String, List<String>> map = new HashMap<>(); // 학생1 : [추천해준 사람 목록], 학생2 : [추천해준 사람 목록], 학생3 : [추천해준 사람 목록]
        for (int i = 0; i < n; i++) {
            String[] tween = votes[i].split(" ");
            String giver = tween[0];
            String taker = tween[1];

            // 한 후보를 추천한 학생명단 목록
            List<String> list = new ArrayList<>();
            int size = map.getOrDefault(taker,list).size();
            list.add(giver);
            if (size >= 1) { // 후보를 추천해준 학생이 2명 이상일 때, 기존의 추천목록 + 추천학생
                for (int j = 0; j < size; j++) {
                    list.add(map.getOrDefault(taker,list).get(j));
                }
            }
            map.put(taker, list);
        }
        //System.out.println("회장후보=투표학생목록" + map);

        // 감사선물 받은 학생명단 - 가장 인기있는 후보들 중, 해당 후보들을 추천한 학생의 빈도수 해싱
        Map<String, Integer> thankList = new TreeMap<>(); // 사전순 빠른 학생 기준으로 정렬
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            if (size < k) continue;

            for (int i = 0; i < size; i++) {
                String thank = entry.getValue().get(i);
                thankList.put(thank, thankList.getOrDefault(thank, 0) + 1);
            }
        }
        //System.out.println("감사선물받은 학생 목록"+thankList);

        // 감사선물 최대치
        int max = 0;
        for (Integer value : thankList.values()) {
            if (max < value) {
                max = value;
            }
        }

        // 감사선물 많이 받은 학생 중 사전순 빠른 학생 뽑아내기
        for (Map.Entry<String, Integer> e : thankList.entrySet()) {
            if (e.getValue() == max) {
                answer = e.getKey();
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex02_13 T = new Ex02_13();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
