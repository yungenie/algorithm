package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기초03_A더하기B_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());

        // 실수 합한 값을 소수 6번째 까지 출력
        double sum = a + b;

        System.out.printf("%.6f", sum);
    }
}
