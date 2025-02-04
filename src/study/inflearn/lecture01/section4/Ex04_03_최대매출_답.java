package study.inflearn.lecture01.section4;

import java.util.Scanner;

public class Ex04_03_최대매출_답 {

    public int solution(int n, int m, int[] saleInfo) {
        int maxSales = 0, sum = 0;

        for (int i = 0; i < m; i++) {
            sum += saleInfo[i];
        }
        maxSales = sum;

        for (int i = m; i < n ; i++) {
            sum += (saleInfo[i] - saleInfo[i-m]);
            maxSales = Math.max(maxSales, sum);
        }
        return maxSales;
    }

    public static void main(String[] args) {
        Ex04_03_최대매출_답 T = new Ex04_03_최대매출_답();
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
