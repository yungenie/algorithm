package study.inflearn.lecture01.section4;

import java.util.Scanner;

/**
 * 틀림.
 * TC 1개 Time Limit Exce.. O(n^2) 걸리기 때문에 슬라이딩 윈도우 알고리즘으로 적용 해야함.
 */
public class Ex04_03_최대매출 {

    public int solution(int n, int m, int[] saleInfo) {
        int maxSales = 0;

        for (int i = 0; i < n-m; i++) {
            int sum = 0;
            for (int j = i; j < i+m; j++) {
                sum += saleInfo[j];
            }
            maxSales = Math.max(maxSales, sum);
        }

        return maxSales;
    }

    public static void main(String[] args) {
        Ex04_03_최대매출 T = new Ex04_03_최대매출();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 매출 기록 일 수
        int m = sc.nextInt(); // 최대 매출 일 수
        int[] saleInfo = new int[n];
        for (int i = 0; i < n; i++) {
            saleInfo[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, saleInfo));

    }
}
