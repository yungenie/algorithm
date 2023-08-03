package study.inflearn.lecture02.section01;

import java.util.Arrays;

/**
 * 사다리 타기 - 시뮬레이션 & 구현
 */
public class Ex01_01_02_Answer {
    public char[] solution(int n, int[][] ladder){
        /*
            ✨ 1차원 사다리타기 문제가 나왔을 경우 배열의 교환이라고 외우기!
            - 사다리타기는 한명씩 움직임을 생각하지 말고, 동시에 탄다고 생각해야한다.
            - 가로줄의 순서대로 가로막대 위치에 해당하는 각 요소와 자리 교환
            - 입력 예제 1번으로 설명
                n : 5, 막대정보 : {1, 3}, {2, 4}, {1, 4}
                막대정보 의미는 {1, 3} 일 때 1번과 2번 사다리 형성, 3번과 4번 사다리 형성
                1번에 해당하는 학생은 결국 2번으로 이동하게 된다. 3번 학생은 4번으로 이동하게 된다.
                이동의 과정을 교환으로 처리한다.

                학생 정보 배열 A B C D E
                  가로막대0    -   -
                  가로막대1      -   -
                  가로막대2    -     -

                  가로막대0일 때 자리 교환  B A D C E
                  가로막대1일 때 자리 교환  B D A E C
                  가로막대2일 때 자리 교환  D B A C E
         */

        // 각 학생의 알파벳 대문자로 초기화
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char)(i + 65);
        }

        // 가로줄의 순서대로 가로막대 위치에 해당하는 각 요소와 자리 교환
        for (int[] line : ladder) { // i번째 가로줄 탐색
            for (int x : line) { // i번째 가로줄 중 가로막대들 탐색
                char tmp = answer[x];
                answer[x] = answer[x-1];
                answer[x-1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_01_02_Answer T = new Ex01_01_02_Answer();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
