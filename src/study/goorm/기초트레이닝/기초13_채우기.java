package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기초13_채우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];

        int mx = 0, my = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] == 0) {
                    mx = i; // 행
                    my = j; // 열
                }
            }
        }

        int sum = 0;
        for (int z = 0; z < N; z++) {
            sum+=array[mx][z] + array[z][my];
        }
        System.out.println(sum);


    }
}
