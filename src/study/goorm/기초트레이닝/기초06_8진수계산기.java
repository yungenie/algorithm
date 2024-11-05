package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기초06_8진수계산기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        /**
         * 방법1 - 내가 푼 풀이
         */
        int mod = 8;
        int num = sum;
        List<String> list = new ArrayList<>();
        while (true) {
            if (num / mod == 0) break;
            int remainder = num % mod; // 나머지
            list.add(String.valueOf(remainder));
            num = num / mod; // 몫;
        }

        StringBuilder result = new StringBuilder();
        for (int i = list.size() -1 ; i >= 0; i--) {
            result.append(list.get(i));
        }

        System.out.println(num + result.toString());

        /**
         * 방법2 - 리서치 풀이 toOctalString() 메소드 활용
         * toOctalString() 8진수로 변환하여 문자열로 반환함.
         */
        System.out.println(Integer.toOctalString(sum));
    }
}
