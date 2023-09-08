package study.programmers.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 답은 맞았으나, 실행초과
 */
public class Level3_가장먼노드 {
    public int solution(int n, int[][] edge) {

        // 방문체크
        boolean[][] visited = new boolean[n + 1][n + 1];
        int edgeLen = edge.length;
        for (int i = 0; i < edgeLen; i++) {
            int n1 = edge[i][0];
            int n2 = edge[i][1];
            visited[n1][n2] = true;
            visited[n2][n1] = true;
        }

        // 인접리스트
        ArrayList<ArrayList<int[]>> relation = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            relation.add(new ArrayList<>());
        }
        for (int i = 1; i < edgeLen; i++) {
            for (int j = 1; j < edgeLen; j++) {
                if(visited[i][j]) {
                    relation.get(i).add(new int[]{j, 1});
                }
            }
        }

        // 비용
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        cost[1] = 0;
        // BFS
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0}); // 지점, 비용

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] now = q.poll();
                int nowNode = now[0];
                int nowCost = now[1];
                for (int[] x : relation.get(nowNode)) {
                    int nextNode = x[0];
                    int nextCost = x[1];
                    int totalCost = nowCost + nextCost;
                    if (visited[nowNode][nextNode] && totalCost < cost[nextNode]) {
                        visited[nowNode][nextNode] = false;
                        cost[nextNode] = totalCost;
                        q.offer(new int[]{nextNode, totalCost});
                    }

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
        Level3_가장먼노드 T = new Level3_가장먼노드();
        System.out.println(T.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
