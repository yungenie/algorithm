package study.inflearn.lecture02.section09;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 팰린드롬 만들기 - 다이나믹 프로그래밍 (백준 - 1695)
 * 테스트 케이스 1번 답은 나왔으나 백준에서는 틀림
 */
public class Ex09_05 {
    public static void main(String[] args) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 수열 해싱 {수열 : 중복개수}
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*
            팰린드롬 만들기 위해 끼워 넣을 최소 개수
            1. 모든 수열이 1개 : 1을 가지고 있는 모든 수열의 개수 - 1
            2. 3개 이상 가지고 있는 수열 1개 : 1을 가지고 있는 모든 수열의 개수
            3. 3개 이상 가지고 있는 수열 2개 이상 : (3이상 개수 - 1) + 1을 가지고 있는 모든 수열의 개수
         */
        int oneCnt = 0;
        int threeCnt = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) oneCnt++;
            if (map.get(key) > 2 && map.get(key) % 2 == 1) threeCnt++;
        }
        if (threeCnt == 0) result = oneCnt - 1;
        else if (threeCnt == 1) result = oneCnt;
        else if (threeCnt >= 2) result = threeCnt - 1 + oneCnt;

        System.out.println(result);
    }
}
/*
5
1 2 3 4 2
>> 2
 */