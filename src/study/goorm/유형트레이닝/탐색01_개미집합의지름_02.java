package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 탐색01_개미집합의지름_02 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개미 수
        int D = Integer.parseInt(st.nextToken()); // 지름의 길이
        int[] P = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 개미 좌표

        Arrays.sort(P);

        int start = 0, end = 0; // 인덱스
        int antCount = 0; // 개미의 수

        /**
         * 투 포인트 알고리즘 적용
         * 두 거리의 차이가 지정된 차이보다 작으면 끝(end) 지점 +
         * 두 거리의 차이가 지정된 차이보다 크면 시작(start) 지점 +
         */
        while (start < N && end < N) {
            if (P[end] - P[start] <= D) {
                antCount = Math.max(antCount, end - start + 1); // 인덱스가 0부터 시작이므로 +1 해줌.
                end +=1;
            } else {
                start+=1;
            }
        }

        int result = N - antCount; // 최소 개미 수 = 전체 개미 수 - 최대 개미 수
        System.out.println(result);
    }
}
