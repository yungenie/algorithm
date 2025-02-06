package study.inflearn.lecture01.section5;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex05_01_학급회장_답 {

    public char solution(int n, String str) {
        char answer = ' '; // char 빈문자 초기화

        Map<Character, Integer> voteMap = new HashMap<>();
        for (char x : str.toCharArray()) {
            voteMap.put(x, voteMap.getOrDefault(x, 0) +1);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry: voteMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                answer = entry.getKey();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex05_01_학급회장_답 T = new Ex05_01_학급회장_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
