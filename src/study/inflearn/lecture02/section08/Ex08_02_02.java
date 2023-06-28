package study.inflearn.lecture02.section08;

import java.util.*;

/**
 * 최소 환승 경로 - 그래프 최단거리 : Graph
 * 강사님 해법 및 정답코드 보면서 리팩토리
 */
public class Ex08_02_02 {
    public int solution(int[][] routes, int s, int e){
        //int answer = 0;
        int n = routes.length;
        int[] ch = new int[n];

        // 지하철 역번호 - 호선 해싱
        Map<Integer, HashSet<Integer>> stMap = new HashMap<>(); // st : station
        for (int i = 0; i < n; i++) {
            // note 향샹된 반복문과 map.putIfAbsend() 메서드로 리팩토리
            /*
            for (int j = 0; j < routes[i].length; j++) {
                HashSet<Integer> line = stMap.getOrDefault(routes[i][j], new HashSet<>());
                line.add(i);
                stMap.put(routes[i][j], line);
            }*/
            for (int station : routes[i]) {
                stMap.putIfAbsent(station, new HashSet<>());
                stMap.get(station).add(i);
            }
        }

        // 레벨탐색
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        //ch[0] = 1; // error 아직 지하철 호선 안탐
        int L = 0;
        while (!Q.isEmpty()){
            int Qlen = Q.size();
            for (int i = 0; i < Qlen; i++) {
                int cur = Q.poll();
                if (cur == e) return L - 1;

                // note 로직 리팩토리
                /*
                HashSet<Integer> curLines = stMap.get(cur);
                for (Integer curLine : curLines) {
                    if (ch[curLine] == 1) continue;
                    else {
                        // 호선 체크
                        ch[curLine] = 1;

                        // 자식레벨 탐색
                        for (int j = 0; j < routes[curLine].length; j++) {
                            if (routes[curLine][j] == e) return L; // error
                            Q.offer(routes[curLine][j]);
                        }
                    }
                }*/

                for (Integer line : stMap.get(cur)) {
                    if (ch[line] == 1) continue;
                    else {
                        // 호선 체크
                        ch[line] = 1;

                        // 자식레벨 탐색
                        for (int x : routes[line]) {
                            //if (x == e) return L;
                            Q.offer(x);
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Ex08_02_02 T = new Ex08_02_02();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
