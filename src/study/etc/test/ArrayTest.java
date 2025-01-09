package study.etc.test;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        String[][] array = new String[2][3];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i + "," + j;
            }
        }

        System.out.println(Arrays.deepToString(array));

    }
}
