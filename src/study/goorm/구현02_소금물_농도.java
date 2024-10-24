package study.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class 구현02_소금물_농도 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기 : N은 소금물의 양, M은 추가되는 물의 양
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 기존 소금의 양 (Ng의 7% 소금물)
        double salt = N * 0.07;

        // 최종 소금물의 양
        double total = N + M;

        // 최종 소금물의 농도 (전체 소금물에서 소금이 차지하는 비율)
        double concentration = (salt / total) * 100;

        /**
         * 소수점 둘째 자리까지 표현하기. (반올림 없이 셋째자리는 버림)
         */
        // 방법1.
        double result1 = Math.floor(concentration * 100);
        double result2 = result1 / 100.0;

        System.out.printf("%.2f", result2);
        System.out.println("asdfasdf");
        //System.out.printf("%.2f", Math.floor(concentration * 100) / 100.0);

        // 방법2. BigDecimal을 사용하여 소수점 둘째 자리까지 버림 처리
        //BigDecimal result = new BigDecimal(concentration).setScale(2, RoundingMode.FLOOR);
        //System.out.println(result);
    }
}