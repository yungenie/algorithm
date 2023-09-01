package study.inflearn.lecture02.section01;

/**
 * 잃어버린 강아지 - 시뮬레이션 & 구현
 */
public class Ex01_03_02_Answer {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;

        //시계 방향에 따른 행열의 이동
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 현수와 강아지 시작 위치
        int hx = 0, hy = 0, px = 0, py = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    hx = i;
                    hy = j;
                }else if (board[i][j] == 3) {
                    px = i;
                    py = j;
                }
            }
        }

        // 몇 분 후에 현수와 강아지를 찾는 지 구하기
        int count = 0, hd = 0, pd = 0;
        while (count < 10000) {
            count++;
            // 현수 다음 위치 : 현재 위치 + 회전 방향
            int hnx = hx + dx[hd];
            int hny = hy + dy[hd];
            // 강아지 다음 위치 : 현재 위치 + 회전 방향
            int pnx = px + dx[pd];
            int pny = py + dy[pd];

            // 현수와 강아지 회전 - 나무나 지도 끝에 이르면 회전
            boolean flag1 = false, flag2 = false; // 회전의 유무
            if (board[hnx][hny] == 1 || hnx < 0 || hny < 0 || hnx >= n || hny >= n) {
                hd = (hd + 1) % 4; // 90도 회전, 회전 하는 개수 % 반복되는 수열의 수
                flag1 = true;
            }
            if ( board[pnx][pny] == 1 || pnx < 0 || pny < 0 || pnx >= n || pny >= n) {
                pd = (pd + 1) % 4; // 90도 회전, 회전 하는 개수 % 반복되는 수열의 수
                flag2 = true;
            }

            // 현수와 강아지 이동 - 회전유무에 따라 이동
            if (flag1 == false) {
                hx = hnx;
                hy = hny;
            }
            if (flag2 == false) {
                px = pnx;
                py = pny;
            }
            // 현수와 강아지 만남
            if (hx == px && hy == py) break;

        }
        return count >= 10000? answer : count;
    }

    public static void main(String[] args){
        Ex01_03_02_Answer T = new Ex01_03_02_Answer();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }

}
