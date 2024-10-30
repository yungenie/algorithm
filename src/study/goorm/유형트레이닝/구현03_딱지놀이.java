package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구현03_딱지놀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 총 라운드 개수
        for (int i = 0; i < N; i++) {

            // A 입력처리
            StringTokenizer aSt = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(aSt.nextToken()); // A 딱지개수
            int[] a = new int[5]; // 모양별 개수 저장 (index 1~4 사용)
            for (int j = 0; j < aSize; j++) {
                int shape = Integer.parseInt(aSt.nextToken());
                a[shape]++; // 모양을 인덱스로 지정해서 초기값 0에 ++
            }

            // B 입력처리
            StringTokenizer bSt = new StringTokenizer(br.readLine());
            int bSize = Integer.parseInt(bSt.nextToken()); // B 딱지개수
            int[] b = new int[5]; // 모양별 개수 저장 (index 1~4 사용)
            for (int j = 0; j < bSize; j++) {
                int shape = Integer.parseInt(bSt.nextToken());
                b[shape]++; // 모양을 인덱스로 지정해서 초기값 0에 ++
            }

            // 승자 판별
            for(int k = 4; k >= 1; k--) {
                if(a[k] > b[k]) {
                    System.out.println("A");
                    break;
                }
                else if(a[k] < b[k]) {
                    System.out.println("B");
                    break;
                }
                else if(a[k] == b[k] && k==1) {
                    System.out.println("D");
                    break;
                }
                // a[k] == b[k] continue; 조건을 안걸어도 반복문 안에 조건문이 끝나면 그 다음으로 어차피 넘어감.
            }
        }

        System.out.println("");
    }
}
