package study.inflearn.lecture02.section01;

import java.util.Arrays;

/**
 * 사다리 타기 - 시뮬레이션 & 구현
 *
 * 문제 포인트 : 객체가 이동하는 것을 코드로 표현하는 문제 (간단하게 시뮬레이션으로 배열을 통해서 해결합니다)
 *
 *  DFS 깊이 우선 탐색 x
 * 1. N개 만큼 알파벳 문자를 char[] 배열에 저장합니다.
 * 2. 가로줄 탐색
 * 3. 가로막대탐색
 *
 */
public class Ex01_01_Answer {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        //1차원 배열 셋팅 - n명의 학생수만큼 알파벳 대문자 순서
        for (int i = 0; i < n; i++) {
            answer[i] = (char)(i + 65); //숫자를 알파벳으로 casting, ASCII Code  A-Z : 65-90
        }

        //시뮬레이션 - 사다리정보의 세로줄 값이 학생 배열의 인덱스로 알파벳 교환
        //학생의 알파벳은 1번부터지만, answer[] 배열은 0부터 시작하므로 x, x-1 교환
        for (int[] line : ladder) { //가로줄 탐색
            for (int x : line) { //가로막대탐색
                char tmp = answer[x];
                answer[x] = answer[x-1]; //알파벳 교환
                answer[x-1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_01_Answer T = new Ex01_01_Answer();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
