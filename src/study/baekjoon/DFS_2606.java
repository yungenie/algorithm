package study.baekjoon;

import java.util.Scanner;

/**
 * 2606 바이러스 문제
 * https://www.acmicpc.net/problem/2606
 */
public class DFS_2606 {
    static int n;
    static int[][] graph;
    static int[] ch;
    static int answer;

    /**
     * 행에 대한 열을 탐색
     * 방문하지 않았고, 연결 정보가 있는 경우만 재귀함수 탐색하면서 방문지점 카운팅
     * @param start graph 행번호
     */
    public static void DFS(int start) {
        ch[start] = 1; // 행 방문 체크
        answer++;
        for (int i = 1; i <= n ; i++) { // grapy 열번호
            if (ch[i] == 0 && graph[start][i] == 1) { // 모든 열에 대한 방문 여부 확인
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 2차원 배열 graph에 연결 정보 채우기 (1: 연결, 0: 비연결)
        graph = new int[n + 1][n + 1];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        // 1차원 배열 ch에 방문 체크 정의
        ch = new int[n + 1];

        // DFS 재귀함수 호출
        DFS(1); // 컴퓨터는 1번부터 번호가 매겨지므로 1부터 시작.

        System.out.println(answer-1);
    }
}
