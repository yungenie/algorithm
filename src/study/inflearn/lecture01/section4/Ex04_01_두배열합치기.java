package study.inflearn.lecture01.section4;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04_01_두배열합치기 {

    public void solution(int[] nArr, int[] mArr){
        int len = nArr.length + mArr.length;
        int[] arr = new int[len];

        for (int i = 0; i < nArr.length; i++) {
            arr[i] = nArr[i];
        }
        int idx = nArr.length;
        for (int j = 0; j < mArr.length; j++) {
            arr[idx] = mArr[j];
            idx++;
        }

        Arrays.stream(arr).sorted().forEach(i -> System.out.print(i + " "));
    }


    public static void main(String[] args) {
        Ex04_01_두배열합치기 T = new Ex04_01_두배열합치기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }

        T.solution(nArr, mArr);
    }
}
