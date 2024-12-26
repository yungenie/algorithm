package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 기초16_Queue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int value = 0;
            if (st.hasMoreElements()) {
                value = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "push":
                    if (q.size() == K) {
                        System.out.println("Overflow");
                        break;
                    }
                    q.add(value);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        System.out.println("Underflow");
                        break;
                    }
                    System.out.println(q.peek());
                    q.poll();
                    break;
            }
        }
    }
}
