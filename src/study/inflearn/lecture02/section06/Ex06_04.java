package study.inflearn.lecture02.section06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 팰린드롬의 경우수 - 깊이우선탐색 : DFS
 * 틀림 : 문자열 전체 팰린드롬의 수 나옴
 */
public class Ex06_04 {

    String[] answer;

    String[] str;
    ArrayList<String> palindrome;
    int[] ch;
    int n;
    Stack<String> stack;
    public void DFS(int L){
        if (L == n) {

            String ss = "";
            for (String s : stack) {
                ss+=s;
            }

            StringBuilder sb = new StringBuilder(ss);
            String reverseStr = sb.reverse().toString();
            if (ss.equals(reverseStr)) palindrome.add(ss);

        } else {
            for (int i = 0; i < n; i++) {

                if (ch[i] == 0) {
                    ch[i] = 1;
                    stack.push(str[i]);
                    DFS(i+1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public String[] solution(String s){
        answer = new String[]{};
        palindrome = new ArrayList<>();
        stack = new Stack<>();
        n = s.length();
        ch = new int[n];

        str = new String[n];
        for (int a = 0; a < n; a++) {
            str[a] = String.valueOf(s.charAt(a));
        }


        DFS(0);
        System.out.println("palindrome = " + palindrome);

        return answer;
    }

    public static void main(String[] args){
        Ex06_04 T = new Ex06_04();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
