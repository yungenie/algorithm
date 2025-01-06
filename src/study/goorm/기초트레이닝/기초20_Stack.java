package study.goorm.기초트레이닝;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 기초20_Stack {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 명령의 개수
        int K = Integer.parseInt(st.nextToken()); // 스택의 제한 크기

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if ("push".equals(cmd)) {
                // 스택의 사이즈가 3이 넘으면 Overflow
                int item = Integer.parseInt(st.nextToken());
                stack.push(item);

                if (stack.size() > K) {
                    System.out.println("Overflow");
                }
            } else if("pop".equals(cmd)){
                // 비어있을때, Underflow
                if (stack.isEmpty()) {
                    System.out.println("Underflow");
                } else {
                    System.out.println(stack.pop());
                }
            }
        }

    }
}
