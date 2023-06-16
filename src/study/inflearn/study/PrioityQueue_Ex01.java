package study.inflearn.study;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 우선순위 큐 PrioityQueue
 * - 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 된다는 특징이 있음.
 * - 저장공간은 배열을 사용하며, 각 요소를 힙(heap) 자료구조의 형태로 저장한다. (힙은 완전이진트리로 가장 큰 값/작은 값을 빠르게 찾을 수 있는 특징)
 * - 숫자뿐만 아니라 객체를 저장할 때는 각 객체의 크기를 비교할 수 있는 방법을 제공해야 합니다.
 */
public class PrioityQueue_Ex01 {
    public static void main(String[] args) {

        // 우선순위가 높은 순으로 정렬
        System.out.println("PriorityQueue 우선순위가 높은 것(숫자가 작을 수록 우선순위는 높다)");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(10);
        pq.offer(1);
        pq.offer(0);
        pq.offer(3);
        pq.offer(15);
        pq.offer(7);
        System.out.println("pq = " + pq);

        Object obj = null;
        while ((obj = pq.poll()) != null) {
            System.out.println(obj);
        }

        // 우선순위가 낮은 순으로 정렬
        System.out.println("PriorityQueue 우선순위가 낮은 것(숫자가 클수룩 우선순위는 낮다)");
        PriorityQueue<Integer> pqr = new PriorityQueue<>(Collections.reverseOrder());
        pqr.offer(10);
        pqr.offer(1);
        pqr.offer(0);
        pqr.offer(3);
        pqr.offer(15);
        pqr.offer(7);

        Object obj2 = null;
        while ((obj2 = pqr.poll()) != null) {
            System.out.println(obj2);
        }
    }
}
