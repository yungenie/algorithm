package study.inflearn.lecture02.section09;

import java.util.Scanner;

/**
 * 수확 - 다이나믹 프로그래밍 (백준 - 1823)
 * 메모리 : 34396KB, 시간 : 288ms
 */
public class Ex09_06_Answer {
    public int solution(int n, int[] nums){
        // dy정의
        int[][] dy = new int[n + 1][n + 1];
        // 벼의 누적값
        int[] s = new int[n + 1];
        s[1] = nums[1];
        for (int i = 2; i <= n; i++) {
            s[i] = s[i - 1] + nums[i];
        }
        // 벼 1개 경우
        for (int i = 1; i <= n; i++) {
            dy[i][i] = nums[i];
        }
        // 벼 2개이상 경우
        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= n-i; j++) {
                dy[j][j + i] = Math.max(dy[j][j + i - 1], dy[j + 1][j + i]) + (s[j + i] - s[j - 1]);
            }
        }
        return dy[1][n];
    }

    public static void main(String[] args) {
        Ex09_06_Answer T = new Ex09_06_Answer();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, nums));
    }
}
