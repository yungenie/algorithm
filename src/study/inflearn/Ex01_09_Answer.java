package study.inflearn;

import java.util.HashMap;

/**
 *  한 번만 사용한 최초 문자 - 해싱 & 시간파싱 (HashMap 메서드 활용)
 *
 */
public class Ex01_09_Answer {
    public int solution(String s){
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            // getOrDefault(key, defaultValue) : HashMap의 찾는 key의 value 가져오기. key 없으면 defaultValue 반환.
            sH.put(x, sH.getOrDefault(x, 0) + 1); // 각 문자 비도수 해싱
        }
        for(int i = 0; i < s.length(); i++){
            if(sH.get(s.charAt(i)) == 1) return i+1;
        }
        return -1;
    }

    public static void main(String[] args){
        Ex01_09_Answer T = new Ex01_09_Answer();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
