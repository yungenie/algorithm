package study.inflearn.lecture01.section2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 정답.
 * 26분
 */
public class Ex02_10_가장짧은문자거리 {

    public void solution(String s, String t) {
        int len = s.length();
        int[] minDistArr = new int[len];
        Arrays.fill(minDistArr, Integer.MAX_VALUE);

        int findIdx = -1;
        for (int i = 0; i < len; i++) {
            String x = String.valueOf(s.charAt(i));
            if (t.equals(x)) {
                for (int j = findIdx + 1; j <= i; j++) {
                    minDistArr[j] = Math.min(i - j, minDistArr[j]);
                }
                findIdx = i;
            } else {
                if (findIdx >= 0) {
                    minDistArr[i] = Math.min(i - findIdx, minDistArr[i]);
                }
            }

        }

        for (int i : minDistArr) {
            System.out.print(i+" ");
        }
    }


    public static void main(String[] args) {
        Ex02_10_가장짧은문자거리 T = new Ex02_10_가장짧은문자거리();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        T.solution(s, t);
    }
}
