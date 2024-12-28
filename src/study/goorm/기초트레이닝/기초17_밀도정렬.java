package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기초17_밀도정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 밀도 = 무게/부피
         * 밀도가 같다면, 무게가 무거운 번호
         * 밀도와 부피도 같으면 더 작은 번호
         */

        int N = Integer.parseInt(br.readLine());

        int[] wArr = new int[N+1];
        double[] dArr = new double[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 부피

            wArr[i] = w;
            dArr[i] = w/(double) v;
        }

        // 가장 높은 밀도 구하기.
        double dmax = Arrays.stream(dArr).max().getAsDouble();

        int result = -1;
        int wMax = Integer.MIN_VALUE;
        int number = Integer.MAX_VALUE;
        for (int i = 1; i <= N ; i++) {

            // 가장 높은 밀도가 같은 경우
            if (dmax == dArr[i]) {
                // 가장 높은 밀도 번호 초기화
                number = Math.min(number, i);

                // 가장 무거운 요소의 번호 구하기
                // 첫 반복문 순서때 무게 초기화, 다음 순서때 더 큰 무게로 초기화
                if (wMax < wArr[i]) {
                    wMax = wArr[i];
                    result = i;
                // 가장 무거운 무게가 동일한 경우 작은 번호 구하기
                } else if (wMax == wArr[i]){
                    result = number;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}
