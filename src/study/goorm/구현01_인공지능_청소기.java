package study.goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구름 - 인공지능 청소기 레벨1
 */
public class 구현01_인공지능_청소기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) { // t : TC 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x좌표
            int y = Integer.parseInt(st.nextToken()); // y좌표
            int n = Integer.parseInt(st.nextToken()); // n초

            // 총 이동 거리 (맨해튼 거리 계산)
            int distance = Math.abs(x) + Math.abs(y);

            // 조건
            if ( n >= distance && (n - distance) % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}