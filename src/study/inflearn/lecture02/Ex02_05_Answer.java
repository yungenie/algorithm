package study.inflearn.lecture02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 회장 선거 - 해싱,시간파싱
 *
 * HashMap.putIfAbsent(Object key, Object value)
 * - Key 값이 존재하는 경우 Value의 값을 반환하고, Key값이 존재하지 않는 경우 Key와 Value를 저장하고 Null을 반환합니다.
 *
 */
public class Ex02_05_Answer {

    public String solution(String[] votes, int k){
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();
        // 추천정보 탐색
        for(String x : votes){
            String a = x.split(" ")[0]; //추천한 학생
            String b = x.split(" ")[1]; //추천받은 학생
            //putIfAbsent() : voteHash에 존재하지 않을 때 동작 (빈자료구조 생성해서 넣기)
            voteHash.putIfAbsent(a, new HashSet<String>());
            // 추천한 학생이 추천받은 학생 누적 저장
            voteHash.get(a).add(b);
            // 회장후보추천 목록 (추천받은 횟수 해싱)
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }
        int max=Integer.MIN_VALUE;
        for(String a : voteHash.keySet()){
            int cnt = 0;
            for(String b : voteHash.get(a)){
                if(candidate.get(b) >= k) cnt++; // 회장후보에게 감사선물 받는 수
            }
            present.put(a, cnt);
            max = Math.max(max, cnt); //선물을 가장 많이 받는 수
        }
        //선물을 가장 많이 받는 학생
        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()){
            if(present.get(name) == max) tmp.add(name); // 최대선물받은 학생 담기
        }
        tmp.sort((a, b) -> a.compareTo(b)); // 사전순으로 빠른 이름
        answer = tmp.get(0); // 제일 앞에 있는 학생
        return answer;
    }

    public static void main(String[] args){
        Ex02_05_Answer T = new Ex02_05_Answer();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}

