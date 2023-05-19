package study.inflearn;

import java.util.Stack;

/**
 * 겹쳐진 압축 해제 - 자료구조 활용
 * 소요시간 : 4시간 (중간에 강사님 해법봄)
 * 셀프피드백 :
 * 문자열에서 해당 위치(index)에 있는 문자를 반환하는 메서드 : String.charAt(int index)
 * 스택의 맨 위에 저장된 객체를 반환 : Stack.peek()
 * 스택의 맨 위에 저장된 객체를 꺼냄 : Stack.pop()
 * 스택에 객체를 저장 : Stack.push()
 * 문자열의 값이 숫자인지 확인 : 형변환 후 NumberFormatException 예외처리
 */
public class Ex03_17 {

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public String solution(String s, String result){
        String answer = "";
        int n = s.length();

        // 압축을 해제
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String sum = "";
            if (s.charAt(i) == ')') {

                // "(" 만날때까지 문자열 누적
                while (!stack.peek().equals("(")) {
                    sum = stack.pop() + sum;
                }

                // "(" 일때 꺼내기
                if (stack.peek().equals("(")){
                    stack.pop();
                }

                // 그 다음 문자열 체크 (숫자형, "(" 경우)
                String tmp = "";
                if (isNumeric(stack.peek())) { // 숫자인 경우 - 기존누적문자열 * 숫자
                    int count = 0;
                    while (count < Integer.valueOf(stack.peek())) {
                        tmp = tmp + sum;
                        count++;
                    }
                    stack.pop();
                    stack.push(tmp);
                }
                if (stack.peek().equals("(")) { // "("경우 기존누적문자열 넣기
                    stack.push(sum);
                }

            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }

        }
        // 압축을 해제한 결과
        for (String s1 : stack) {
            answer+=s1;
        }

        System.out.println(result.length() == answer.length());
        return answer;
    }

    public static void main(String[] args){
        Ex03_17 T = new Ex03_17();
        System.out.println(T.solution("3(a2(b))ef", "abbabbabbef"));
        System.out.println(T.solution("2(ab)k3(bc)", "ababkbcbcbc"));
        System.out.println(T.solution("2(ab3((cd)))", "abcdcdcdabcdcdcd"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))", "ababacacacacacacababacacacacacac"));
        System.out.println(T.solution("3(ab2(sg))", "absgsgabsgsgabsgsg"));
    }
}
