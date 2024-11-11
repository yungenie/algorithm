package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 자료구조01_0커플_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());

            if (set.contains(-score)) {
                set.remove(-score);
            } else {
                set.add(score);
            }
        }

        int sum = 0;
        for (int score : set) {
            sum += score;
        }

        System.out.println(sum);
    }
}
/**
 * 정렬할 필요도 없음.
 * 입력값 바로 하나씩 받아서 HashSet 에 넣음.
 * 현재 점수의 반대 부호 점수가 존재하면 삭제.
 * 미존재하면 추가.
 */