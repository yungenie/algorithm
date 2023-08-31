package study.inflearn.lecture02.section08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 최소 비행료 - 그래프 최단거리 : Graph
 */
public class Ex08_01_03_Answer {
    public int solution(int n, int[][] flights, int s, int e, int k) {
        int answer = -1;

        // 인접리스트 - 행 : 도시, 열 : {목적지,비용}
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]}); // {목적지, 비용}
        }

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[s] = 0; // 출발도시 비용 0으로 초기화

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0}); // {출발지, 비용}

        int L = 0;
        while (!q.isEmpty()){
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();
                int curPlace = cur[0]; //출발지
                int curCost = cur[1]; //출발지 비용
                for (int[] info : graph.get(curPlace)) { // 목적지 도시 탐색
                    int nextPlace = info[0]; // 목적지
                    int nextCost = info[1]; // 목적지 비용
                    int cost = curCost + nextCost; // 출발지에서 목적지까지 비용
                    if (costs[nextPlace] > cost) { // 기존비용 > 출발지에서 목적지까지 비용
                        costs[nextPlace] = cost; // 최소비용을 찾는 문제이므로, 더 저렴한 비용을 선택
                        q.offer(new int[]{nextPlace, cost}); //목적지, 비용
                    }
                }
            }
            if (L > k) break; // 최소 환승 횟수 (레벨은 0부터 시작하는 것을 생각하기)
        }
        // 현수가 목적지까지 갈 수 없으면 비용은 최대로 초기화 되어 있기 때문에 아래 조건으로 처리
        return costs[e] == Integer.MAX_VALUE ? answer : costs[e];
    }

    public static void main(String[] args) {
        /*
            문제 : 현수가 사는 동네에서 목적지까지 가는데 최소비용
            n 도시, 출발s -> 도착e, 직항 없으면 환승 가능 (k번 가능)
         */
        Ex08_01_03_Answer T = new Ex08_01_03_Answer();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59}, {2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}