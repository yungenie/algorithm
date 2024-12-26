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
            String[] line = br.readLine().split(" ");
            String cmd = line[0];

            int value = 0;
            if (line.length > 1) {
                value = Integer.parseInt(line[1]);
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
