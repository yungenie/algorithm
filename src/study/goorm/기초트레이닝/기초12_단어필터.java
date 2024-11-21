package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기초12_단어필터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sLen = Integer.parseInt(st.nextToken()); // 단어 S 길이 : 걸러야 하는 단어
        int eLen = Integer.parseInt(st.nextToken()); // 사용자 메시지 E 길이 : 전달 받은 메시지

        String S = br.readLine(); // 1  a
        String E = br.readLine(); // 2  bc

        if (E.contains(S)) {
             E = E.replace(S, ""); // todo replace는 새로운 문자열을 반환함. 문자열 복사 메모리 할당 반복 성능 저하.
        }

        if (E.contains(S.toUpperCase())) {
            E = E.replace(S.toUpperCase(), "");
        }

        if (E.contains(S.toLowerCase())) {
            E = E.replace(S.toLowerCase(), "");
        }


        String result = "EMPTY";
        if(!E.isEmpty()) {
            result = E;
        }
        System.out.println(result);


    }
}
