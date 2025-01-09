package study.etc.test;

import java.util.*;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // return item;
        stack.add(1); // return boolean
        stack.pop(); // return item; and remove
        stack.peek(); // return item;
    }
}
