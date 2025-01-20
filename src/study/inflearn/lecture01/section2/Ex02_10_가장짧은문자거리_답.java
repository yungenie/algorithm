package study.inflearn.lecture01.section2;

import java.util.Scanner;

/**
 * p라는 변수를 두고 문자t와 같을 때 p를 0으로 초기화해두고 나머지는 p를 1씩 증가한다.
 * 인덱스 0에서부터 끝까지, 반대로 인덱스 s의 길이 끝부터 0까지 n^2 시간 소요
 */
public class Ex02_10_가장짧은문자거리_답 {

    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 1000, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(p, answer[i]);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Ex02_10_가장짧은문자거리_답 T = new Ex02_10_가장짧은문자거리_답();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        for (int x : T.solution(s, t)) {
            System.out.print(x + " ");
        }
    }
}
