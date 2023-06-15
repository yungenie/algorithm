package study.inflearn.study;

import java.util.Scanner;

/**
 * 메모이제이션(memoization) - 조합수 (DFS)
 * 조합의 수 : nCr = n-1Cr-1 + n-1Cr
 * 컴퓨터 프로그램이 동일한 계산을 반복해야 할 때,
 * 이전에 계산한 값을 메모리에 저장함으로써
 * 동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 하는 기술이다.
 * 동적 계획법의 핵심이 되는 기술이다.
 */
public class Memoization {
    int[][] dy=new int[35][35]; // 메모이제이션(피보나치), 시간복잡도 줄이기 위해서
    public int DFS(int n, int r){
        if(dy[n][r] > 0) return dy[n][r]; // 메모이제이션, 이미 구한 경우의 수 반환

        // nCr 조합의 수
        if(n == r || r == 0) return 1; // 재귀의 종착점, r == 0 : 조합에서는 빈집합도 하나의 경우의 수로 봄 (부분집합)
        else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
    public static void main(String[] args){
        Memoization T = new Memoization();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int r=kb.nextInt();
        System.out.println(T.DFS(n, r));
    }
}
