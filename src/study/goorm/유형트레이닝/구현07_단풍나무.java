package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 구현07_단풍나무 {
    static int N;
    static int[][] graph;
    static boolean[][] visited; // 물든 구역 주변 마이너스 처리 완료 : true, 미처리 : false
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // BFS 탐색 메서드
    public static void bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true; // 탐색 큐에 넣고 체크

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny] == false) {
                    if (graph[nx][ny] == 0) { // 인접구역 살펴봤는데 물든 지역이면 큐에 넣어.
                        // 물든 구역
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true; // 큐에 미리 넣어. 시간 단축을 위한 처리.
                    } else { // 인접구역 살펴봤는데 아직 물들지 않았어. 그러면 --하고 뺐을때 0인 경우 다음날 물들 수 있게 처리.
                        // 인접 구역의 단풍나무 수 감소
                        graph[nx][ny]--;
                        if (graph[nx][ny] == 0) {
                            graph[nx][ny] = -1;
                            // 0이면 바로 물든 구역으로 되버리니깐, 아직 남은 인접한 구역 처리를 위해서 음수로 처리하고, 하루가 끝나면 물든 구역으로 표시
                        }
                    }
                }
            }
        }
    }

    // 구름공원의 모든 구역이 물들었는지 확인하는 메서드
    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // 새롭게 물든 구역을 0으로 변경
    public static void color() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] < 0) {
                    graph[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        // 구름공원 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;

        // 모든 구역이 물들 때까지 반복
        while (check()) {
            visited = new boolean[N][N];
            // 단풍나무가 물든 구역을 기준으로 BFS 실행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 0 && visited[i][j] == false) {
                        bfs(i, j);
                    }
                }
            }
            color(); // 새롭게 물든 구역을 0으로 갱신
            days++;
        }

        System.out.println(days);
    }
}
