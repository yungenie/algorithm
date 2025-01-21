package study.inflearn.lecture01.section2;


import java.util.Scanner;

/**
 * 1. KKHSSSSSSSE 주어진 입력 문자열 빈 문자열 " " 추가
 * 2. i와 i+1 문자 비교
 * 3. 같으면 cnt 증가, 다르면 문자 출력 + 문자개수
 * 4. cnt = 1로 초기화
 */
public class Ex02_11_문자열압축_답 {

    public String solution(String text) {
        String answer = "";
        text = text + " ";
        int cnt = 1;
        for (int i = 0; i < text.length()-1; i++) {
            if (text.charAt(i) == text.charAt(i+1)) cnt++;
            else {
                answer += text.charAt(i);
                if (cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        Ex02_11_문자열압축_답 T = new Ex02_11_문자열압축_답();
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println(T.solution(text));
    }
}
