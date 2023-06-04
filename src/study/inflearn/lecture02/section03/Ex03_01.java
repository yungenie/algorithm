package study.inflearn.lecture02.section03;

import java.util.*;

/**
 * 최대 길이 연속수열 - 자료구조 활용
 * 소요시간 : 2시간 반
 * 셀프피드백 :
 * 감은 왔으나, 코딩으로 명확하게 설계안된 상태에서 문제 품.
 * 어떤자료구조를 써야할지 정확히 생각 못해냄.
 * ArrayList 초기화 하는 거 몰랐음.
 * for i,j 활용 약함.
 * for i<n-1, j=i+1 j<n-1
 *
 */
public class Ex03_01 {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;

        // 수열 정렬
        Arrays.sort(nums);
        //System.out.println("nums = " + Arrays.toString(nums));

        // 연속수열 찾기
        ArrayList<Integer> tmp; //연속수열 바구니
        ArrayList<ArrayList<Integer>> numbers  = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            tmp = new ArrayList<>(); //연속수열 바구니 초기화
            int s = nums[i+1] - nums[i];
            if (s > 1 || s == 0) continue;
            if (s == 1) tmp.add(nums[i]); tmp.add(nums[i+1]);
            for (int j = i + 1; j < n - 1 ; j++) {
                int js = nums[j + 1] - nums[j];
                if (js == 0) continue; //중복된 값
                if (js > 1) break;
                if (js == 1) tmp.add(nums[j+1]);
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
        Ex03_01 T = new Ex03_01();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
