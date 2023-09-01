package study.inflearn.lecture02.section01;

import java.util.Arrays;

/**
 * 청소 - 시뮬레이션 & 구현
 */
public class Ex01_02_02_Answer {
    public int[] solution(int[][] board, int k){
        int n = board.length; // 방의 길이(정사각형)

        // 방향배열 시계방향(우하좌상)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        //x행 y열 시작위치, d회전방향, count움직이는 시간
        int x = 0, y = 0, d = 0, count = 0;

        //로봇이 움직이는 시간
        while (count < k) {
            count++; // 이동 하거나, 방향 변경을 해도 무조건 1초

            //로봇의 다음 위치 : 현재위치 + 이동방향
            int nx = x + dx[d];
            int ny = y + dy[d];

            //격자 밖 경우, 장애물 만났을 경우 회전
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4; // 90도 회전, 회전 하는 개수 % 반복되는 수열의 수
                continue; //회전시간 추가
            }
            // 현재위치에 다음 위치 초기화
            x = nx;
            y = ny;
        }

        // k초 후 로봇위치(좌표)
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        Ex01_02_02_Answer T = new Ex01_02_02_Answer();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
