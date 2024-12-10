package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탐색05_심리적거리감 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 4시 05분 시작 - 4시 46분 완료. 성공!
         *
         * 최수 다리 개수 + 두 섬 번호 차이(절대값)
         *
         * k번 가장 거리감이 먼 섬. (섬 번호 높은)
         *
         * 트리 문제.
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 섬의 개수
        int M = Integer.parseInt(st.nextToken()); // 다리의 개수
        int K = Integer.parseInt(st.nextToken()); // 구름이 섬의 번호

        // 노드의 단방향 관계
        boolean[][] relation = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            relation[n1][n2] = true;
        }

        // 시작지점
        int startNode = K;

        // 거리 비용
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 0지점은 제외
        dist[startNode] = 0;

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode); // 지점

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < N+1; i++) {
                if (relation[now][i] && dist[i] > dist[now] + 1) {
                    dist[i] = dist[now] + 1;
                    q.offer(i);
                }
            }
        }

        // 심리적 거리감 : 최소 다리 개수 + 두 섬 번호 차이의 절대값
        int[] resultDist = new int[N+1];
        resultDist[0] = 0;
        for (int i = 1; i < N+1; i++) {
            int numDiff = Math.abs(K - i);
            resultDist[i] = dist[i] + numDiff;
        }

        // 구름이의 K번 섬에서 가장 먼 섬
        int maxDist = Arrays.stream(resultDist).max().getAsInt();

        // 모든 섬에 심리적 거리감이 없는 경우
        if (maxDist == 0) {
            System.out.println(-1);
            return;
        }

        // 심리적 거리감 동일한 섬 존재하는 경우, 높은 번호 섬 출력
        int landNumber = -1;
        for (int i = 1; i < N+1; i++) {
            if (resultDist[i] == maxDist) {
                landNumber = Math.max(landNumber, i);
            }
        }

        System.out.println(landNumber);



    }
}
