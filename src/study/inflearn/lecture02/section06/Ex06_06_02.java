package study.inflearn.lecture02.section06;

import java.util.Stack;

/**
 * 알파코드 - 깊이우선탐색 : DFS
 * 2회독 (소요시간 32분)
 * 06_05 풀이방법도 동일하게 해결함 (1회독때도 마찬가지)
 * 1회독 때 코드보다는 조금 더 클린 코드로 발전했다.
 */
public class Ex06_06_02 {

    String s;
    int n;
    Stack<String> stack;
    int answer;
    public void DFS(int start) {
        // 탈출조건
        if (start == n) {
            answer++;
        } else {
            for (int i = start; i < n; i++) {
                if (s.charAt(start) == '0') return; // 알파벳 암호화 0번은 없음
                String str = s.substring(start, i+1);
                if (Integer.parseInt(str) > 26) return;
                stack.push(str);
                DFS(i + 1);
                stack.pop();
            }
        }
    }

    public int solution(String s){
        this.s = s;
        n = s.length();
        answer = 0;
        stack = new Stack<>();
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        /*
            알파벳으로 복원하는 방법의 가지 수
            A~Z : 1~26
            아스키코드 65~90
            아스키코드로 처리해야되나 싶었으나,
            s의 부분집합 숫자의 경우의 수를 탐색하면서 숫자를 제한하면 됨
         */
        Ex06_06_02 T = new Ex06_06_02();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
