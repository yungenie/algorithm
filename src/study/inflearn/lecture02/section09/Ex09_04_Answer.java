package study.inflearn.lecture02.section09;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 등차수열 - 다이나믹 프로그래밍 (백준 - 1994)
 */
public class Ex09_04_Answer {
    public int solution(int n, int[] nums) {
        int answer = 0;
        if (n == 1) return 1;
        int[][] dy = new int[n + 1][n + 1]; //✨
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) { //✨
            for (int j = i+1; j <= n ; j++) { //✨
                dy[i][j] = 2;
                // 등차수열의 마지막 두 항의(i항과 j항) 앞에 항
                int pre = 2 * nums[i] - nums[j]; // i번째 앞에 항(i번째 값 - 공차) : nums[i] - (nums[j] - nums[i]) //✨

                /*
                순차 탐색 O(N)
                int k = 0;
                for (k = i-1; k >= 1 ; k--) {
                    if (nums[k] == pre) break;
                }
                dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
                */

                // 이분검색 O(logN) //✨
                int left = 1;
                int right = i - 1;
                int mid = 0;
                while (left < right) { //✨
                    mid = (left + right)/2;
                    if (nums[mid] < pre) left = mid + 1 ;
                    // 같은 숫자가 연속할 때 맨 마지막 채택
                    else if (nums[mid] == pre && nums[right] == pre) left = mid + 1; //✨
                    else right = mid; //✨
                }
                if (nums[right] == pre) {
                    dy[i][j] = Math.max(dy[i][j], dy[right][i] + 1);
                }
                answer = Math.max(answer, dy[i][j]);
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        Ex09_04_Answer T = new Ex09_04_Answer();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, nums));
    }
}
/*
5
1
4
3
5
7
>> 4
 */