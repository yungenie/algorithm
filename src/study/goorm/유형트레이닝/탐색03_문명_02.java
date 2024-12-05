package study.goorm.유형트레이닝;

import java.io.*;
import java.util.*;

public class 탐색03_문명_02 {

    static int N, K, count = 1, T = 0;
    static int[][] map;
    static int[] parents;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        parents = new int[K + 1];

        // 최초 발상지 초기화
        for (int i = 1; i <= K; i++) {
            parents[i] = -1;
        }

        // 최초 발상지 인접 문명 결합
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            // 실제 2차원 배열은 0부터 이므로 -1 처리.
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // 최초 발생지 표시
            map[x][y] = i; // 문명지 번호를 순차적으로 부여
            q.add(new int[]{x, y});

            // 인접 문명 결합
            for (int[] dxy : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nx = x + dxy[0];
                int ny = y + dxy[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N
                        && map[nx][ny] != 0 // 문명지 표시 여부
                        && union(map[nx][ny], map[x][y])
                ) {
                    count++; // count 의미는 문명지와 결합되는 수
                }
            }
        }

        while (count < K) {
            bfs();
            T++;
        }
        System.out.println(T);
    }

    static boolean union(int a, int b) {
        int rootA = find(a); // 인접 문명지
        int rootB = find(b); // 현재 문명지

        if (rootA == rootB) return false; // 이미 같은 그룹이므로 병합 불필요
        parents[rootB] = rootA; // 한쪽 트리를 다른 쪽 트리에 연결
        // 문명지 부여 후 인접한 문명지 있다면, 현재 문명지를 인접문명지로 변경하여 병합.
        return true; // 병합 성공
    }

    static int find(int a) {
        return parents[a] < 0 ? a : (parents[a] = find(parents[a]));
    }

    private static void bfs() {
        int size = q.size();
        for (int s = 0; s < size; s++) {
            int[] now = q.poll();

            // 문명 전파
            for (int[] dxy : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nx = now[0] + dxy[0];
                int ny = now[1] + dxy[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N
                        && map[nx][ny] == 0) {
                    map[nx][ny] = map[now[0]][now[1]];
                    q.add(new int[]{nx, ny});

                    for (int[] ddxy : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                        int tx = nx + ddxy[0];
                        int ty = ny + ddxy[1];

                        // 전파 문명지와 인근 문명지가 다르면 인근 문명지를 전파 문명지로 병합
                        if (tx >= 0 && ty >= 0 && tx < N && ty < N
                                && map[tx][ty] != 0
                                && map[nx][ny] != map[tx][ty]
                                && union(map[nx][ny], map[tx][ty])
                                ) {
                            count++;
                        }
                    }
                }
            }
        }
    }

}
