package study.programmers.dfs_bfs;

public class Level3_네트워크 {
    int n;
    int[][] computers;
    boolean[] visited;

    public void DFS(int start) {
        visited[start] = true; // 탐색한 노드 체크
        for (int j = 0; j < n ; j++) { // 연결 노드 확인
            if (start != j && !visited[j] && computers[start][j] == 1) { // 연결 노드 중 탐색하지 않은 노드만 탐색하기
                DFS(j);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        this.visited  = new boolean[n]; // 탐색한 노드(컴퓨터) 체크 배열

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 첫 방문인 경우
                DFS(i);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Level3_네트워크 T = new Level3_네트워크();
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
