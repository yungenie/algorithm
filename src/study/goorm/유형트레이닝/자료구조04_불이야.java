package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 자료구조04_불이야 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * & 구름 위치
         * @ 불길 시작
         * # 벽
         * . 빈칸
         * 불 번짐 : 1초에 사방으로 1칸 번져.
         * 구름 위치까지 불길이 안번지면 -1
         *
         * C가 1000임. 무슨 자료구조를 쓰라는 걸까.. 큐?
         */

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();

        // 연구실
        String[][] array = new String[R][C];
        for (int i = 0; i < R; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < C; j++) {
                String info = String.valueOf(readLine.charAt(j));
                array[i][j] = info;
                if(info.equals("@")) {
                    visited[i][j] = true;
                    q.add(new int[]{0, i, j});
                } else if(info.equals("#")){
                    visited[i][j] = true;
                }
            }

        }
        // 불길 번짐 체크
        int count = 0;
        boolean find = false;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowCount = now[0];
            int x = now[1];
            int y = now[2];
            int nextCount = nowCount + 1; // todo

            for (int[] dxy: new int[][]{{-1, 0}, {0, -1},{1, 0}, {0, 1}}) {
                int nx = x + dxy[0];
                int ny = y + dxy[1];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny]) {
                    if (array[nx][ny].equals("&")) { // todo
                        count = nowCount;
                        find = true;
                        break;
                    }
                    q.add(new int[]{nextCount, nx, ny});
                    visited[nx][ny] = true;
                }
            }

            if (find) break;

        }


        if (!find) count = -1;

        System.out.println(count);


    }
}
