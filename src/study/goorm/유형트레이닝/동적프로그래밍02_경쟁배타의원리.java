package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동적프로그래밍02_경쟁배타의원리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 메타버스에 사는 N개 생물 수
        int K = Integer.parseInt(st.nextToken()); // K는 경쟁이 일어나는 종의 수

        int[][] board = new int[1001][1001]; // 최대 크기 : 1000까지 꼭짓점 좌표 포함으로 1001 초기화
        int minX = 1001, minY = 1001, maxX = 0, maxY = 0;

        // 입력 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 2D 누적 합을 위한 값 설정
            board[y1][x1]++;
            board[y2][x2]++;
            board[y1][x2]--;
            board[y2][x1]--;

            // 최소/최대 범위 갱신
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
        }

        // 열 방향으로 누적 합 계산
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX + 1; j <= maxX; j++) {
                board[i][j] += board[i][j - 1];
            }
        }

        // 행 방향으로 누적 합 계산
        for (int j = minX; j <= maxX; j++) {
            for (int i = minY + 1; i <= maxY; i++) {
                board[i][j] += board[i - 1][j];
            }
        }

        // 조건에 맞는 영역 개수 계산
        int ans = 0;
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                if (board[i][j] == K) {
                    ans++;
                }
            }
        }

        // 결과 출력
        System.out.println(ans);



    }
}
