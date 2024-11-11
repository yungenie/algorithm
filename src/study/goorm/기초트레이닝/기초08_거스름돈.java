package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 기초08_거스름돈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] coin = {40, 20, 10, 5, 1};
        int count = 0;
        for (int i = 0; i < coin.length; i++) {
            if (N >= coin[i]) {
                // 몫
                count += N / coin[i];

                // 나머지
                N = N % coin[i];
            }
        }
        System.out.println(count);
    }
}
