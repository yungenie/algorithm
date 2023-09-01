package study.inflearn.lecture02.section01;

import java.util.ArrayList;

/**
 * 최대길이 바이토닉 - 시뮬레이션 & 구현
 *
 * 문제 포인트 : 봉우리지점(인덱스)를 통해 연속부분수열 찾기
 */
public class Ex01_05_Answer {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;

        // 수열의 봉우리지점 인덱스 담기  이전 < 현재(봉우리) > 이후
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) { // 배열의 n-2까지 도는 이유는 i+1까지 보기 때문.
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peaks.add(i);
            }
        }

        // 봉우리지점 인덱스를 기준으로 양방향으로 바이토닉 수열의 개수 구하기
        for(int x : peaks){
            int left = x; // 왼쪽방향 인덱스
            int right = x; // 오른쪽방향 인덱스
            int cnt = 1; // 봉우리지점 카운팅

            // 연속부분수열 측정
            while(left-1 >= 0 && nums[left] > nums[left-1]){ //왼쪽 탐색
                left--; // 왼쪽방향 인덱스 감소
                cnt++; // 바이토닉 수열의 개수
            }
            while(right+1 < n && nums[right] > nums[right+1]){ //오른쪽 탐색
                right++; // 오른쪽방향 인덱스 감소
                cnt++; // 바이토닉 수열의 개수
            }
            //가장 긴 바이토닉 수열의 길이
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_05_Answer T = new Ex01_05_Answer();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}