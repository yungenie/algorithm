package study.inflearn.lecture01.section5;

import java.util.*;

public class Ex05_05_K번째큰수_답 {

    public int solution(int k, int n, int[] arr) {
        int answer = -1;

        Set<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int index = 0;
        for (int x : tSet) {
            if (index == k) {
                answer = x;
                break;
            }
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex05_05_K번째큰수_답 T = new Ex05_05_K번째큰수_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(k, n, arr));

    }
}
