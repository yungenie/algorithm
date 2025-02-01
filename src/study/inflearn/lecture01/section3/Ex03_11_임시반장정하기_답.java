package study.inflearn.lecture01.section3;

import java.util.Scanner;


public class Ex03_11_임시반장정하기_답 {

    public int solution(int n, int[][] classInfo) {
        int answer = 0, max = Integer.MIN_VALUE;

        // 기준
        for (int i = 1; i <= n ; i++) {
            int cnt = 0;

            // 비교 학생
            for (int j = 1; j <= n ; j++) {
                if (i != j) {

                    // 같은 반 비교
                    for (int k = 1; k <= 5 ; k++) {
                        if (classInfo[i][k] == classInfo[j][k]) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03_11_임시반장정하기_답 T = new Ex03_11_임시반장정하기_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] classInfo = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                classInfo[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, classInfo));
    }
}
