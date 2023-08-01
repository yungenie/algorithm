package study.etc;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Array, ArrayList, LinkedList 메모리 주소 공간 비교 (디버깅용 소스)
 */

class Person {
    private int id;
    public Person(int id) {
        this.id = id;
    }
}
public class Array_ArrayList_LinkedList {

    public static void main(String[] args) {
        int[] arrInt = new int[5];
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = i + 1;
        }
        System.out.println("arrInt = " + arrInt);

        Integer[] arrInteger = new Integer[5];
        for (int i = 0; i < arrInteger.length-1; i++) {
            arrInteger[i] = i + 1;
        }
        System.out.println("arrInteger = " + arrInteger);

        String[] arrString = new String[5];
        System.out.println("arrString = " + arrString);
        
        arrString[0] = "yunjin" + (0+1);
        arrInteger[4] = 4 + 1;

        System.out.println("arrString = " + arrString);

        ArrayList<String> arrListStr = new ArrayList<>();
        arrListStr.add("a" + 1);
        arrListStr.add("a" + 2);
        arrListStr.add("a" + 3);

        System.out.println("arrListStr = " + arrListStr);
        arrString[3] = "yunjin" + (3+1);
        arrString[4] = "yunjin" + (4+1);

        LinkedList<String> linkedListStr = new LinkedList<>();
        linkedListStr.add("y" + 5);
        linkedListStr.add("y" + 6);
        linkedListStr.add("y" + 7);

        System.out.println("linkedListStr = " + linkedListStr);

        arrString[2] = "yunjin" + (2+1);

        ArrayList<Person> arrListObj = new ArrayList<>();
        arrListObj.add(new Person(1));
        arrListObj.add(new Person(2));
        arrListObj.add(new Person(3));

        LinkedList<Person> linkedListObj = new LinkedList<>();
        linkedListObj.add(new Person(1));
        linkedListObj.add(new Person(2));
        linkedListObj.add(new Person(3));

        System.out.println("BREAK POINT");

        arrListObj.add(1, new Person(4));
        linkedListObj.add(1, new Person(4));

        System.out.println("BREAK POINT");
    }
}



