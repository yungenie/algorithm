package study.inflearn;

import java.util.HashMap;
import java.util.HashSet;

/**
 *  서로 다른 빈도수 만들기 - 해싱 & 시간파싱
 *
 */
public class Ex02_11_Answer {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> sH = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();
        for (char x : s.toCharArray()) {
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }

        /* 입력 문자열에 해당하는 빈도수가 담긴 HashMap을 탐색하면서
         * 문자리터럴 key에 해당하는 valeu(빈도수)가 유니크 빈도수함(HashSet)에
         * 없으면 value 추가, 있으면 빈도수함에서 같은 값이 없을 때까지 value -1(감소)하고 감소한 갯수 세기
         */
        for (char key : sH.keySet()) {
            System.out.println("key = " + key);
            while (ch.contains(sH.get(key))) {
                System.out.println("answer = " + answer);
                answer++; // 삭제 횟수 (문자를 하나하나 지운 횟수, 삭제할 때마다 증감)
                sH.put(key, sH.get(key) - 1); // 빈도수 감소
                System.out.println("sH = " + sH);
            }
            if (sH.get(key) == 0) continue; // 빈도수 0이면 삭제되고 없는 문자로 생각
            /*
             * ch 유니크한 빈도수를 저장할 때
             * - 처음엔 빈도수가 없으니깐 넣기
             * - ch에 값이 있다는 것은 해당 빈도수에 해당하는 문자가 있다는 뜻
             * - ch 순회하면서 문자열에 해당되는 빈도수가 없으면 넣기
             */
            ch.add(sH.get(key)); // 유니크한 빈도수 모음
            System.out.println("ch = " + ch);
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex02_11_Answer T = new Ex02_11_Answer();
        //System.out.println(T.solution("aaabbbcc"));
        //System.out.println(T.solution("aaabbc"));
        //System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        //System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}

/* while문
 * - 조건식이 거짓이 될때까지 수행
 * 코드는 루틴으로 짜는 것!
 */