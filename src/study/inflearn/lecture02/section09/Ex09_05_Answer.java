package study.inflearn.lecture02.section09;

/**
 * 팰린드롬 만들기 - 다이나믹 프로그래밍 (백준 - 1695)
 */
public class Ex09_05_Answer {
    public int solution(int n, int[] s) {

        // 입력 데이터 배열
        int[] nums = new int[n + 1]; //✨
        for (int i = 1; i <=n ; i++) {
            nums[i] = s[i-1];
        }

        // i번째부터 j번째까지 부분수열에서 팰린드롬을 만들기위해 끼워넣어야할 수의 최소 개수
        int[][] dp = new int[n + 1][n + 1]; //✨
        for (int i = 1; i < n; i++) { //✨
            for (int j = 1; j <= n-i; j++) { //✨
                /*
                    예시)
                    1 2 3 4 1 j번째(1)와 j+i(1)번째 원소가 같은 경우 (양끝이 같은 경우)
                        - 2 3 4 j+1번째부터 j+i-1번째까지 dp값(이미 최소값이 구해져있음)
                    4 5 2 7 3 모두 다른 원소의 경우
                        - 4 | 5 2 7 3, 4를 끼워넣는 개수(1) + j+1번째부터 j+i번째까지 dp값
                        - 4 5 2 7 | 3, j번째부터 j+i-1번째가지 dp값 + 3을 끼워넣는 개수(1)
                        - 2가지 경우의 수 중 가장 작은 수가 j번째부터 j+i번째까지의 최소 개수
                 */
                if (nums[j] == nums[j+i]) { //✨
                    dp[j][j+i] = dp[j+1][j+i-1]; //✨
                } else {
                    dp[j][j+i] = Math.min(dp[j+1][j+i], dp[j][j+i-1]) + 1; //✨
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
