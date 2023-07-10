package study.inflearn.lecture02.section09;


/**
 * 팰린드롬 만들기 - 다이나믹 프로그래밍 (백준 - 1695)
 * 강사님 해법 강의 듣고 재도전 (틀림)
 */
public class Ex09_05_02 {
    public int solution(int n, int[] s) {
        int result = 0;

        int[] nums = new int[n + 1];
        System.arraycopy(s, 0, nums, 1, s.length); // (원본, 원본시작점, 복사대상, 복사시작점, 원본길이)

        /*
            2342 -> 34 경우의 수
            nums[i] == nums[j] => dy[i][j] = dy[i+1][j-1]

            1234 -> 234(숫자1 1개 추가) vs 123(숫자4 1개 추가)
            nums[i] != nums[j] => dy[i][j-1] + 1 / dy[i+1][j] +1

            길이가 2인 수열?
         */
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (nums[i] == nums[j]) {dp[i][j] = dp[i + 1][j - 1];}
                if (nums[i] != nums[j]) {dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);}
            }
        }

        return dp[1][n];
    }
    public static void main(String[] args) {
        Ex09_05_02 T = new Ex09_05_02();
        System.out.println(T.solution(5, new int[]{1,2,3,4,2}));
    }
}
