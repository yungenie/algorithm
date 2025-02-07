package study.inflearn.lecture01.section5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 정답
 * 9분 25초
 */
public class Ex05_02_아나그램 {

    public String solution(String text1, String text2) {
        String answer = "YES";

        //text1 각 단어 숫자 구하기.
        Map<Character, Integer> text1Map = new HashMap<>();
        for (char x1 :  text1.toCharArray()) {
            text1Map.put(x1, text1Map.getOrDefault(x1, 0) + 1);
        }

        //text2 각 단어 숫자 구하기.
        Map<Character, Integer> text2Map = new HashMap<>();
        for (char x2 :  text2.toCharArray()) {
            text2Map.put(x2, text2Map.getOrDefault(x2, 0) + 1);
        }

        //text1, text2 비교
        for (Map.Entry<Character, Integer> entry1 : text1Map.entrySet()) {
            if (text2Map.containsKey(entry1.getKey())) {
                if (entry1.getValue() != text2Map.get(entry1.getKey())) {
                    answer = "NO";
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Ex05_02_아나그램 T = new Ex05_02_아나그램();
        Scanner sc = new Scanner(System.in);
        String text1 = sc.next();
        String text2 = sc.next();
        System.out.println(T.solution(text1,text2));
    }
}
