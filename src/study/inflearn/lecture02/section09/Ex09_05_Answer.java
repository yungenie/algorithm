package study.inflearn.lecture02.section09;

/**
 * 팰린드롬 만들기 - 다이나믹 프로그래밍 (백준 - 1695)
 */
public class Ex09_05_Answer {
    public int solution(int n, int[] s) {

        int[] nums = new int[n + 1];
        for (int i = 1; i <=n ; i++) {
            nums[i] = s[i-1];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n-i; j++) { //✨
                if (nums[j] == nums[j+i]) { //✨
                    dp[j][j+i] = dp[j+1][j+i-1];
                } else {
                    dp[j][j+i] = Math.min(dp[j+1][j+i], dp[j][j+i-1]) + 1;
                }
            }
        }

        return dp[1][n];
    }
    public static void main(String[] args) {
        Ex09_05_Answer T = new Ex09_05_Answer();
        System.out.println(T.solution(5, new int[]{1,2,3,4,2}));
    }
}
