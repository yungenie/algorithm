package study.inflearn.study;

/**
 * 재귀함수(스택프레임) - Recursive Function
 * 재귀호출 : 자기가 자기 자신을 호출하는 행위
 * 재귀함수 :
 * - 반복문의 형태이기 때문에 종료를 알려줘야 한다.
 * - 스택이라는 자료구조를 사용합니다.
 * - 물론 모든 함수가 스택을 사용해서 스택 프레임이 생깁니다.
 * - 호출되는 함수마다 스택에 프레임이 생기며, 매개변수/지역변수/복귀주소가 담깁니다.
 * - 복귀주소는 마지막 Code Line을 기록합니다.
 * - 재귀가 종료되는 시점에 마지막의 요소가 Pop()되면 그 다음에 스택에 쌓인 상단이 동작하면서 복귀주소(Line)로 돌아가 해당 메서드를 마무리합니다.
 * - 스택에 쌓인 3 -> 2 -> 1에서  1 -> 2 -> 3 거꾸로 Back Tracking을 할 수 있습니다.
 *
 */
public class RecursiveFunction {
    public void DFS(int n) {
        if (n == 0) return; // 값 반환의 의미도 있지만, 반환타입이 void 경우 함수 종료의 의미도 갖고 있다.
        else {
            DFS(n-1); // 스택 프레임에 복귀주소(Code Line) 기록합니다.
            System.out.print(n);
        }
    }

    public static void main(String[] args) {
        RecursiveFunction T = new RecursiveFunction();
        T.DFS(3);
    }

}
