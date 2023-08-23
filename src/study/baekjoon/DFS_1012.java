package study.baekjoon;

import java.util.Scanner;

/**
 * 1012 유기농 배추
 * https://www.acmicpc.net/problem/1012
 */
public class DFS_1012 {

    static int T, N, M, K;
    static int[][] map;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void DFS(int x, int y) {
        map[x][y] = 0;
        for (int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[nx][ny] == 1){
                DFS(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        /*
            가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
            그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
            그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
            >> 문제에서 가로 세로 헷갈리게 주어짐
         */
        for (int i = 0; i < T; i++) {
            M = sc.nextInt(); // 가로 (열)
            N = sc.nextInt(); // 세로 (행)
            K = sc.nextInt();

            map = new int[N + 2][M + 2];
            for (int j = 0; j < K; j++) {
                int y = sc.nextInt(); // 열
                int x = sc.nextInt(); // 행
                map[x+1][y+1] = 1; // ✨ 입력 받을 때에 열 변수, 행 변수에 받기!
            }
            int answer = 0;
            for (int xi = 1; xi <= N ; xi++) { // 행
                for (int yj = 1; yj <= M; yj++) { // 열
                    /*
                        정답 도출 : 묶음으로 처리하기
                        ✨ 배추가 1일 때 상하좌우 주변으로 배추가 있으면 0으로 만들어버림.
                        그 다음 탐색 할 때 이미 0으로 배추가 바껴 있어서, 인접한 배추 묶음이 되어 1 값만 얻을 수 있고
                        이중 반복문으로 그 다음 배추 묶음을 찾아서 또 인접한 배추는 0으로 변경해주는 로직을 반복한다.
                     */
                    if (map[xi][yj] == 1) {
                        answer++;
                        DFS(xi, yj);
                    }
                }
            }

            System.out.println(answer);

        }
    }
}

/*
1. 알고리즘 유형
인접한 다른 배추로 이동 -> DFS
상하좌우 -> 행열배열 사용

2. 서로 연결되었다는 정보를 어떻게 하나의 자료구조로 통합할까?
2차원 배열 vs ArrayList vs 저장된 배열 사용

3. 이미 방문한 지점을 다시 방문하지 않으려면 어떤 자료구조를 사용해야 될까?
1차원 배열 vs 2차원 배열 등
 */