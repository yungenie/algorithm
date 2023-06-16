package study.inflearn.study;

import java.util.Arrays;

/**
 * 이분검색 - 1. 정렬  2. 중간지점 구하기 3. 찾고자 하는 값이 중간보다 아래인지 위인지 찾기
 */
public class BinarySearch_Ex01 {
    public static void main(String[] args) {
        BinarySearch_Ex01 T = new BinarySearch_Ex01();
        System.out.println(T.solution(8, 32, new int[]{23, 87, 65, 12, 57, 32, 99, 81}));
    }

    public int solution(int n, int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = n-1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }

        return answer;

    }

}
