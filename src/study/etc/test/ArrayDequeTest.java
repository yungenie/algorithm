package study.etc.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeTest {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(9);
        arrayDeque.addFirst(1);
        arrayDeque.offerFirst(1);

    }
}
