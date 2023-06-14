package study.inflearn.lecture02.section06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * IP 주소 - 깊이우선탐색 : DFS
 * 완전탐색
 */
public class Ex06_05_Answer {
    LinkedList<String> tmp;
    ArrayList<String> res;
    public void DFS(int start, String s){
        if(tmp.size() == 4 && start == s.length()){
            String Ts = "";
            for(String x : tmp) Ts += x + ".";
            res.add(Ts.substring(0, Ts.length()-1));
        }
        else{
            for(int i = start; i < s.length(); i++){
                if(s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                if(Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s){
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        Ex06_05_Answer T = new Ex06_05_Answer();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
