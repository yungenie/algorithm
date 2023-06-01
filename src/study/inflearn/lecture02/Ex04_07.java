package study.inflearn.lecture02;

import java.util.ArrayList;
import java.util.List;

/**
 * 최소 회의실 개수 - Sorting & Thinking
 * 강사님 해법 듣고 재도전
 */
public class Ex04_07 {
    public int solution(int[][] meetings){
        int answer = 0;
        int n = meetings.length;

        List<int[]> meetingList = new ArrayList<>();
        for (int[] meeting : meetings) {
            meetingList.add(new int[]{meeting[0], 1}); // 시작시간 : 1
            meetingList.add(new int[]{meeting[1], -1}); // 끝시간 : -1
        }

        meetingList.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // 시간 오름차순, 시작시간과 끝시간이 같은 경우 끝시간 오름차순
        //meetingList.stream().forEach(i -> System.out.print( Arrays.toString(i)));

        int cnt = 0;
        for (int[] meet : meetingList) {
            cnt += meet[1];
            answer = Math.max(cnt, answer);
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_07 T = new Ex04_07();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
