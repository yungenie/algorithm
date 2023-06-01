package study.inflearn.lecture02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 모임장소 - Sorting & Thinking
 * 강사님 해법 듣고 재도전
 */
public class Ex04_05_02 {
    public int solution(int[][] board){
        int answer=0;
        int n = board.length;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col);

        int studentCnt = row.size();
        int meetPoint = studentCnt / 2;
        for (int i = 0; i < studentCnt; i++) {
            answer += Math.abs(row.get(meetPoint) - row.get(i)) + Math.abs(col.get(meetPoint) - col.get(i));

        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_05_02 T = new Ex04_05_02();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
