package study.inflearn.lecture01.section4;

import java.util.Scanner;

/**
 * 연속된 자연수는 n를 2로 나눈 몫과 몫의 + 1 까지의 큰 숫자까지만 합하면 된다.
 * (단, 1씩 증감하는 자연수이기때문에 가능함.)
 */
public class Ex04_05_연속된자연수의합_답 {

    public int solution(int n) {
        int answer = 0;

        int m = n/2 + 1;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = i+1;

        int sum = 0, lt = 0;
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) answer++;
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Ex04_05_연속된자연수의합_답 T = new Ex04_05_연속된자연수의합_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}

