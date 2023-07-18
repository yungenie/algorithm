package study.inflearn.lecture01.section10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 가장 높은 탑 쌓기
 * 강사님 해설 듣고 재도전
 */
public class Ex10_04_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 벽돌 정보 저장 {0인덱스 : 넓이, 1인덱스 : 높이, 2인덱스 : 무게}
        Integer[][] arr = new Integer[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer[]{sc.nextInt(),sc.nextInt(),sc.nextInt()};
        }
        Arrays.sort(arr, (a,b) -> b[0] - a[0]); // 넓이 내림차순

        // i번째 벽돌이 가장 높이 쌓을 수 있는 탑의 높이
        int[] dp = new int[n];
        dp[0] = arr[0][1];
        /*
            탑을 쌓을 수 있는 조건
            - 벽돌탑은 내려갈 수록 밑면이 넓고 무게가 무겁다.

            DP탐색
            - 탑을 쌓을 수 있는 조건 중 넓이는 내림차순 정렬을 통해 비교하지 않아도 무조건 앞 원소가 크다.
            - 무게만 비교하면 된다. i번째 벽돌 앞에 있는 벽돌들의 무게를 i번째와 비교하면서 가장 큰 dp값을 구하면 된다.
            - 최대 dp값과 i번째 높이를 더한다.
                넓이 : 25 16 9 4 1
                무게 :  4  5 3 6 2
                높이 :  3  2 2 4 5
                dp배열 :3  2 5 4 10
         */
        for (int i = 1; i < n ; i++) {
            int max = 0;
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[i][2] < arr[j][2]) { // 무게비교
                    max = Math.max(dp[j], max); // 앞에 벽돌 중에 가장 큰 dp값
                }
            }
            dp[i] = max + arr[i][1]; // dp값 + i번째 높이
        }
        /*
            error 최대값을 구하지않아서 채점사이트에서 틀림
            dp배열의 최대값을 구해야 하는 이유?
            - 벽돌을 입력되는 순서 마지막까지 쌓는걸로 생각했음.
            - 순서의 마지막을 구하는게 아님.
            - 벽돌을 쌓는 순서가 정해진게 없기 때문에 어떤 순서로 쌓였는 지 모른다. 그러므로 dp 다이나믹 테이블의 가장 최대값을 구해야한다.
            - i번째 벽돌마다 이전 벽돌을 조건에 맞게 쌓아올리면서 i번째 벽돌까지 쌓았을 때 총 높이를 구하므로
            - 모든 계산을 한 뒤 최대값을 구하는 문제이다.
            - 계단오르기, 돌다리 건너기처럼 정해진 끝을 구해야하는 줄 알았다.
            - note 다이나믹 프로그래밍에서 도착지점이 정해지지 않은 문제는 최대값/최소값을 구하는 접근법으로 생각해봐야함.
         */
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
/*
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2
>> 10
 */