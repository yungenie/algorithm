package study.inflearn.lecture01.section5;

import java.util.HashMap;
import java.util.Scanner;


public class Ex05_04_모든아나그램찾기_답 {

    public int solution(String s, String t){
        int answer = 0;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        // 1개는 처리하지 말고 세팅
        for (int i = 0; i < t.length()-1; i++) sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);

        // 투포인터
        int lt = 0;
        for (int rt = t.length()-1; rt < s.length(); rt++) {
            // 슬라이딩 윈도우 요소 추가
            char rtKey = s.charAt(rt);
            sMap.put(rtKey, sMap.getOrDefault(rtKey, 0) + 1);
            if (sMap.equals(tMap)) answer++;

            // 슬라이딩 윈도우 요소 빼기
            char ltKey = s.charAt(lt);
            sMap.put(ltKey, sMap.get(ltKey) - 1);
            if (sMap.get(ltKey) == 0) sMap.remove(ltKey);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex05_04_모든아나그램찾기_답 T = new Ex05_04_모든아나그램찾기_답();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(T.solution(s, t));
    }
}
