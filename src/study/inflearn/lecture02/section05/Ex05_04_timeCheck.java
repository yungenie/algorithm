package study.inflearn.lecture02.section05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 꽃이 피는 최단시간 - greedy
 * 강사님 해법 듣고 재도전
 */
public class Ex05_04_timeCheck {

    public static void listChk(int n) {
        long start = System.currentTimeMillis();

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{i, i});
        }
        Collections.sort(list, (a,b) -> b[1] - a[1]); // note Collectinos.sort() 시간복잡도 평균/최악 O(nlogn)


        System.out.println("listChk = " + (System.currentTimeMillis() - start));
    }

    public static void arrayChk(int n) {
        long start = System.currentTimeMillis();

        Integer[][] array = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = i;
            array[i][1] = i;
        }
        Arrays.sort(array, (a,b) -> b[1] - a[1]);


        System.out.println("arrayChk = " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args){
        int n = 50_000_000;
        listChk(n);
        arrayChk(n);


    }
}
