package study.inflearn;

/**
 * 잃어버린 강아지 - 시뮬레이션 & 구현
 *
 * 문제 포인트 : 행열이 이동하면서 회전 방향에 따른 행열의 위치 변환 및 강아지/현수 각각 움직임 (회전 방향은 시계 방향)
 */
public class Ex01_03_Answer {
    public int solution(int[][] board){
        int boardSize = board.length;

        //시계 방향에 따른 행열의 이동
        //
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 현수와 강아지 시작 위치 - 이중 for문 탐색
        int hx = 0, hy = 0, px = 0, py = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
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

            // 현수와 강아지 회전 - 지도 끝에 이르거나, 나무를 만났을 경우 회전
            // 회전의 유무
            boolean flag1 = false, flag2 = false;
            if (hnx < 0 || hny < 0 || hnx >= boardSize || hny >= boardSize || board[hnx][hny] == 1) {
                //시계방향으로 90도 회전 (이동하려는 방향 선택, 이동하진 않음)
                hd = (hd + 1) % 4; //회전 하는 누적 수 % 반복되는 수열의 수
                flag1 = true; //2번문제처럼 continue; 하게 되면 뒤에 조건식 계산을 못하게 되므로 flag 값을 둬 처리하는 것임
            }
            if (pnx < 0 || pny < 0 || pnx >= boardSize || pny >= boardSize || board[pnx][pny] == 1) {
                pd = (pd + 1) % 4;
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
        if (count >= 10000) return 0;
        return count;
    }

    public static void main(String[] args){
        Ex01_03_Answer T = new Ex01_03_Answer();
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

/*
 * 변수 간단하게 지정하기.
 * 문제 풀이에 집중.
 * 충분히 말로 설명할 수 있다.
 * 그리고 추가적으로 코드 정리해서 메일로 보내면 된다.
 *
 */