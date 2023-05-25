package study.inflearn.lecture02;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/**
 * 이진수 정렬 - Sorting & Thinking
 * 소요시간 - 30분
 * Integer.toBinaryString() 이진수 변환 함수 사용
 * PriorityQueue 우선순위 큐 생성자에 람다식으로 Comparator.compare() 정렬기준 추가해서 풀었음.
 */
public class Ex04_01 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]); //{1의 총갯수, 십진수}

        // 이진수 정렬
        for (int i : nums) {
            String bs = Integer.toBinaryString(i); // 이진수 변환
            int bsLen = bs.length();
            int count = 0;
            for (int j = 0; j < bsLen; j++) {
                if (bs.charAt(j) == '1') count++;
            }
            pq.offer(new int[]{count, i});
        }
        //pq.forEach((i) -> System.out.print(Arrays.toString(i))); System.out.println();

        // 1의 개수 오름차순, 십진수 오름차순
        int pqLen = pq.size();
        for (int i = 0; i < pqLen; i++) {
            int num = pq.poll()[1];
            answer[i] = num;
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_01 T = new Ex04_01();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
