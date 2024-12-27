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
         * 밀도가 같다면, 부피가 무거운것.
         * 밀도도 같고, 부피도 같으면 번호가 더 작은 것.
         */

        int N = Integer.parseInt(br.readLine());

        int d = Integer.MIN_VALUE;
        int[] wArr = new int[N+1];
        double[] dArr = new double[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 부피

            wArr[i] = w;
            dArr[i] = w/(double) v;
        }

        double dmax = Arrays.stream(dArr).max().getAsDouble();

        int result = -1;
        int max = Integer.MIN_VALUE;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 1; i <= N ; i++) {

            // 가장 높은 밀도가 같은 경우
            if (dmax == dArr[i]) {
                minIndex = Math.min(minIndex, i);

                // 가장 무거운 요소의 번호
                if (max < wArr[i]) {
                    max = wArr[i];
                    result = i;
                // 가장 무거운 무게가 동일한 경우 작은 번호
                } else if (max == wArr[i]){
                    result = minIndex;
                    break;
                }
            }
        }

        System.out.println(result);


    }
}
