package study.inflearn.lecture02.section04;

import java.util.Arrays;
/**
 * 이진수 정렬 - Sorting & Thinking
 * 소요시간 - 12분
 * 강사님 코드 확인 후 재도전
 * 실수 : Array.sort() Comparator 있는 지 확인 못함..
 * 알게된점 :
 * - Arrays.sort()는 내부적으로도 Dual Pivot Quick Sort로 구현되어 있음.
 * - Quick Sort (퀵 정렬)
 * 불필요한 데이터의 이동을 줄이고 먼 거리의 데이터를 교환할 뿐만 아니라,
 * 한 번 결정된 피벗들이 추후 연산에서 제외되는 특성 때문에,
 * 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
 */
public class Ex04_01_02 {
    public int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        int[][] result = new int[n][2];

        for (int i = 0; i < n; i++) {
            String bs = Integer.toBinaryString(nums[i]); // 이진수 변환
            int bsLen = bs.length();
            int count = 0;
            for (int j = 0; j < bsLen; j++) {
                if (bs.charAt(j) == '1') count++;
            }
            result[i][0] = count;
            result[i][1] = nums[i];
        }
        //System.out.println("Arrays.deepToString(result) = " + Arrays.deepToString(result));
        Arrays.sort(result, (a,b) -> a[0] == b[0]? a[1] - b[1]  : a[0] - b[0]); // note Arrays.sort()도 Comparator 있음.

        for (int k = 0; k < result.length; k++) {
            answer[k] = result[k][1];
        }

        return answer;
    }

    public static void main(String[] args){
        Ex04_01_02 T = new Ex04_01_02();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
