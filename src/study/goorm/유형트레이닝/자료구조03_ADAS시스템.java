package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 자료구조03_ADAS시스템 {

    public static PriorityQueue<int[]> pq;
    public static String[][] road;
    public static int W, H; // todo final ?

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        boolean[][] visited = new boolean[W][H];
        road = new String[W][H];
        for (int i = 0; i < W; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                road[i][j] = String.valueOf(str.charAt(j));
                if (str.charAt(j) == 'S') {
                    pq.add(new int[]{i, j});
                    visited[i][j] = false;
                }
            }
        }

        int dangerScore = 0;

        while (true) { // todo 조건.?
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];

            if (road[x][y].equals("0")) {
                // 위험 점수 - 내 위치 3*3내에서 P 개수
                dangerScore += dangerCount(x, y);
            } else if (road[x][y].equals("P")) {
                // 위험 점수 - 내 위치 3*3내에서 P 개수 - 3
                dangerScore += dangerCount(x, y) - 3;
            } else if (road[x][y].equals("E")) {
                break;
            }

            for (int[] dxy: new int[][]{{-1, 0}, {0, -1},{1, 0}, {0, 1}}) {
                int nx = x + dxy[0];
                int ny = y + dxy[1];

                if (nx >= 0 && ny >= 0 && nx < W && ny < H && !visited[nx][ny]) {
                    pq.offer(new int[]{nx, ny});
                    visited[nx][ny] = false;
                }
            }
        }
        System.out.println(dangerScore);

    }

    //
    static int dangerCount(int x, int y) {
        int count = 0;
        for (int[] dxy: new int[][]{{-1, 0}, {0, -1},{1, 0}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1,1}}) {
            int nx = x + dxy[0];
            int ny = y + dxy[1];

            if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                if (road[nx][ny].equals("P")) {
                    count++;
                }
            }
        }

        return count;
    }

}
