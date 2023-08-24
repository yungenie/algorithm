package study.inflearn.lecture02.section06;

import java.util.*;

/**
 * 팰린드롬의 경우수 - 깊이우선탐색 : DFS
 * 2회독 (소요시간:48분)
 */
public class Ex06_04_03 {

    ArrayList<String> result; // 팰린드롬 경우의 수들 담는 자료구조
    HashMap<Character, Integer> map; // 주어진 문자의 빈도수 해싱
    Deque<Character> deque; // 팰린드롬 만드는 자료구조
    int n;
    public void DFS() {
        // 탈출조건 : 주어진 문자열 크기의 팰린드롬 완성했을 경우, ArrayList에 담기
        if (deque.size() == n){
            StringBuilder sb = new StringBuilder();
            for (Character ch : deque) sb.append(ch);
            result.add(String.valueOf(sb));
        } else {
            for (Map.Entry<Character, Integer> ele : map.entrySet()) {
                int getValue = ele.getValue();
                char getKey = ele.getKey();
                // 각 문자열의 개수가 0 인 것은 제외
                if (getValue > 0) {
                    //앞뒤로 넣고 개수 차감
                    deque.addFirst(getKey);
                    deque.addLast(getKey);
                    map.put(getKey, getValue - 2);
                    DFS();
                    // 앞뒤로 빼고 개수 증가
                    //map.put(deque.peek(), map.getOrDefault(deque.peek(),0) + 2);
                    deque.pollFirst();
                    deque.pollLast();
                    map.put(getKey, map.get(getKey) + 2);
                }
            }
        }
    }
    public String[] solution(String s){
        /*
            주어진 문자열로 팰린드롬
            - 주어진 문자열의 요소들을 배열에 담기?
            - 팰린드롬은 어떻게 만들 것인가?
            - 문자열 요소 해싱 a : 1 b :2 c :2
            - deque 자료구조에 담기
            - 홀수인 key가 1개 일 때
                - value가 1개면 중간에 넣어야함.
                - value가 3개 이상이면 1개 무조건 중간에 넣어서 홀수로 되게끔 한다.
            - 홀수인 key가 1개 이상일 때 만들어질 수 없다. [] 빈 배열 반환
                - abbcceee
         */
        n = s.length();
        result = new ArrayList<>();

        // 주어진 문자의 빈도수 해싱 ex) abbcceee ->  a:1, e:3, b:2, c:2
        map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        // 주어진 문자의 빈도수가 홀수 개수인 key 2개 이상인 경우 빈배열 반환
        int cnt = 0;
        for (Integer value : map.values()) {
            if (value%2 == 1) cnt++;
        }
        if (cnt >= 2) return new String[]{};

        // 홀수 개수인 key 1개인 경우 팰린드롬 가운데에 넣기.
        deque = new LinkedList<>();
        if (cnt == 1) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue()%2 == 1) {
                    deque.push(entry.getKey()); // 가운데 넣기
                    map.put(entry.getKey(), entry.getValue() - 1); // 넣은 개수 차감
                }
            }
        }

        DFS();

        // 팰린드롬 출력
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Ex06_04_03 T = new Ex06_04_03();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
