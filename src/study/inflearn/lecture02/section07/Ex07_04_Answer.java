package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로의 최단거리 통로 - 넓이우선탐색 : BFS
 */
public class Ex07_04_Answer {
    public int solution(int[][] board){
        // 방향 배열 (인접한 4방향)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> Q = new LinkedList<>();
        int[][] dist = new int[7][7];
        Q.offer(new int[]{0, 0});
        int L = 0;

        // BFS 레벨 탐색
        while(!Q.isEmpty()){
            L++; // L레벨 먼저 증가 (자식노드 레벨)
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] p = Q.poll();
                for(int k = 0; k < 4; k++){ // 자식레벨 탐색
                    int nx=p[0]+dx[k];
                    int ny=p[1]+dy[k];
                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;
                    }
                }
            }
        }
        if(dist[6][6]==0) return -1;
        else return dist[6][6];
    }
    public static void main(String[] args){
        Ex07_04_Answer T = new Ex07_04_Answer();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
        int[][] arr2={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr2));
    }
}
