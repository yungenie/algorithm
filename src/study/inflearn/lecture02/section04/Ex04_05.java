package study.inflearn.lecture02.section04;

import java.util.*;

/**
 * 모임 장소 - Sorting & Thinking
 * 소요시간 - 50분
 */
public class Ex04_05 {
    public int solution(int[][] board){
        int n = board.length;

        List<int[]> studentLoc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) studentLoc.add(new int[]{i, j});
            }
        }
        //studentLoc.forEach((i) -> System.out.print(Arrays.toString(i))); System.out.println(); // note 컬렉션프레임워크 함수형 디폴트 메서드 forEach() 출력

        int idx = 0;
        //Integer[] locSum = new Integer[n * n];
        List<Integer> locSum = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < studentLoc.size(); k++) {
                    int x = studentLoc.get(k)[0];
                    int y = studentLoc.get(k)[1];
                    sum += Math.abs(i - x) + Math.abs(j - y);
                }
                //locSum[idx] = sum;
                locSum.add(sum);
                //idx++;
                sum = 0;
            }
            sum = 0;
        }
        //Arrays.sort(locSum);
        //locSum.sort(Comparator.comparingInt(a -> a));
        Collections.sort(locSum);

        //return locSum[0];
        return locSum.get(0);
    }

    public static void main(String[] args){
        Ex04_05 T = new Ex04_05();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
