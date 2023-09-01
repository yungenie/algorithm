package study.inflearn.lecture02.section01;

import java.util.Arrays;

/**
 * 사다리 타기 - 시뮬레이션 & 구현
 */
public class Ex01_01_03_Answer {
    public char[] solution(int n, int[][] ladder){
        // answer 배열에 알파벳 대문자 저장하기
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
        }

        // 사다리타기 -  배열의 인덱스를 통해서 알파벳 교환 로직
        for (int[] info : ladder) {
            for (int x : info) {
                char temp = answer[x];
                answer[x] = answer[x-1];
                answer[x - 1] = temp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_01_03_Answer T = new Ex01_01_03_Answer();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
