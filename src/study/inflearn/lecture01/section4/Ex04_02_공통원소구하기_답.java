package study.inflearn.lecture01.section4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex04_02_공통원소구하기_답 {

    public List<Integer> solution(int n, int m, int[] nArr, int[] mArr) {
        List<Integer> answer = new ArrayList<>();

        // 배열 정렬
        Arrays.sort(nArr);
        Arrays.sort(mArr);

        // 투 포인터 정렬
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            // 원소가 같은 경우
            if (nArr[p1] == mArr[p2]) {answer.add(nArr[p1]); p1++; p2++;}
            // 다른 경우 작은 값의 배열의 포인터를 증감. 작은 값이 다른 배열에 있을 가능성이 없으므로
            else if (nArr[p1] < mArr[p2]) p1++;
            else if (nArr[p1] > mArr[p2]) p2++;
        }

        return answer;
    }


    public static void main(String[] args) {
        Ex04_02_공통원소구하기_답 T = new Ex04_02_공통원소구하기_답();
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
        for (int x : T.solution(n, m, nArr, mArr)) System.out.print(x + " ");
    }
}
