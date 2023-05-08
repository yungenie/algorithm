package study.inflearn;

import java.util.ArrayList;
import java.util.List;

/**
 * 과일 가져가기 - 시뮬레이션 & 구현
 *
 * 서로 교환했을 때 이득이 나는 조건
 * 1) 각 학생의 최솟값이 유니크(유일) 해야 한다. (과일의 수가 중복되면 안됨)
 * 2) 서로 교환하려고 하는 두 학생의 최소값인 과일이 서로 달라야 한다. (교환하려는 과일의 인덱스가 달라야 함)
 * 3) 교환했을 때 1개 증가한 과일의 개수가 그대로 최솟값을 유지해야 한다. (교환 후 증가한 과일의 수가 가장 작아야 함)
 *
 */
public class Ex01_06_Answer {
    // 과일 바구니 중 최소값 찾기
    public int getMin(int[] fruit) {
        int min = 51;
        for (int ele : fruit) {
            min = Math.min(ele, min);
        }
        return min;
    }

    // 과일 바구니 중 최소값 유니크 여부
    public Boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int ele : fruit) {
            if (ele == min) cnt++;
        }
        return cnt == 1;
    }

    // 과일 바구니 중 최소값 배열 인덱스 찾기
    public int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < 3; i++) {
            if (fruit[i] == min) return i;
        }
        return 0;
    }
    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;

        int[] skip = new int[n];
        for (int i = 0; i < n; i++) {
            // 교환한 학생 넘어가기
            if (skip[i] == -1) continue;
            // 최소값 유니크 체크
            if (isMinUnique(fruit[i]) == false) continue;

            for (int j = i+1; j < n; j++) {
                if (skip[j] == -1) continue;
                if (isMinUnique(fruit[j]) == false) continue;

                // 교환할 과일 종류가 같지 않고, 교환받은 후 과일 수와 전달하고 남은 과일 수보다 같거나 작아야 한다.
                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0){
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1){
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        skip[i] = -1;
                        skip[j] = -1;
                        break;
                    }
                }
            }
        }
        // 모든 학생이 가져가는 과일의 합
        for(int[] x : fruit) {
            answer += getMin(x);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_06_Answer T = new Ex01_06_Answer();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
