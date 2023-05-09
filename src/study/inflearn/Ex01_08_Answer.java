package study.inflearn;


import java.util.Arrays;

/**
 * 회의실 만남 - 시뮬레이션 & 구현
 *
 */
public class Ex01_08_Answer {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        for(int i = 0; i < n; i++){
            enter[i]--;
            exit[i]--;
        }

        // 입실한 사람이 몇번째로 왔는 지 배열에 담기
        int[] enterIdx = new int[n];
        for(int i = 0; i < n; i++){
            enterIdx[enter[i]] = i; // enter 요소 자체가 enterIdx의 index로, enter 요소의 index가 enterIdx의 요소로 셋팅
        }

        // 입실 및 퇴실 시간 기록
        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int cnt = 0;
        for(int i = 0, j = 0; i < n; i++){
            while(j < n && j <= enterIdx[exit[i]]){ // 퇴실하는 사람이 입실한 순서까지
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }

        // 각 사람별로 반드시 만난 사람의 수
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // 만나는 조건 = !안만나는 조건(나간 사람의 시간 < 들어온 시간) 앞 -> 뒤 / 뒤 -> 앞 서로 비교
                if(!(exitT[i] < enterT[j] || exitT[j] < enterT[i])){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_08_Answer T = new Ex01_08_Answer();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}



/*


 */