package study.inflearn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 현관문 출입순서 - 자료구조 활용
 * - Queue
 *   boolean offer(Object o) : Queue에 객체를 저장. 성공하면 true,실패하면 false를 반환
 *   boolean add(Object o) : Queue에 추가. 성공하면 true 반환. 저장공간이 부족하면 IIegalStateException발생
 *   boolean poll() : Queue에 객체를 꺼내서 반환. 비어있으면 null 반환
 */
public class Ex03_18_Answer {
    public int[] solution(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>(); // 들어가려는 사원 대기명단
        Queue<Integer> exit = new LinkedList<>(); // 나가려는 사원 대기명단

        int n = arrival.length;
        int prev = 1; // 나가는 상태 초기화 (1:Out, 0:In 2가지 값이 담김)

        int[] answer = new int[n];

        //시간의 흐름에 의해 처리 - 조건식 없는 이유? 시간흐름을 계속 증가시키면서 해당 시간에 출입한 명단을 기록하기 위해
        for(int t = 0, i = 0, cnt = 0; ; t++){ //t:시간흐름, i:사원번호, cnt:현관문을 사용한 사람 수
            if(enter.isEmpty() && exit.isEmpty() && i < n) { // i < n : i가 다 처리 안된 경우?
                if(t < arrival[i]){ // 다음사원이 도착하는 시간이 현재 시간보다 클때
                    t = arrival[i]; //건너뛰기
                    prev = 1; // 나가는 사원 우선권
                }
            }
            while(i < n && arrival[i] <= t) { // 현재시간에 들어온 사원들 만큼 넣기
                if (state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }

            if(prev == 1) { // 나가는 대기열
                if (exit.isEmpty()) { // 나가는 대기열이 비었을 경우
                    answer[enter.poll()] = t; // 들어오는 대기열에서 찾기
                    prev = 0;
                } else { // 나가는 대기열 존재할 때
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }else if(prev == 0) { // 들어오는 대기열
                if(enter.isEmpty()) { // 들어오는 대기열이 비었을 경우
                    answer[exit.poll()] = t; // 나가는 대기열에서 찾기
                    prev = 1;
                }else{ // 들어오는 대기열 존재할 때
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            }
            cnt++;
            if(cnt == n) break;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex03_18_Answer T = new Ex03_18_Answer();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
