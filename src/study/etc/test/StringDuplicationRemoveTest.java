package study.etc.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 복수의 문자열이 주어졌을때, 중복된 문자를 제거하는 방법
 * 입력 : hello, holy
 * 출력 : heloy
 */
public class StringDuplicationRemoveTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Object[] array = Arrays.stream(sc.nextLine().split(""))
                .filter(s -> !s.isBlank())
                .toArray();

        Arrays.stream(array)
                .distinct()
                .forEach(System.out::print);

    }
}
