package study.inflearn.lecture01.section5;

import java.util.*;

public class Ex05_03_매출액의종류_답 {

    public List<Integer> solution(int n, int k, int[] arr) {

        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap();
        // k-1 개수까지 HashMap에 담기.
        for (int i = 0; i < k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        // k 개수부터 HashMap에 담고 lt는 개수 빼기. 개수가 0일때 Map에서 삭제.
        for (int rt = k-1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ex05_03_매출액의종류_답 T = new Ex05_03_매출액의종류_답();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(n, k, arr)) System.out.print(x + " ");
    }
}
