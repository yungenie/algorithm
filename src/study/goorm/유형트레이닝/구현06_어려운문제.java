package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 구현06_어려운문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 팩토리얼 계산
        BigInteger factory = BigInteger.ONE;
        for (int i = n; i > 1 ; i--) {
            factory = factory.multiply(BigInteger.valueOf(i)); // multiply() 곱셉 기능 수행
        }

        // 각 자리수 합이 한 자리수가 될 때까지 반복
        BigInteger temp = factory;
        while (temp.compareTo(BigInteger.TEN) >= 0) {
            BigInteger sum = BigInteger.ONE;
            String factoryStr = String.valueOf(temp);

            // 문자열로 변환 후 각 자리수 합 계산
            for (int j = 0; j < factoryStr.length(); j++) {
                sum.add(BigInteger.valueOf(Character.getNumericValue(factoryStr.charAt(j))));
            }
            temp = sum;
        }

        System.out.println(temp);

    }
}
