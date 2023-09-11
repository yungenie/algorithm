package study.programmers.graph;

public class Level3_순위_Answer {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n][n];
        for (int[] node : results) {
            graph[node[0]-1][node[1]-1] = 1; // win
            graph[node[1]-1][node[0]-1] = -1; // lose
        }

        for (int k = 0; k < n; k++) { // 경유지
            for (int s = 0; s < n ; s++) { // 출발
                for (int e = 0; e < n; e++) {  // 도착
                    if (graph[s][k] == 1 && graph[k][e] == 1) {
                        graph[s][e] = 1; // 출발노드가 도착노드를 이긴다.
                        graph[e][s] = -1;  // 도착노드는 출발도느에게 진다.
                    }
                    if (graph[s][k] == -1 && graph[k][e] == -1) {
                        graph[s][e] = -1; // 출발노드는 도착노드에게 진다.
                        graph[e][s] = 1; // 도착노드는 출발노드를 이긴다.
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] !=0) count++; // 자기자신은 제외
            }
            if (count == n-1) answer++; // 자기자신을 제외하고 게임의 결과가 있다는 뜻.
        }

        return answer;
    }
    public static void main(String[] args) {
        Level3_순위_Answer T = new Level3_순위_Answer();
        System.out.println(T.solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));
    }
}
