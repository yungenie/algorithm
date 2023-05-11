package study.inflearn;

import java.util.Arrays;
import java.util.HashMap;

public class Ex02_10_Answer {
    public int[] solution(String s){
        int[] answer = new int[5];

        // 입력 데이터 빈도수 해싱
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0)+1);
        }

        // 빈도수 최대값 구하기
        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()){
            if(sH.getOrDefault(key, 0) > max){
                max = sH.getOrDefault(key, 0);
            }
        }

        // 추가된 값 구하기
        for(int i = 0; i < tmp.length(); i++){
            answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex02_10_Answer T = new Ex02_10_Answer();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
