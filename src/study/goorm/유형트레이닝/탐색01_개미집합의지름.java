package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 탐색01_개미집합의지름 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개미 수
        int D = Integer.parseInt(st.nextToken()); // 지름의 길이
        int[] P = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 개미 좌표

        Arrays.sort(P);

        int sum = 0;
        int result = 0;
        for (int i = 1; i < P.length; i++) {
            sum += (P[i] - P[i-1]);

            if (sum == D) {
                if (D == 0) break;
                else result = N - i - 1; break;
            }
        }

        System.out.println(result);






    }
}
