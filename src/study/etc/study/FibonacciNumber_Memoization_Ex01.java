package study.etc.study;

/**
 * 피보나치 수 - 메모이제이션
 * 피보나치 : 일련의 숫자로 다음 숫자를 찾기 위해 앞의 두 숫자의 합계를 사용하여 구성됩니다.
 *
 * 피보나치 재귀(for) vs 메모이제이션(배열) 성능 비교
 * 배열로도 재귀로도 짜보라고 한다. 2개 성능 비교 시킨다.
 * 배열하고 for문으로 사용하는 게 훨씬 낫다.
 * 재귀는 스택 프레임이 돌아가니깐요. 메모리 낭비도 많이 나고 무겁습니다. 성능이 더 나쁩니다.
 */
public class FibonacciNumber_Memoization_Ex01 {

    static int[] fibo;
    public int DFS(int n){ // n은 항의 번호
        if (fibo[n] > 0) return fibo[0];
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }
    public static void main(String[] args){
        FibonacciNumber_Memoization_Ex01 T = new FibonacciNumber_Memoization_Ex01();
        int n = 10;
        fibo = new int[n + 1]; // 인덱스 항이 n 번이 필요해서 n + 1로 해야합니다. 0~n번 인덱스
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
