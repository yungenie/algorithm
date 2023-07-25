package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 사탕 가게 - 다이나믹 프로그래밍 (백준 - 4781)
 * 2회독
 * 소요시간 : 26분
 * 틀림
 */
public class Ex09_01_02 {
    public static void main(String[] args) {

        /*
        // 내가 푼 코드
        while(true){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = (int) sc.nextDouble() * 100;

            if (n == 0 && m == 0) break;

            int[] dp = new int[m+1];

            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                int p = (int) sc.nextDouble() * 100;

                for (int j = p; j < dp.length; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
                System.out.println(dp[m]);
            }
        }*/

        // 수정한 코드
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt(); // 사탕 종류의 수 n

            /*
                Math.round() 하는 지?
                예를 들어 7.10(double) * 100 = 710.0(double) 나오는 경우가 생겨 반올림을 해줘야한다.
             */
            int m = (int) Math.round(sc.nextDouble() * 100); // 돈의 양 m, 소수 둘째자리까지 주어짐

            if (n == 0 && m == 0) break;

            // dp[i] i원을 가지고 구매할 수 있는 최대 칼로리
            int[] dp = new int[m+1];

            for (int i = 0; i < n; i++) {
                int c = sc.nextInt(); // 칼로리 c
                int p = (int) Math.round(sc.nextDouble() * 100); // 가격 p, 소수 둘째자리까지 주어짐

                 /*
                    - 전형적인 냅색 문제
                    - 다이나믹 프로그래밍은 문제를 작은 단위에서 점점 확대에서 최종적인답을 구해내는 것

                    - 풀이설명
                        - 주어진 사탕 종류의 가격을 인덱스(j)를 시작으로 배열의 끝까지 돌면서 주어진 사탕을 무조건 1개 사고(c),
                          남은 돈(dp[j-p])으로 살 수 있는 사탕의 칼로리를 합해서 기존의 칼로리(dp[j])보다 크면 교체한다.

                        - 사탕 종류에 대한 개수가 제한적이지 않기 때문에 여러번 살 수 있으므로,
                          바텀업으로 아래 점화식을 통해 최종답을 구해간다.

                        - 점화식
                          주어진 사탕가격으로 사탕 종류를 일단 1개 사고 남은 거스름 돈으로 구매할 수 있는 최대 칼로리
                          + 주어진 사탕 종류의 칼로리(1개 구매한다는 가정)
                */
                for (int j = p; j < dp.length; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
                System.out.println(dp[m]);
            }

        }

    }
}
