package study.programmers.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 문제 : 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지 반환
 *
 * 리팩토리, 통과
 */
public class Level3_가장먼노드2 {
    public int solution(int n, int[][] edge) {

        // 인접리스트 초기화
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
        }
        // 방문체크 및 인접리스트 노드 양방향 연결
        boolean[][] visited = new boolean[n][n];
        for (int[] node : edge) {
            int n1 = node[0]-1;
            int n2 = node[1]-1;
            visited[n1][n2] = visited[n2][n1] = true;
            relation.get(n1).add(n2);
            relation.get(n2).add(n1);
        }

        // 비용
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;

        // BFS
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0); // 지점, 비용

        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int nextNode : relation.get(nowNode)) {
                if (visited[nowNode][nextNode] && cost[nextNode] > cost[nowNode] + 1) {
                    visited[nowNode][nextNode] = false;
                    cost[nextNode] = cost[nowNode] + 1;
                    q.offer(nextNode);
                }

            }
        }

        // 가장 비용이 큰 값 찾기
        int maxCost = Arrays.stream(cost).max().getAsInt();

        // 가장 먼 거리에 해당하는 노드의 갯수
        return (int) Arrays.stream(cost)
                .filter(d -> d == maxCost)
                .count();
    }
    public static void main(String[] args) {
        Level3_가장먼노드2 T = new Level3_가장먼노드2();
        System.out.println(T.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
