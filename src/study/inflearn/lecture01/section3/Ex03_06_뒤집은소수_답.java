package study.inflearn.lecture01.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex03_06_뒤집은소수_답 {

    // 소수 판단
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int n, int[] array) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 입력값 뒤집기
        for (int i = 0; i < n; i++) {
            int tmp = array[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10; // 나머지
                tmp = tmp/10; // 몫
                res = res * 10 + t; // 뒤집기 합산
            }
            if (isPrime(res)) answer.add(res);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex03_06_뒤집은소수_답 T = new Ex03_06_뒤집은소수_답();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int x : T.solution(n, array)) {
            System.out.print(x + " ");
        }

    }
}
