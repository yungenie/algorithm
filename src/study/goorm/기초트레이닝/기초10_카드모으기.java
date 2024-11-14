package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기초10_카드모으기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 카드 종류 체크
        boolean[] card = new boolean[N+1];

        int count = 0; // 카드를 모으는 최소 장수
        int cardUniqueCount = 0; // 카드 종류 수
        for (int i = 1; i <= M; i++) {
            int number = Integer.parseInt(br.readLine()); // 카드 번호
            // 새로운 카드 종류 모든 경우
            if (!card[number]) {
                card[number] = true;
                cardUniqueCount++;
            }
            count++;

            // 모든 카드 종류 나왔다면 종료
            if (cardUniqueCount == N) break;

        }

        // 모든 종류의 카드를 모을 수 없는 경우 -1 출력
        if (cardUniqueCount < N) count = -1;

        System.out.println(count);


    }



}
