package study.inflearn.lecture02.section05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 꽃이 피는 최단시간 - greedy
 * 강사님 해법 듣고 재도전
 */
public class Ex05_04 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = growTime.length;

        // 꽃 심기 및 성장 기간이 담긴 2차원 배열
        List<int[]> pg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pg.add(new int[]{plantTime[i], growTime[i]}); // todo Array 순차 데이터 추가 vs ArrayList 순차 데이터 추가
        }
        Collections.sort(pg, (a,b) -> b[1] - a[1]); // 성장 기간이 가장 긴 꽃씨 내림차순 note Collectinos.sort() 시간복잡도 평균/최악 O(nlogn)

        int start = 0, end = 0;
        for (int[] x : pg) {
            start = start + x[0]; // 꽃 심기
            end = start + x[1]; // 꽃이 피는 날 : 꽃 심기 + 성장
            answer = Math.max(end, answer); // 가장 늦게 꽃이 피는 날
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_04 T = new Ex05_04();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
