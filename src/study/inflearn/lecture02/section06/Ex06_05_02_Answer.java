package study.inflearn.lecture02.section06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * IP 주소 - 깊이우선탐색 : DFS (완전탐색)
 * 2회독 48분 고민했으나 못품
 */
public class Ex06_05_02_Answer {
    String s; // 주어진 문자열
    int n; // 문자열 길이
    Stack<String> temp; // ip 4자리 주소 담는 바구니
    ArrayList<String> result; // 유효한 ip 주소 모음함
    public void DFS(int start) {
        // 탈출조건
        /*
            ✨ start가 주어진 길이만큼 되었을 때의 조건을 넣는 이유
               start는 재귀의 트리 깊이(레벨)가 짧더라도
               재귀를 뻗을 때 깊이마다 가지치는 넓이마다 계속 1씩 증가하기 때문에
               뻗다보면 결국은 start는 주어진 수의 마지막까지 오게 된다.
               */
        if (temp.size() == 4 && start == s.length()) {  // 하나의 유효한 ip가 만들어진 경우
            String ip = "";
            for (String x : temp) ip += x + ".";
            result.add(ip.substring(0, ip.length()-1));
        } else {
            for (int i = start; i < n ; i++) {
                /*
                    0으로 시작하는 2자리 이상의 숫자를 거르기 위한 조건으로
                    ✨ i > start 조건을 추가해야한다.
                    - 255003 숫자가 주어졌을 때
                    - 012345 인덱스를 가진다.
                        - 25, 5, 0/03, 3
                            - 3번째 가닥 0/03을 보면
                            - 0 : start는 4이고, i도 4이다.
                            - 3까지 재귀함수을 돌고 백트레킹을 하면
                            - 다시 0으로 돌아와서 start 4가 되고 i는 5가 되어서
                            - ✨ start ~ i+1의 부분문자열은 아래와 같다.
                            - 03: start는 4이고, i는 5이다.
                            -> 그러므로 start < i가 더 큰 경우 0이 포함되는 2자리 이상 숫자가 되므로 재귀를 더 진행하지 않는다.

                 */
                if (s.charAt(start) == '0' && start < i) return;
                String str = s.substring(start, i + 1);
                if (Integer.parseInt(str) > 255) return;
                temp.add(str);
                DFS(i+1);
                temp.pop();

            }
        }
    }
    public String[] solution(String s){
        this.s = s;
        n = s.length();
        temp = new Stack();
        result = new ArrayList<>();

        // 완전 탐색
        DFS( 0);

        // 결과 반환
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
    public static void main(String[] args){
        /*
            1) IP 주소는 4개의 숫자가 . 로 구분되어 있습니다.
            2) IP 주소의 4개의 숫자는 0 ~ 255사이의 숫자로 구성됩니다.(0, 255포함)
            3) IP 주소의 4개의 숫자는 0으로 시작하는 2자리 이상의 숫자는 안됩니다.
         */
        Ex06_05_02_Answer T = new Ex06_05_02_Answer();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
