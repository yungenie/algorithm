package study.inflearn.lecture02.section08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 최소 환승 경로 - 그래프 최단거리 : Graph
 */
public class Ex08_02_03_Answer {
    public int solution(int[][] routes, int s, int e){

        // 역에 대한 지하철 호선들 해싱
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length; // 전체 호선
        for (int i = 0; i < n; i++) {// 전체 호선에 대한 역탐색
            for (int route : routes[i]) { // 역
                graph.putIfAbsent(route, new HashSet<>());
                graph.get(route).add(i); // 역, {호선들} 예를들어 1역:{1호선, 2호선}
            }
        }
        // 지하철 호선 체크
        int[] ch = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(s); // 출발역

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int curStaion = q.poll(); // 출발역
                for (Integer line : graph.get(curStaion)) { //출발역에서 환승 가능한 호선들
                    if (ch[line] == 1) continue;
                    ch[line] = 1;
                    for (int station : routes[line]) {
                        if (station == e) return L; // 도착역 탐색
                        q.offer(station); // 환승 가능한 호선에 있는 역 넣기
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args){
        Ex08_02_03_Answer T = new Ex08_02_03_Answer();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
