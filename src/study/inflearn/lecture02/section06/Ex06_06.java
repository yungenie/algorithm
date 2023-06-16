package study.inflearn.lecture02.section06;

import java.util.LinkedList;

/**
 * 알파코드 - 깊이우선탐색 : DFS
 * 소요시간 30분 (재귀)
 */
public class Ex06_06 {
    int answer;
    LinkedList<String> tmp;
    public void DFS(int L, String s) {

        String str = "";
        for (String s1 : tmp) {
            str += s1;
        }

        if(str.length() == s.length() && L == s.length()){
            answer++;
        }
        else{
            for(int i = L ; i < s.length(); i++){
                if(s.charAt(L) == '0') return; // 0은 알파벳 번호가 없기 때문에 아예 해당 경우의 수는 탈락. 뒤에 올 숫자 볼필요도 없음.
                String num = s.substring(L, i + 1);
                if(Integer.parseInt(num) > 25) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
                
            }
        }
    }
    public int solution(String s){
        answer = 0;
        tmp = new LinkedList<>();

        DFS(0, s);

        return answer;
    }
    public static void main(String[] args){
        Ex06_06 T = new Ex06_06();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
