package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 틀린답. 0~마지막N번까지 옮길 수 있는 횟수로 이해했음. DFS 풀이
 */
public class 기초18_보드게임 {

    public static final int MOD = 1000000007;
    public static int N = 0;
    public static int count = 0;

    public static void DFS(int step) {

        if (step > N) return;
        if (step == N) count++;
        else {
            DFS(step + 1);
            DFS(step + 3);
        }

    }

    public static void main(String[] args) throws Exception {
        /**
         * 문제 : N번 칸까지 옮길 수 있는 횟수
         * 0~N
         * 0+5 0 1 2 3 4 5
         * 1칸 또는 3칸 옮김.
         * 도착 지점까지 말을 옮길 수 있는 방법의 개수 / 1000000007
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(0);
        DFS(3);

        System.out.println(count);
    }
}
