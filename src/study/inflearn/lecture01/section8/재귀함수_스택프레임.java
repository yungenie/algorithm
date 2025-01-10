package study.inflearn.lecture01.section8;

/**
 * 모든 함수가 호출되면 스택 프레임이 생김.
 * 스택에 프레임이 생김. 프레임에는 호출된 함수의 정보가 들어가 있음.
 * 매개변수, 지역변수, 복귀 주소 (함수가 종료되면 복귀해야하는 라인)
 */
public class 재귀함수_스택프레임 {

    public void DFS(int n) {
        // 기저 조건 (재귀 함수 루프에서 탈출 하는 조건)
        if (n==0) return; // 함수 종료의 의미
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        재귀함수_스택프레임 T = new 재귀함수_스택프레임();
        T.DFS(3);
    }
}
