package study.inflearn;

import java.util.Stack;
/**
 * 겹쳐진 압축 해제 - 자료구조 활용
 * Character.isDigit(char ch) : char 값이 숫자 인지 여부를 판단하여  true/flase 리턴합니다.
 */
public class Ex03_17_Answer {
    public String solution(String s){
        String answer = "";
        Stack<String> st = new Stack<>();
        for(Character x : s.toCharArray()){
            if(x == ')'){
                String tmp = "";
                while(!st.empty()){
                    String c = st.pop();
                    if(c.equals("(")){
                        String num = "";

                        // 스택이 비어있지 않고, 숫자형 문자인지 확인
                        // todo 왜 반복문을 돌리는 지?
                        while(!st.empty() && Character.isDigit(st.peek().charAt(0))){
                            num = st.pop() + num;
                        }

                        // 반복횟수 구하기
                        int cnt = 0;
                        if(num.equals("")) {
                            cnt = 1; //숫자가 없는 경우
                        } else {
                            cnt = Integer.parseInt(num); //꺼낸숫자 형변환
                        }

                        // 꺼낸문자열(tmp)의 반복횟수(꺼낸숫자) 합산
                        String res = "";
                        for(int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        st.push(res);
                        break; // 다음 문자 탐색으로 가야함
                    }
                    tmp = c + tmp; // 꺼낸 문자열 결합연산
                }
            }
            else st.push(String.valueOf(x));
        }
        for(String x : st) answer += x;
        return answer;
    }

    public static void main(String[] args){
        Ex03_17_Answer T = new Ex03_17_Answer();
        System.out.println(T.solution("3(a2(b))ef"));
        //System.out.println(T.solution("2(ab)k3(bc)"));
        //System.out.println(T.solution("2(ab3((cd)))"));
        //System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        //System.out.println(T.solution("3(ab2(sg))"));
    }
}
