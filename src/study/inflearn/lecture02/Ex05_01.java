package study.inflearn.lecture02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 침몰하는 타이타닉 - greedy : 탐욕법
 * 소요시간 - 1시간 8분
 */
public class Ex05_01 {
    public int solution(int[] nums, int m){
        int answer = 0;
        int n = nums.length;

        // 내림차순
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a,b) -> b - a);

        // 구명보트 태우기
        ArrayList<int[]> tmp = new ArrayList<>();
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            if (i > j) break;
            else if (i == j) {answer++; break;} // 승객 혼자 남았을 때
            if (arr[j] <= m - arr[i]) { // 승객 2명 태우기
                tmp.add(new int[]{arr[i], arr[j]});
                answer++;
                j--;
                continue;
            } else { // 무거운 승객 혼자 태우기
                tmp.add(new int[]{arr[i]});
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_01 T = new Ex05_01();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }

}
