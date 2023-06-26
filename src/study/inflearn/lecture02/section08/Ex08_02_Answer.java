package study.inflearn.lecture02.section08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 최소 환승 경로 - 그래프 최단거리 : Graph
 */
public class Ex08_02_Answer {
    public int solution(int[][] routes, int s, int e){
        // 역에 대한 지하철호선 해싱
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;
        for(int i = 0; i < n; i++){
            for(int x : routes[i]){
                graph.putIfAbsent(x, new HashSet<Integer>()); // key가 존재하지 않을 때 putIfAbsend()가 작동하고, value에 대응하는 key를 생성한다.
                graph.get(x).add(i);
            }
        }

        // 레벨탐색
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s); // 역번호
        int[] ch = new int[n]; // 지하철호선 체크
        int L = 0; // 환승횟수가 레벨로 대응
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                // 역번호
                int curStop = Q.poll();
                // 역에 대한 호선 탐색
                for(int line : graph.get(curStop)){
                    if(ch[line] == 1) continue;
                    ch[line] = 1;
                    for(int stop : routes[line]){
                        if(stop == e) return L;
                        Q.offer(stop);
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args){
        Ex08_02_Answer T = new Ex08_02_Answer();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }

}
