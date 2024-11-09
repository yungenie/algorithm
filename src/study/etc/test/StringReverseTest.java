package study.etc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringReverseTest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        // String 문자열 반전 시키기
        StringReverseTest st = new StringReverseTest();
        System.out.println("방법1");
        st.StringToCharReverse(text);

        System.out.println("\n방법2");
        System.out.println(st.StringBuilderReserve(text));

    }

    private void StringToCharReverse(String str){
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
    private String StringBuilderReserve(String str) {
        return new StringBuilder(str).reverse().toString();
    }


}
