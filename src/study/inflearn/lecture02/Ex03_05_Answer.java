package study.inflearn.lecture02;

import java.util.*;

/**
 * CPU 스케쥴링 - 자료구조 활용
 * 문제 개요 - LinkedList, PriorityQueue 활용해서 조건에 따라 처리하고, 끝난 시간을 계속 업데이트 문제입니다.
 * 배운점
 * - LinkedList 저장순서가 유지되는 자료구조
 * - PriorityQueue 우선순위가 높은 것(요소값 작은)부터 꺼내는 우선순위 큐
 * - 논리연산자 false || true  = true
 */
public class Ex03_05_Answer {
    public int[] solution(int[][] tasks){
        //System.out.println("tasks = " + Arrays.deepToString(tasks));
        int n = tasks.length;
        int[] answer = new int[n];

        // 작업정보 생성
        LinkedList<int[]> taskInfo = new LinkedList<>(); // 작업삭제시 요소의 재배치를 하지 않기 위해 LinkedList 선택
        for (int i = 0; i < n; i++) {
            taskInfo.offer(new int[]{tasks[i][0], tasks[i][1], i}); //{호출시간, 실행시간, 작업번호}
        }
        // 호출시간 기준 오름차순
        taskInfo.sort((a,b) -> a[0] - b[0]);
        taskInfo.forEach((i) -> System.out.print(Arrays.toString(i))); System.out.println();

        // 대기공간 생성 - 우선순위가 높은 것(요소값 작은)부터 꺼내는 우선순위 큐 선택 (실행시간이 작은 값부터 처리할 수 있도록)
        PriorityQueue<int[]> waitQ = new PriorityQueue<>((a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]); // 실행시간이 같은 경우 작업번호가 작은 것부터 처리
        int fT=0, idx = 0;

        // 작업실행
        while (!taskInfo.isEmpty() || !waitQ.isEmpty()) { // 작업 또는 대기가 있을 때까지 처리
            if (waitQ.isEmpty()) { // 대기열이 없는 경우
                fT = Math.max(fT, taskInfo.peek()[0]); // 작업이 끝난 시간 이후에 호출이 들어오는 경우 호출시간으로 초기화
            }
            // 우선순위 큐로 들어가 대기하는 작업
            while (!taskInfo.isEmpty() && taskInfo.peek()[0] <= fT) { // 작업이 끝난 시간보다 호출시간이 작은 모든 작업을 대기 처리
                int[] x = taskInfo.pollFirst(); //첫 번째 요소를 꺼내서 반환하거나 이 목록이 비어 있으면 null을 반환
                waitQ.offer(new int[]{x[1], x[2]}); // {실행시간, 작업번호}
            }

            // 다음 끝날 시간 초기화
            int[] exit = waitQ.poll();
            fT += exit[0];

            // cpu가 처리하는 작업번호
            answer[idx++] = exit[1];
        }
        return answer;
    }

    public static void main(String[] args){
        Ex03_05_Answer T = new Ex03_05_Answer();
        //System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        //System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        //System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 1}, {3, 3}, {8, 2}, {1, 1}, {2, 2}, {1, 1}})));
        //System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
