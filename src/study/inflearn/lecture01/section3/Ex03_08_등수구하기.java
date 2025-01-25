package study.inflearn.lecture01.section3;

import java.util.*;

/*
정답.
1시간 20분. 문제 잘못 이해함.
 */
public class Ex03_08_등수구하기 {

    public void solution(int n, int[] array) {
        List<Integer> arrayList = new ArrayList<>();
        for (int x : array) {
            arrayList.add(x);
        }
        Collections.sort(arrayList, Comparator.reverseOrder());

        int[][] lanking = new int[n][2];
        lanking[0][0] = arrayList.get(0);
        lanking[0][1] = 1;

        for (int i = 1; i < n; i++) {
            lanking[i][0] = arrayList.get(i);
            if (lanking[i][0] == lanking[i-1][0]) lanking[i][1] = lanking[i-1][1];
            else if (lanking[i][0] != lanking[i-1][0]) {
                lanking[i][1] = i + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lanking[j][0] == array[i]) {
                    System.out.print(lanking[j][1] + " ");
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Ex03_08_등수구하기 T = new Ex03_08_등수구하기();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        T.solution(n, array);
    }
}
