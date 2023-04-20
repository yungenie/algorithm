package study.inflearn;

import java.util.Arrays;

/**
 * 청소 - 시뮬레이션 & 구현
 *
 * 문제 포인트 : 행열이 이동하면서 회전 방향에 따른 행열의 위치 변환 (회전 방향은 시계 방향)
 *
 */

public class Ex02_02_Answer {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int n = board.length;

        //시계 방향에 따른 행열의 이동
        //int[] dx = {-1, 0, 1, 0};
        //int[] dy = {0, 1, 0, -1};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};


        //x행 y열 시작위치, d회전시간, count반복문증감 변수 초기화
        //int x = 0, y = 0, d = 0, count = 0;
        int x = 0, y = 0, d = 0, count = 0;

        //로봇이 움직이는 시간
        while (count < k) {
            count++;
            //로봇의 이동 : x행 y열 현재위치 + 행열의 이동하는 방향에 따른 배열
            int nx = x + dx[d];
            int ny = y + dy[d];

            //격자 밖 경우(지도 끝 더 이상 전진 할 수 없는), 장애물 만났을 경우 회전
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                //시계방향으로 90도 회전 (이동하려는 방향 선택, 이동하진 않음)
                d = (d + 1) % 4; //회전 하는 누적 수 % 반복되는 수열의 수
                //회전시간 추가
                continue;
            }
            x = nx;
            y = ny;
            System.out.printf("count=%d, (x, y)=(%d, %d), d=%d \n",count, x,y,d);

        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        Ex02_02_Answer T = new Ex02_02_Answer();
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

/*
행열과 좌표를 헷갈려했다..

 */