package study.inflearn.lecture01.section5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 정답
 * 9분 25초
 */
public class Ex05_02_아나그램_답 {

    public String solution(String s1, String s2) {
        String answer = "YES";

        //s1 각 단어 숫자 구하기.
        Map<Character, Integer> map = new HashMap<>();
        for (char x :  s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 아나그램 비교
        /*
         s1 : ccCCAA
         s2 : AcACcCA
         s1의 알파벳별 개수는 c(2), C(2), A(2)
         s2에서 확인할때 같은 문자는 -1 처리로 똑같은 개수가 있다면 0으로 됨. 근데 그 다음 배열 요소에 나오면 개수가 하나 더 있으므로 아나그램 아님.
        */
        for (char x2 :  s2.toCharArray()) {
            if (!map.containsKey(x2) || map.get(x2) == 0) return "NO";
            map.put(x2, map.get(x2) - 1);
        }

        return answer;
    }
    public static void main(String[] args) {
        Ex05_02_아나그램_답 T = new Ex05_02_아나그램_답();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(T.solution(s1,s2));
    }
}
