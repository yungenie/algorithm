package study.programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 20분 소요 (정답!)
 */
public class Level2_게임맵최단거리 {

    // 최단거리 칸의 수 최소값 (최소 이동 횟수)
    public int solution(int[][] maps) {
        int n = maps.length; // 행
        int m = maps[0].length; // 열
        int[][] dist = new int[n][m]; // 최단거리 이동횟수 배열
        Queue<int[]> q = new LinkedList<>(); // 이동지점 BFS
        q.offer(new int[]{0, 0}); // 출발지점

        // 최단거리 BFS
        int L = 1;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                // 동, 서, 남, 북 방향 이동
                for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                    int nx = cur[0] + dir[0]; // 이동 하는 행
                    int ny = cur[1] + dir[1]; // 이동 하는 열

                    // 유효한 지점이면서 방문하지 않은 지점인 경우 이동 (0 : 벽, 1 : 벽 없는 길)
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1){
                        maps[nx][ny] = 0; // 이동 하는 행열 벽으로 만들기 (방문 지점 기록)
                        q.offer(new int[]{nx, ny}); // 다음 지점 저장
                        dist[nx][ny] = L; // 이동 횟수 저장 (depth)
                    }
                }
            }
        }

        // 상대팀 진영 (도착지점)
        if (dist[n-1][m-1] == 0) return -1; // 미도착
        else return dist[n - 1][m - 1]; // 도착
    }

    public static void main(String[] args) {
        Level2_게임맵최단거리 T = new Level2_게임맵최단거리();
        System.out.println(T.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(T.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));

    }
}
