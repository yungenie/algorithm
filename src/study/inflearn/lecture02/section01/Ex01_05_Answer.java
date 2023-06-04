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

        // 수열의 봉우리지점 찾아 배열에 인덱스(봉우리지점) 담기
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peaks.add(i);
            }
        }

        // 봉우리지점 인덱스 탐색하면서, 지점의 양방향 하나씩 각각 돌면서 최대 바이토닉 수열의 길이 찾기
        for(int x : peaks){
            int left = x; //왼쪽방향 index
            int right = x; //오른쪽방향 index
            int cnt = 1; //봉우리지점 길이 초기 셋팅

            // 연속부분수열 측정
            while(left-1 >= 0 && nums[left-1] < nums[left]){ //왼쪽 탐색
                left--;
                cnt++;
            }
            while(right+1 < n && nums[right] > nums[right+1]){ //오른쪽 탐색
                right++;
                cnt++;
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



/*
ArrayList : 저장 순서가 유지되고, 중복을 허용함.
순차적인 데이터 추가/삭제 빠름, 데이터 읽기 빠름.
데이터 크기를 변경하기 비효율적이다.

 */