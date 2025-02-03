package study.inflearn.lecture01.section4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex04_01_두배열합치기_답 {

    public ArrayList<Integer> solution(int n, int m, int[] nArr, int[] mArr){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        // 투 포인트 알고리즘
        // 2개의 배열 중에 하나의 배열이 탐색 끝나면 while문 탈출
        while (p1 < n && p2 < m) {
            if (nArr[p1] < mArr[p2]) answer.add(nArr[p1++]); // 후위 증감 연산자
            else answer.add(mArr[p2++]);
        }
        // 남은 배열 처리
        while (p1 < n) answer.add(nArr[p1++]);
        while (p2 < m) answer.add(mArr[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        Ex04_01_두배열합치기_답 T = new Ex04_01_두배열합치기_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }

        for (int x :  T.solution(n, m, nArr, mArr)) System.out.print(x + " ");
    }
}
