package study.inflearn.lecture02.section09;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 등차수열 - 다이나믹 프로그래밍 (백준 - 1994)
 * 첫번째 시도 -> 못품
 * 강사님 강의 듣고 수정 -> 답은 맞으나 메모리 초과
 */
public class Ex09_04 {
    public int solution(int n, int[] nNum){
        if (n==1) return 1;
        // DP테이블 정의
        // 마지막 정수 - 첫번째 정수 = dp 사이즈
        int[] dp = new int[nNum[n - 1] - nNum[0] + 1];
        Arrays.fill(dp, -1);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nNum[i], i);
        }

        // dp i~N까지 차이 인 정수들을 찾아서 최대 길이 반환.
        // for dp i~N
            // for nNum j
                // j+i map에 있는지
                    // 있으면 카운트
                    // max()?
                // 없으면 continue

        int len = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; ) {
                int next = nNum[j]+i;
                if (map.containsKey(next)) {
                    len++;
                    j = map.get(next);
                } else {
                    dp[i] = Math.max(len, dp[i]);
                    len = 1;
                    j++;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    public static void main(String args[]){
        Ex09_04 T = new Ex09_04();
        Scanner sc = new Scanner(System.in);

        // n개의 정수들 오름차순
        int n = sc.nextInt();
        int[] nNum = new int[n];
        for (int i = 0; i < n; i++) {
            nNum[i] = sc.nextInt();
        }
        Arrays.sort(nNum);
        System.out.println(T.solution(n, nNum));
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