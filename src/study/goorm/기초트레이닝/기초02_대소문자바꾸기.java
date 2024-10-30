package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 기초02_대소문자바꾸기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < N; i++) {
            int num = (int) S.charAt(i); // 아스키코드 변환

            int temp = 0;
            if (num >= 65 && num <= 90) { // 대문자 -> 소문자
                temp = 32;
            } else { // 소문자 -> 대문자
                temp = -32;
            }

            int num2 = num + temp;
            char c = (char)num2;
            sb.append(c);

            /**
             * 더 좋은 풀이.
             * 아스키코드 변환없이. Character에 있는 메소드로 처리 가능.
             */
/*            char ch = S.charAt(i);
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch);
            }*/


        }
        System.out.println(sb);
    }
}
