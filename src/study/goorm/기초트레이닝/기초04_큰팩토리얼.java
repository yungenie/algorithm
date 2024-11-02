package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 기초04_큰팩토리얼 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /**
         * 방법1 - 최대 메모리 사용량, 실행시간 성능이 더 좋음.
         */
        int mod = 1000000007;
        Long result = 1L;
        for (int i = 2; i <= N ; i++) {
            result = (result * i) % mod;
        }

        /**
         * 방법2 - BigInteger 불변객체이기 때문에 메모리 사용량이 방법1보다는 조금 더 잡아 먹는다. 그래도 timeout 안남.
         */
        BigInteger factory = BigInteger.ONE;
        for (int i = 2; i <= N ; i++) {
            factory = factory.multiply(BigInteger.valueOf(i)).remainder(BigInteger.valueOf(1000000007));
        }

        System.out.println(factory);

    }
}
