package study.inflearn.lecture01.section4;

import java.util.Scanner;

public class Ex04_06_최대길이연속부분수열_답 {

    public int solution(int n, int k, int[] arr) {
        int maxLen = 0;
        int kCnt = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) kCnt++;
            while (kCnt > k) {
                if(arr[lt] == 0) kCnt--;
                lt++;
            }
            maxLen = Math.max(maxLen, rt - lt + 1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Ex04_06_최대길이연속부분수열_답 T = new Ex04_06_최대길이연속부분수열_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
