package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로의 최단거리 통로 - 넓이우선탐색 : BFS
 */
public class Ex07_04_03_Answer {
    public int solution(int[][] board){
        int[][] dist = new int[7][7]; // 출발지점에서 거리를 계산하는 배열 (이동횟수)
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0}); //출발지점

        int L = 0;
        while(!Q.isEmpty()){ // BFS 레벨 탐색
            // 2차원 배열에서 최단 거리를 구할 때 먼저 증가.
            L++; // L레벨 먼저 증가 (자식노드 레벨) L 값을 미리 증가
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                // 자식레벨 탐색
                for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향 배열 (인접한 4방향)
                    int nx= cur[0] + dir[0];
                    int ny= cur[1] + dir[1];
                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
                        board[nx][ny] = 1; // 방문한 지점 벽으로 만들기, 움직이는 대상이 1명 뿐이라서 가능
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L; // 레벨 저장(이동횟수)
                    }
                }
            }
        }
        // 도착지점 반환
        if(dist[6][6]==0) return -1;
        else return dist[6][6];
    }
    public static void main(String[] args){
        /*
            문제 : 격자판에서의 출발지점에서 도착지점까지 가는 최단경로의 길이(최소 이동횟수)
                    *이해하기 쉽게 버스 최소 환승 횟수랑 비슷하게 생각하기 (몇번 만에 도착지점으로 갈 수 있는 지)
            움직이는 생명 : 1명
            도착지점 : 고정
            가중치 : 방향배열 상하좌우

            문제해독
                - 출발점 (1,1), 도착점(7,7)로 주어져도 board를 보면 0~6행으로 구성되어 있음.
         */
        Ex07_04_03_Answer T = new Ex07_04_03_Answer();
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
