package study.programmers.graph;

import java.util.*;

public class Level3_가장먼노드_Answer {
    public int solution(int n, int[][] edge) {

        // 노드의 양방향 관계
        boolean[][] relation = new boolean[n+1][n+1];
        for (int[] node : edge) {
            int n1 = node[0];
            int n2 = node[1];
            relation[n1][n2] = relation[n2][n1] = true;
        }

        // 시작지점
        int startNode = 1;

        // 거리 비용
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 0지점은 제외
        dist[startNode] = 0;

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode); // 지점

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (relation[now][i] && dist[i] > dist[now] + 1) {
                    dist[i] = dist[now] + 1;
                    q.offer(i);
                }
            }
        }

        // 가장 먼 거리 값 찾기
        int maxDist = Arrays.stream(dist).max().getAsInt();

        // 가장 먼 거리에 해당하는 노드의 갯수
        return (int) Arrays.stream(dist)
                .filter(d -> d == maxDist)
                .count();
    }
    public static void main(String[] args) {
        Level3_가장먼노드_Answer T = new Level3_가장먼노드_Answer();
        System.out.println(T.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
