package study.inflearn.lecture01.section3;

import java.util.Scanner;


public class Ex03_03_가위바위보_답 {

    /*
    1 가위
    2 바위
    3 보

    1 2 2승 3
    1 3 1승 4
    2 3 3승 5
    1 1
    2 2
    3 3
     */
    public String solution(int n, int[] a, int[] b){
        String answer = "";

        // 기준이 A가 이기는 경우를 if 조건문으로 판별
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer += "D"; // 비기는 경우
            else if (a[i] == 1 && b[i] == 3) answer += "A"; // 가위 vs 보
            else if (a[i] == 2 && b[i] == 1) answer += "A"; // 바위 vs 가위
            else if (a[i] == 3 && b[i] == 2) answer += "A"; // 보 vs 바위
            else answer += "B";
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex03_03_가위바위보_답 T = new Ex03_03_가위바위보_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (char x : T.solution(n, a, b).toCharArray()) {
            System.out.println(x);
        }
    }
}
