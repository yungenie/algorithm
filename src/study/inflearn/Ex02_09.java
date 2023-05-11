package study.inflearn;

/**
 *  한 번만 사용한 최초 문자 - 해싱 & 시간파싱
 */

public class Ex02_09 {
    public String getString(char c) {
        return String.valueOf(c);
    }
    public int solution(String s){
        int answer = 0;

        int count = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (getString(s.charAt(i)).equals(getString(s.charAt(j)))) {
                    count++;
                }
            }

            if (count >= 2) {
                count = 0;
                total++; // 내 자신과 비교대상 포함해서 2개 이상일 때
            } else {
                answer = i+1;
                break;
            }
        }

        // 모두 한번 이상 사용했을 때 (한번만 사용한 문자가 없는 경우)
        if (total == s.length()) answer = -1;

        return answer;
    }

    public static void main(String[] args){
        Ex02_09 T = new Ex02_09();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("aaabbb"));
        System.out.println(T.solution("aaaabbbb"));
        System.out.println(T.solution("aaaaabbbbb"));
        System.out.println(T.solution("aaaaabbb"));
        System.out.println(T.solution("ababab"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }

}
