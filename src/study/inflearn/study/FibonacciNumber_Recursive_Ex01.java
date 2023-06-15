package study.inflearn.study;

/**
 * 피보나치 수 - 재귀
 * 피보나치 : 일련의 숫자로 다음 숫자를 찾기 위해 앞의 두 숫자의 합계를 사용하여 구성됩니다.
 */
public class FibonacciNumber_Recursive_Ex01 {
    public int DFS(int n){ // n은 항의 번호
        if(n==1) return 1; // 첫번째 항은 1 반환
        else if(n==2) return 1; // 두번째 항도 1반환
        else return DFS(n-2) + DFS(n-1); // 세번째 항부터 앞 2개의 항 합산
    }
    public static void main(String[] args){
        FibonacciNumber_Recursive_Ex01 T = new FibonacciNumber_Recursive_Ex01();
        int n = 10;
        for(int i=1; i<n; i++) System.out.print(T.DFS(i)+" ");
    }
}
