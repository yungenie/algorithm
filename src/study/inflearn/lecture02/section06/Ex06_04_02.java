package study.inflearn.lecture02.section06;

import java.util.*;

/**
 * 팰린드롬의 경우수 - 깊이우선탐색 : DFS
 * 강사님 해법 듣고 재도전
 */
public class Ex06_04_02 {

    int n; // 주어진 입력 문자열 길이
    ArrayList<String> list;
    HashMap<Character, Integer> map; // 문자 빈도수 해싱
    Deque<Character> temp; // 팰린드롬
    public void DFS() {
        if (temp.size() == n) {
            String palindrome = "";
            for (Character s1 : temp) {palindrome += s1;}
            list.add(palindrome);
        } else {
            for (Character c : map.keySet()) {
                if (map.get(c) == 0) continue;
                temp.addFirst(c);
                temp.addLast(c);
                map.put(c, map.get(c) - 2);
                DFS();
                temp.pollFirst();
                temp.pollLast();
                map.put(c, map.get(c) + 2);
            }
        }
    }

    public String[] solution(String s){
        map = new HashMap<>();
        temp = new LinkedList<>();
        list = new ArrayList<>();
        n = s.length();

        // 문자 빈도수 해싱
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 문자 빈도수 홀수 2개 이상 제외
        int count = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                count++;
            }
        }
        if (count > 1) return new String[]{};

        // 빈도수가 홀수인 문자 1개인 경우 - 중간에 넣기
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                temp.push(key);
                map.put(key, map.get(key) - 1);
            }
        }

        DFS();

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Ex06_04_02 T = new Ex06_04_02();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
