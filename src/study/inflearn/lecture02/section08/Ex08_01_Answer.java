package study.inflearn.lecture02.section08;

import java.util.*;

/**
 * 최소 비행료 - 그래프 최단거리 : Graph
 */
public class Ex08_01_Answer {
    public int solution(int n, int[][] flights, int s, int e, int k) {

        // 인접리스트를 이용한 방향 그래프
        // 각 도시마다 도착하는 도시 정보 (행이 각 도시별, 열이 도착도시)
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<int[]>());
        }
        for(int[] x : flights){
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }

        // costs[i] s출발도시에서 i도착도시까지 드는 최소비용
        int[] costs = new int[n];
//        Arrays.fill(costs, 1000000000);
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[s] = 0;

        Queue<int[]> Q = new LinkedList<>(); // 레벨탐색
        Q.offer(new int[]{s, 0});

        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = Q.poll();
                int curEnd = cur[0];
                int curCost = cur[1];
                for (int[] x: graph.get(curEnd)) { // 도착지 도시의 운행정보
                    int next = x[0];
                    int cost = x[1];
                    if (curCost + cost < costs[next]) { // 최소비용
                        costs[next] = curCost + cost;
                        Q.offer(new int[]{next, costs[next]}); // {도착지, 비행료}
                    }
                }
            }
            L++;
            if (L > k) break;
        }

        if (costs[e] == Integer.MAX_VALUE) return -1;
        return costs[e];
    }

    public static void main(String[] args) {
        Ex08_01_Answer T = new Ex08_01_Answer();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59}, {2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}