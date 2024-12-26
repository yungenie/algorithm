package study.goorm.기초트레이닝;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 기초14_큰수식찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        long resultA = evaluate(A);
        long resultB = evaluate(B);

        System.out.println(Math.max(resultA, resultB));


    }

    // 수식을 계산하는 메서드 (중위 표기법을 직접 처리)
    public static long evaluate(String expression) {
        Stack<Long> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // 숫자 읽기
                int start = i;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    i++;
                }
                long number = Long.parseLong(expression.substring(start, i));
                numbers.push(number);
                continue;
            } else if (ch == '+' || ch == '-' || ch == '*') {
                // 연산자 처리
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    compute(numbers, operators);
                }
                operators.push(ch);
            }
            i++;
        }

        // 남은 연산자 처리
        while (!operators.isEmpty()) {
            compute(numbers, operators);
        }

        return numbers.pop();
    }

    // 연산 우선순위 반환
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*') {
            return 2;
        }
        return 0;
    }

    // 연산을 수행하는 메서드
    public static void compute(Stack<Long> numbers, Stack<Character> operators) {
        long b = numbers.pop();
        long a = numbers.pop();
        char operator = operators.pop();

        if (operator == '+') {
            numbers.push(a + b);
        } else if (operator == '-') {
            numbers.push(a - b);
        } else if (operator == '*') {
            numbers.push(a * b);
        }
    }
}
