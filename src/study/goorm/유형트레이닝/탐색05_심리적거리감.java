package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 4시 05분 시작 - 4시 46분 완료. 성공!
 * 해당문제에서 다익스트라를 활용하지 않는 이유는 가중치가 따로 없는 문제이며,
 * 최단거리가 동일한 경우 노드의 높은 번호를 출력해야하는 조건이 생기기 때문에 우선순위 큐로 처리하기 어려우므로 BFS로 처리.
 */
public class 탐색05_심리적거리감 {
    public static void main(String[] args) throws Exception {
        // 입력 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 섬의 개수
        int M = Integer.parseInt(st.nextToken()); // 다리의 개수
        int K = Integer.parseInt(st.nextToken()); // 구름이 섬의 번호

        // 그래프의 연결 관계 - 인접 행렬 사용 (2차원 배열)
        boolean[][] relation = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()); // 행(시작노드)
            int n2 = Integer.parseInt(st.nextToken()); // 열(도착노드)
            relation[n1][n2] = true; // 단방향 다리 연결
        }

        // 시작지점
        int startNode = K;

        // 최단 거리 비용
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 최단거리 초기화 : 최단거리 구하기 위해 최대값으로 초기화
        dist[startNode] = 0; // 시작 노드의 거리는 0

        // BFS를 통한 최단 거리 계산
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);

        while (!q.isEmpty()) {
            // 시작 지점부터 도착하는 모든 노드의 최단거리 구하기
            int now = q.poll();
            for (int i = 1; i < N+1; i++) {
                // 연결된 노드이고, 더 짧은 거리일 경우 업데이트
                if (relation[now][i] &&
                        dist[i] > dist[now] + 1) { // 도착하는 노드의 최단거리 > 시작노드의 기존 최단거리 + 시작노드에서 도착노드까지 이동 거리(1)
                    dist[i] = dist[now] + 1;
                    q.offer(i);
                }
            }
        }

        // 심리적 거리감 계산 (최소 다리 개수 + 두 섬 번호 차이의 절대값)
        int[] resultDist = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            resultDist[i] = dist[i] + Math.abs(K - i);
        }

        // 구름이의 K번 섬에서 가장 심리적 거리감이 먼 섬 찾기
        int maxDist = Arrays.stream(resultDist).max().getAsInt();

        // 심리적 거리가 먼 섬이 없으면 -1 출력
        if (maxDist == 0) {
            System.out.println(-1);
            return;
        }

        // 심리적 거리감이 동일한 섬 중 높은 번호 섬 찾기
        int landNumber = -1;
        for (int i = 1; i < N+1; i++) {
            if (resultDist[i] == maxDist) {
                landNumber = Math.max(landNumber, i);
            }
        }

        System.out.println(landNumber);

    }
}
