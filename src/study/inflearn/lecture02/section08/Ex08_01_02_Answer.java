package study.inflearn.lecture02.section08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 최소 비행료 - 그래프 최단거리 : Graph
 * 2회독
 * 소요시간 : 60분
 * 틀림
 */
public class Ex08_01_02_Answer {

    /**
     *
     * @param n 도시의 개수
     * @param flights 비행기의 운항정보
     * @param s 현수가 사는 도시
     * @param e 현수가 여행을 가는 목적지 도시
     * @param k 환승 가능횟수
     * @return
     */
    public int solution(int n, int[][] flights, int s, int e, int k){
        //int answer = 0;

        // 비행기 출발-도착 운항정보 인접리스트 초기화
        /*
            ArrayList<E> 지네릭스 타입변수가 참조형 타입이므로 int[] 배열로 선언되어 있기 때문에 굳이 Integer[] 선언 안해도 됨.
         */
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>(); //✨
        /*
            0번부터 n-1번 구분하는 n개의 도시
            - 입출력 예시데이터에도 flights[]에 출발,도착이 0부터 되어 있음.
            - 그러므로 인접리스트도 맞춰서 0부터 n-1까지 생성하면 된다.
            - (틀린부분) 반복문 조건식 i < n-1로 함. n-1로 하려면 i<= n-1 하거나 i<n해도 n-1까지 적용됨.
         */
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>()); //✨
        // 비행기 출발-도착 및 비행료 초기화
        for (int[] flight : flights) graph.get(flight[0]).add(new int[]{flight[1], flight[2]});

        // i번째 도시의 최소비용
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        /*
            선언을 안해도 영향을 주진 않지만, 출발지는 비용이 0원이므로 명확하게 해주는 것이 좋다.
         */
        costs[s] = 0; //✨

        // 레벨탐색
        LinkedList<int[]> q = new LinkedList<>();
        /*
            중요
            - 출발지에서 도착지까지의 k번 환승하여 최소비용을 구하는 문제
            - 다익스트라 알고리즘의 PriorityQ 사용안하는 이유는 환승이 제한되어 있기 때문
            - 무조건 최소비용을 꺼내지 않고 출발지부터 레벨을 탐색을 하며 제한된 환승 수에서 탐색을 멈춰야한다.
         */
        q.offer(new int[]{s, 0}); //✨

        int L = 0; //✨ 출발지부터 탐색하는 거이므로 출발지의 레벨 0으로 초기화
        while (!q.isEmpty()) {
            int len = q.size(); //✨ 레발탐색 구조
            for (int i = 0; i < len; i++) { //✨ 레벨탐색 구조
                int[] cur = q.poll(); //✨ 레벨탐색 구조

                for (int[] info : graph.get(cur[0])) { // 인접리스트의 도착지의 연결도착지
                    int arrive = info[0];
                    int cost = cur[1] + info[1];
                    /*
                        costs[arrive] = Math.min(costs[arrive], cur[1] + info[1])
                        >> 사용하지 않는 이유는? 더 작을 때만 비용을 초기화해주고, 큐에 넣기 위함.
                        >> 기존비용이 변경할 비용보다 작으면 큐에 넣지 않는다. 시간복잡도 줄이기 위함.
                     */
                    if (cost < costs[arrive]) { //✨
                        costs[arrive] = cost;
                        q.offer(new int[]{arrive, cost});
                    }
                }
            }
            L++;
            if (L > k) break;
        }

        return costs[e] == Integer.MAX_VALUE? -1 : costs[e];
    }

    // 내가 푼 코드
    /*public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = Integer.MAX_VALUE;

        // 비행기 출발-도착 운항정보 인접리스트 초기화
        ArrayList<ArrayList<Integer[]>> arr = new ArrayList<>();
        for (int i = 0; i < n-1; i++) arr.add(new ArrayList<>());
        // 출발-도착 및 비행료 초기화
        for (int[] flight : flights) {
            arr.get(flight[0]).add(new Integer[]{flight[1], flight[2]});
        }

        // k번 환승해서 출발-목적지까지 최소비용
        int price = 0;

        // 출발역부터 시작
        for (int i = s; i < n; i++) {
            for (Integer[] info : arr.get(i)) {
                //price += info[1];

                for (Integer[] arrive : arr.get(info[0])) {
                    if (k == 0 && arrive[0] == k){
                        return answer;
                    }
                    //price += arrive[1];
                    answer = Math.min(answer, info[1] + arrive[1]);
                }
                k--;
            }
        }

        return answer == Integer.MAX_VALUE? -1: answer;
    }*/

    public static void main(String[] args){
        Ex08_01_02_Answer T = new Ex08_01_02_Answer();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
