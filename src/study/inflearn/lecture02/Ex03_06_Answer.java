package study.inflearn.lecture02;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 가장 많이 사용된 회의실 - 자료구조 활용
 * 문제 개요 - TreeSet, PriorityQueue 활용해서 조건에 따라 처리하고, 회의실의 사용 유무에 따라 처리해야하는 문제입니다.
 */
public class Ex03_06_Answer {
    public int solution(int n, int[][] meetings){
        //System.out.println("tasks = " + Arrays.deepToString(meetings)); // 다차원 배열 출력
        int answer = 0;

        // 회의시작 기준으로 오름차순 정렬
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // 각 회의실 사용빈도수
        int[] roomCnt = new int[n];

        // 회의실 번호 초기화 (빈 회의실)
        TreeSet<Integer> useRoom = new TreeSet<>(); //TreeSet 은 레드블랙트리로 자료구조로 구현되어 있어 O(logn)만에 오름차순 정렬됩니다.
        for (int i = 0; i < n; i++) {
            useRoom.add(i);
        }

        // 회의실 할당
        PriorityQueue<int[]> meeting = new PriorityQueue<>((a,b) -> a[0] == b[0]? a[1] - b[1]: a[0] - b[0]); //{끝나는 시간, 회의실 번호}
        for (int[] info : meetings) {
            while (!meeting.isEmpty() && meeting.peek()[0] <= info[0]){ // 회의 중인 회의실이 있으며, 제일 빨리 끝나는 회의시간 이후에 시작시간이 들어온 경우
                useRoom.add(meeting.poll()[1]); // 사용 가능한 회의실 번호 넣어주기 (빈 회의실 알려주기)
            }

            if (!useRoom.isEmpty()) { // 사용 가능한 회의실이 있는 경우
                int roomNum = useRoom.pollFirst();
                roomCnt[roomNum]++;
                meeting.offer(new int[]{info[1], roomNum});
            } else { // 사용 가능한 회의실이 없는 경우
                int[] exit = meeting.poll();
                roomCnt[exit[1]]++;
                meeting.offer(new int[]{exit[0] + (info[1] - info[0]), exit[1]});
            }
        }

        int maxi = 0;
        for(int i = 0; i < n; i++){
            if(roomCnt[i] > maxi){
                maxi = roomCnt[i];
                answer = i;
            }
        }

        return answer;

    }

    public static void main(String[] args){
        Ex03_06_Answer T = new Ex03_06_Answer();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        //System.out.println(T.solution(2, new int[][]{{2, 7}, {0, 5}, {4, 5}, {9, 12}, {7, 10}}));
        //System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        //System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        //System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
