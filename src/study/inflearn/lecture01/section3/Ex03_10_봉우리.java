package study.inflearn.lecture01.section3;

import java.util.Scanner;

/**
 * 정답.
 * 30분 소요
 */
public class Ex03_10_봉우리 {

    public int solution(int n, int[][] map) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int now = map[i][j];
                int smallCnt = 0;
                for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향배열 상하좌우
                    int nx = i + dir[0]; // 이동하는 행좌표
                    int ny = j + dir[1]; // 이동하는 열좌표
                    if (nx >= 0 && nx < n && ny >=0 && ny < n) { // 지도 범위 넘어가지 않게, 움직일 수 없는 곳을 제외
                        if(now > map[nx][ny]){
                            smallCnt++;
                        }
                    } else {
                        smallCnt++;
                    }
                }
                if (smallCnt == 4) {
                    count++;
                    smallCnt = 0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Ex03_10_봉우리 T = new Ex03_10_봉우리();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, map));
    }
}
