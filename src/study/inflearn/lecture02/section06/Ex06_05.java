package study.inflearn.lecture02.section06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * IP 주소 - 깊이우선탐색 : DFS
 * 완전탐색
 * 강사님 해법 및 해설 영상 보면서 리팩토리
 */
public class Ex06_05 {
    Stack<String> stack; // 마지막에 넣은 값을 빼면 되므로 스택 사용.
    ArrayList<String> ipList;
    public void DFS(int start, String str) {
        String temp = "";
        for (String s : stack) {temp+=s;}

        if (stack.size() == 4 && temp.length() == str.length()){ // 스택의 모든 문자열이 주어진 입력 문자열의 길이와 동일한 경우
        //if (stack.size() == 4 && start == str.length()){ // 하나의 유효한 ip 만들어졌을 경우 (모든 문자열을 다 사용해서 4개의 숫자를 만들었다는 의미)
            String strSum = "";
            for (int i = 0; i < stack.size(); i++) {
                if (i == stack.size() - 1) strSum += stack.get(i);
                else strSum += stack.get(i) + ".";
            }
            ipList.add(strSum);
        }
        else {
            for (int i = start; i < str.length(); i++) {
                if (str.charAt(start) == '0' && i > start) return; // 0으로 시작하면서 두자리 수 이상을 뜻함. i가 클때의 조건은 현재 레벨에서 다음 연속으로 만든 숫자가 있다는 뜻
                String num = str.substring(start, i + 1); // 현재 레벨에서 경우의 수 i까지 문자열을 더해야하는데 부분문자열 sub(s,e) s이상 e미만이므로 e에 i+1을 하는 것.
                if (Integer.parseInt(num) > 255) return; // 해당 재귀 함수 종료. 전체 재귀 함수 종료가 아님.
                stack.push(num);
                DFS(i + 1, str);
                stack.pop();
            }
        }
    }
    public String[] solution(String s){
        stack = new Stack<>();
        ipList = new ArrayList<>();

        DFS(0, s);

        int n = ipList.size();
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = ipList.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex06_05 T = new Ex06_05();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
