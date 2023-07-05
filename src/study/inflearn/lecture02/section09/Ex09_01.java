package study.inflearn.lecture02.section09;


/**
 * 사탕 가게 - 다이나믹 프로그래밍
 * 강사님&영근님 정답코드 보면서 리팩토리
 */
public class Ex09_01 {
    public int solution(int candyCnt, double money, String[] calInfo) {

        // 상근이가 i원을 가지고 얻을 수 있는 최대 칼로리
        int m = (int) Math.round(money * 100);
        int[] dp = new int[m+1];

        for (String s : calInfo) {
            int cal = Integer.parseInt(s.split(" ")[0]); // 사탕 칼로리
            int price = (int) Math.round(Double.parseDouble(s.split(" ")[1])* 100); // 사탕 가격
            // DP탐색
            for (int i = price; i < dp.length; i++) {
                dp[i] = Math.max(dp[i], dp[i-price] + cal);
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Ex09_01 T = new Ex09_01();
        System.out.println(T.solution(2, 8.00, new String[]{"700 7.00", "199 2.00"})); // 796
        System.out.println(T.solution(3, 8.00, new String[]{"700 7.00", "299 3.00", "499 5.00"})); // 798
    }


}
