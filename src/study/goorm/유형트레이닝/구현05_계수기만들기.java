package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구현05_계수기만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // A 입력
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // B 입력
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // K 입력 : 버튼 누르는 횟수
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st2.nextToken());

        // 계수기 표시 판별
        for (int i = 0; i < K; i++) {
            if (B[N-1] + 1 > A[N-1]) { // 최대값 판별
                B[N-1] = 0; // 최솟값 0으로 초기화
                for (int j = N-2; j >= 0; j--) { // 바로 왼쪽 자리 증가
                    if (B[j] + 1 > A[j]) {
                        B[j] = 0;
                    } else if(B[j+1] == 0 && B[j] + 1 <= A[j]){
                        B[j]++;
                        break; // 최대값 판별로 왼쪽 자리들 여파인 것만 처리하고 for문 빠져나와야함.
                    }
                }
            } else {
                B[N-1]++;
            }
        }

        Arrays.stream(B).forEach(System.out::print);

    }
}
