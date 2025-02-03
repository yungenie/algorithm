package study.inflearn.lecture01.section3;

import java.util.*;

public class Ex03_12_멘토링_답 {

    public int solution(int n, int m, int[][] testInfo) {
        int answer = 0;

        // 모든 경우의 수 (i,j) 구하기
        // (1,1|2|3|4), (2,1|2|3|4), (3,1|2|3|4) ..
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;

                // 테스트 수
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    // 등수 결과
                    for (int s = 0; s < n; s++) {
                        // 경우의 수에 맞는 등수 결과
                        if (testInfo[k][s] == i) pi = s;
                        if (testInfo[k][s] == j) pj = s;
                    }
                    // 등수 결과가 pi가 높으면 멘티-멘토 체결
                    if (pi < pj) cnt++;
                }
                // 모든 테스트에서 동일한 멘티-멘토 포함된 경우
                if (cnt == m) {
                    answer++;
                }
            }

        }

        return answer;
    }


    public static void main(String[] args) {
        Ex03_12_멘토링_답 T = new Ex03_12_멘토링_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수
        int m = sc.nextInt(); // 수학 시험 횟수
        int[][] testInfo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                testInfo[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, m, testInfo));
    }
}
