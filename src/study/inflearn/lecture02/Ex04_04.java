package study.inflearn.lecture02;

import java.util.Arrays;

/**
 * 심사위원 - Sorting & Thinking
 * 소요시간 - 26분
 */
public class Ex04_04 {
    public int solution(int[] score, int k){
        int answer = 0;

        // 심사위원 점수 오름차순
        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreArr);

        for (int i = 0; i < scoreArr.length; i++) {
            if (scoreArr[i+(k-1)] <=scoreArr[i] + 10) { // k개 골라 점수 차이 10이하인 요소 조건
                for (int j = i; j < i+k; j++) {
                    answer += scoreArr[j]; // 최종점수
                }
                answer = answer/k; // 평균점수
                break;
            } else {
                continue;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex04_04 T = new Ex04_04();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
