package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 기초07_구름스퀘어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 행사의 개수
        int[][] events = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            events[i][0] = start; // 시작 시간 (행)
            events[i][1] = end; // 끝나는 시간 (열)
        }

        // 끝나는 시간 기준으로 오름차순
        Arrays.sort(events, (a,b) -> {
            if (a[1] == b[1]) { // 끝나는 시간이 같으면 시작시간 기준으로 오름차순
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int lastEndTime = 0;

        // 그리디 알고리즘 적용
        for (int[] event : events) {
            if (event[0] >= lastEndTime) { // 시작시간이 마지막 끝나는 시간보다 커야함.
                count++;
                lastEndTime = event[1] + 1; // 최소 1의 시간이 지난 뒤 행사 시작 가능.
            }
        }

        System.out.println(count);


    }
}
