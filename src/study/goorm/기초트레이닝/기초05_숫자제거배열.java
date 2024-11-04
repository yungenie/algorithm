package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기초05_숫자제거배열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        /**
         * 방법1 - 정수로 입력받아서 문자열로 변환 후 판별 (fori가 성능이 더 좋음)
         */
        String k = st.nextToken();
        String[] a = br.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!a[i].contains(k)) count++;
        }

        /**
         * 방법2 - k와 a만 문자열로 입력받아 stream으로 처리
         */
/*
        String k = st.nextToken();
        String[] a = br.readLine().split(" ");
        long count = Arrays.stream(a)
                .filter(str -> !str.contains(k))
                .count();
*/

        System.out.println(count);

    }
}
