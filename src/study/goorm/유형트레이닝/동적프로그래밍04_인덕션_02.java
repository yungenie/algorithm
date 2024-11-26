package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동적프로그래밍04_인덕션_02 {

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 음식의 개수
        int N = Integer.parseInt(br.readLine());

        // 각 음식에 필요한 온도
        int[] reqTemps = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            reqTemps[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 : dp[i][x][y][z] - i번째 음식을 조리했을때 (x,y,z) 인덕션의 최소 버튼 조작 횟수
        int[][][][] dp = new int[N + 1][10][10][10];
        for(int[][][] d1 : dp) {
            for (int[][] d2 : d1) {
                for (int[] d3 : d2) {
                    Arrays.fill(d3, INF);
                }
            }
        }
        dp[0][0][0][0] = 0; // 초기 모든 인덕션 온도 0


        // 각 음식 순차적으로 처리
        for (int i = 0; i < N; i++) {
            int targetTemp = reqTemps[i];

            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    for (int z = 0; z < 10; z++) {
                        if (dp[i][x][y][z] == INF) continue;

                        /**
                         * 현재 열판 x,y,z에서 다음 음식을 targetTemp로 조리하기 위함.
                         */

                        // 첫 번째 열판으로 설정
                        int costX = getMinButtonPress(x, targetTemp);
                        dp[i + 1][targetTemp][y][z] = Math.min(dp[i + 1][targetTemp][y][z], dp[i][x][y][z] + costX);

                        // 두 번째 열판으로 설정
                        int costY = getMinButtonPress(y, targetTemp);
                        dp[i + 1][x][targetTemp][z] = Math.min(dp[i + 1][x][targetTemp][z], dp[i][x][y][z] + costY);

                        // 세 번째 열판으로 설정
                        int costZ = getMinButtonPress(z, targetTemp);
                        dp[i + 1][x][y][targetTemp] = Math.min(dp[i + 1][x][y][targetTemp], dp[i][x][y][z] + costZ);


                    }

                }

            }

        }

        // 마지막 상태에서 최소 버튼 조작 횟수 찾기
        int result = INF;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    result = Math.min(result, dp[N][x][y][z]);
                }
            }
        }

        System.out.println(result);


    }

    /**
     *
     * @param current : 현재 인덕션
     * @param target  : 올릴 음식 온도
     * @return
     */
    private static int getMinButtonPress(int current, int target) {
        // 0~9 온도가 순환함. 0에서 -1하면 9, 9에서 +1하면 0
        // 버튼 횟수가 음수가 나오지 않게 하기 위해 +10을 한다.
        int increase = (target - current + 10) % 10; // + 버튼으로 설정하는 횟수
        int decrease = (current - target + 10) % 10; // - 버튼으로 설정하는 횟수
        return Math.min(increase, decrease);
    }

}
