package study.inflearn.lecture01.section10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 가장 높은 탑 쌓기
 */
class Brink implements Comparable<Brink> {
    public int s, h, w;

    public Brink(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brink o) {
        return o.s - this.s; // 내림차순
    }
}
public class Ex10_04_Answer {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brink> arr = new ArrayList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brink(a, b, c));
        }

        Collections.sort(arr);
        dp[0] = arr.get(0).h;
        answer = dp[0];
        for (int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dp[j] > max_h){
                    max_h = dp[j];
                }
            }
            dp[i] = max_h + arr.get(i).h;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
