package study.inflearn.lecture01.section8;

import java.util.Scanner;

public class Ex08_02_재귀함수_이진수출력 {

    public void DFS(int N) {
        // 기저 조건
        if (N == 0) return;
        else {
            DFS(N / 2);
            System.out.print(N % 2);
        }
    }

    public static void main(String[] args) throws Exception {
        Ex08_02_재귀함수_이진수출력 T = new Ex08_02_재귀함수_이진수출력();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        T.DFS(N);
    }
}
