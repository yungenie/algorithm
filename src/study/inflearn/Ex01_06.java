package study.inflearn;

import java.util.*;

/**
 * 과일 가져가기 - 시뮬레이션 & 구현
 *
 */
public class Ex01_06 {
    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;

        // 최소 과일 찾기
        int[] minIndex = new int[n];
        int[] minValue = new int[n];
        int temp, min, index = 0;
        for (int i = 0; i < n; i++) {
            min = fruit[i][0];
            for (int j = 0; j < 3; j++) {
                temp = fruit[i][j];
                if (min >= temp) {
                    min = temp;
                    index = j;
                }
            }
            minIndex[i] = index;
            minValue[i] = min;
        }

        List<Integer> sum = new ArrayList<>();
        // 최소 index 같으면 SKIP
        for (int i = 0; i < minIndex.length; i++) {
            for (int j = 1; j < minIndex.length; j++) {
                // 최소값의 증가하는 값이 해당 배열에 있으면 -1 셋팅
                // 과일 바구니 담겨있는 학생 SKIP
                if (minIndex[i] == -1 || minIndex[j] == -1) continue;
                if (minIndex[i] != minIndex[j]) {
                    sum.add(fruit[i][minIndex[i]] + 1);
                    sum.add(fruit[j][minIndex[j]] + 1);
                    minIndex[j] = -1;
                    minIndex[i] = -1;
                }

            }
        }


        for (int i = 0; i < minIndex.length; i++) {
            if (minIndex[i] != -1) {
                sum.add(fruit[i][minIndex[i]]);
            }
        }
        System.out.println("sum = " + sum);

        for (int i = 0; i < sum.size(); i++) {
            answer += sum.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Ex01_06 T = new Ex01_06();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}



/*
- for 증감식 매커니즘 제대로 알기...
- 최소값, 최대값 구하기
- ArrayList, Array 선언 정확히 모름....
- for문 안에 if() {if() break, continue 동작 정확히 모름...
- sum+= 1헷갈려서 sum+=sum+1함..
 */