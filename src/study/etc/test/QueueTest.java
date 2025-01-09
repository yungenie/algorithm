package study.etc.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // return boolean;
        q.poll(); // return value; and remove;
        q.peek(); // return value;


        /**
         * add() : 큐의 용량 제한 때문에 공간이 없으면 IllegalStateException 예외를 던집니다.
         */

        List<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.add(2);
        list.addLast(2);


    }
}
