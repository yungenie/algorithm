package study.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 최대 길이 연속수열 - 자료구조 활용
 * 소요시간 : 2시간 반
 * 셀프피드백 :
 * ArrayList 순차자료형으로 인덱스 존재함
 *
 */
public class Ex03_16_02 {
    public int solution(int[] nums){
        int answer = 0;

        // 중복 및 정렬 후 선형자료형 담기
        /**
         * 강사님 강의 피드백
         * TreeSet : 중복제거, 자동정렬
         * ->  이진트리 구조로 되어 있다. 레드블랙트리로 구현되어 있어요.
         * contains()로 값이 유무 확인하면 트리이기 때문에 시간복잡도가 O(logn) 입니다.
         */
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ArrayList<Integer> numsArr = new ArrayList<>();
        for (Integer i : set) {
            numsArr.add(i);
        }

        // 연속수열 찾기
        int n = numsArr.size();
        ArrayList<Integer> tmp; //연속수열 바구니
        ArrayList<ArrayList<Integer>> numbers  = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            tmp = new ArrayList<>(); //연속수열 바구니 초기화
            int s = numsArr.get(i+1) - numsArr.get(i);
            if (s > 1) continue;
            if (s == 1) tmp.add(numsArr.get(i)); tmp.add(numsArr.get(i+1));
            for (int j = i + 1; j < n - 1 ; j++) {
                int js = numsArr.get(j+1) - numsArr.get(j);
                if (js > 1) break;
                if (js == 1) tmp.add(numsArr.get(j+1));
            }
            numbers.add(tmp);
        }

        //연속수열의 길이
        ArrayList<Integer> arr = new ArrayList<>();
        if (numbers.size() == 0) { //연속수열이 존재하지 않는 경우
            arr.add(1);
        } else {
            for (ArrayList<Integer> number : numbers) {
                arr.add(number.size()); //연속수열의 길이 넣기
            }
        }
        //가장 긴 연속수열 길이 찾기
        arr.sort((o1, o2) -> o2.compareTo(o1)); //내림차순
        answer = arr.get(0); //가장 긴 연속수열의 길이

        return answer;
    }

    public static void main(String[] args){
        Ex03_16_02 T = new Ex03_16_02();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
