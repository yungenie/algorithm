package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구현04_장마 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 마을의 땅 높이 >> 배열에 저장.
         * 배수시스템
         */

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] heights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        boolean[] check = new boolean[N];
        for (int i = 1; i <= M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken()) - 1;
            int end = Integer.parseInt(st2.nextToken()) - 1;

            for (int j = start; j <= end; j++) {
                heights[j]++;
                check[j] = true;
            }

            // 배수시스템
            if (i % 3 == 0) {
                for (int k = 0; k < N ; k++) {
                    if (check[k]){
                        heights[k]--;
                    }
                }
                check = new boolean[N]; // 2일내 것만 기록하고 지워야함.
            }
        }

        for (int h = 0; h < N; h++) {
            System.out.print(heights[h]+ " ");
        }
    }
}
