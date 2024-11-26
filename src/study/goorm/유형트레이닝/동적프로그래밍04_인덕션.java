package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동적프로그래밍04_인덕션 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] food = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        int[] induction = new int[3];
        for (int i = 0; i < induction.length; i++) {
            induction[i] = -1;

        }


        for (int i = 1; i < food.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i-1; j++) {
                int abs = Math.abs(food[i] - food[j]);
                if (abs == 9){
                    abs = 1;
                }

                min = Math.min(abs, min);

            }
            // todo 뒤에 방향까지 생각 해야하는건가..? 아니면 세개 중 적어도 하나는 필요한 온도로 설정되어 있어야한다..?

            dp[i] = min;
            induction[i % 3] = food[i];
        }

        int sum = Arrays.stream(dp).sum();
        System.out.println(Arrays.stream(dp).sum());


    }
}
