package study.inflearn.lecture02.section01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 사다리 타기 - 시뮬레이션 & 구현
 * 2회독 (48분 소요) 답은 맞았으나, 인접리스트로 레벨탐색처럼 푼거라 시간복잡도 측면에서 비효율적인 코드임.
 */
public class Ex01_01_02 {
    public char[] solution(int n, int[][] ladder){
        /*
            n 학생 수

            가로0 1->2
            가로1 2->3
            가로3 없음
            answer[3] = 'A'

            가로0 2-> 1
            가로1 없음
            가로2 2
            answer[2] = 'B'

            가로0 3-> 4
            가로1 4-> 5
            가로2 5-> 4
            answer[4] = 'C'

            1. 학생 배열 만들기 (값은 알파벳 대문자)
             - 대문자A는 65이며 대문자 Z는 90

            2. 사다리정보 배열 만들기
            어떤 자료구조를 사용하면 좋을까?
            ArrayList? Array? HashMap?
            0 12,21,34,43
            1 23,32,45,54
            2 12,21,45,54
            
            3. 사다리 타기 (핵심로직)

         */

        char[] answer = new char[n];

        //1. 학생 배열 만들기 (값은 알파벳 대문자, 아스키코드 65~90)
        char[] student = new char[n];
        for (int i = 0; i < n; i++) student[i] = (char) (65 + i); // 람다나 스트림으로 변환 가능한지 확인

        //2. 사다리정보 배열 만들기 (인접리스트 생성)
        ArrayList<ArrayList<int[]>> info = new ArrayList<>();
        int size = ladder.length;
        for (int i = 0; i < size; i++) {
            info.add(i, new ArrayList<>());
        }
        for (int i = 0; i < size; i++) {
            int ladderSize = ladder[i].length;
            for (int j = 0; j < ladderSize; j++) {
                info.get(i).add(new int[]{ladder[i][j], ladder[i][j] + 1});
                info.get(i).add(new int[]{ladder[i][j] + 1, ladder[i][j]});
            }
        }

        //3. 사다리타기 (핵심로직)
        for (int i = 0; i < n; i++) {
            int idx = i+1; // 학생 번호
            char value = student[i]; // 학생 알파벳 번호

            // 레벨탐색 이어지는 사다리 지나서 마지막 번호 찾기
            int next = idx;
            for (ArrayList<int[]> ints : info) {
                for (int[] anInt : ints) {
                    if (anInt[0] == next) {
                        next = anInt[1]; // 이어지는 사다리 번호
                        break;
                    }
                }
            }
            answer[next-1] = value; // 배열의 인덱스는 0부터 시작하므로 학생번호 - 1
        }

        return answer;
    }

    public static void main(String[] args){
        Ex01_01_02 T = new Ex01_01_02();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
