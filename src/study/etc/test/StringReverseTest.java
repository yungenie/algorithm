package study.etc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringReverseTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // String 문자열 반전 시키기
        System.out.println("방법1");
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }

        System.out.println("\n방법2");
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());

    }
}
