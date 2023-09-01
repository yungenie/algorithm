package study.inflearn.lecture02.section01;

import java.util.Arrays;

/**
 * 좌석번호 - 시뮬레이션 & 구현 (2회독 성공)
 */
public class Ex01_04_02 {
    public int[] solution(int c, int r, int k){
        // k번째분 좌석번호 초기화
        int[] answer = new int[2];

        // 방향배열 (시계방향)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 좌석번호 초기화 배열
        int[][] placeChk = new int[c][r];
        // 현재 행, 열, 방향, 좌석번호, 전체좌석 개수
        int x = 0, y = 0, d = 0, cnt = 1, limitCnt = c*r;

        // k번째 좌석번호 찾기
        while (cnt <= limitCnt && limitCnt >= k) {
            placeChk[x][y] = cnt; // 좌석번호 셋팅

            // 다음 좌석 배치 (다음좌석 = 현재좌석 + 방향)
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 좌석배치 범위 밖 or 이미 배치된 좌석
            if (nx < 0 || ny < 0 || nx >= c || ny >= r || placeChk[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            // 현재좌석 업데이트
            x = nx;
            y = ny;
            cnt++; // 좌석번호 배분

            // k번째분 좌석 반환
            if (k == cnt) return new int[]{x+1, y+1};
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_04_02 T = new Ex01_04_02();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
