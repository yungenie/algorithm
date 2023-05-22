package study.inflearn.lecture02;


import java.util.Arrays;

/**
 * 회의실 만남 - 시뮬레이션 & 구현
 *
 */
public class Ex01_08_Answer {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;

        // 입실한 사람의 번호는 enter 배열의 길이안에 범위이므로 index와 맞추기
        for(int i = 0; i < n; i++){
            enter[i]--;
            exit[i]--;
        }

        // 몇번째로 왔는 지 - 입실한 사람의 번호 순서대로 몇번째 들어왔는 지 배열에 담기
        int[] enterIdx = new int[n];
        for(int i = 0; i < n; i++){
            enterIdx[enter[i]] = i; // enter 요소 자체가 enterIdx의 index로, enter 요소의 index가 enterIdx의 요소로 셋팅
        }

        // 입실 및 퇴실 시간 기록
        int[] enterT = new int[n];
        int[] exitT = new int[n];
        int cnt = 0;
        for(int i = 0, j = 0; i < n; i++){
            // 시간의 흐름 순으로 시뮬레이션 (시간복잡도 O(n))
            while(j < n && j <= enterIdx[exit[i]]){ // enterIdx[exit[i]] 언제 들어왔는지
                enterT[enter[j]] = cnt++; // 입실한 사람들의 입실 시간 //연산자가 변수 뒤에 있으면 연산으르 끝낸 후 변수를 증가 시킨다.
                j++;
            }
            exitT[exit[i]] = cnt++;  // 입실한 사람들의 퇴실 시간
        }

        // 각 사람별로 반드시 만난 사람의 수
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                // 만나는 조건 = !안만나는 조건(A,B 나간 사람의 시간 < 들어온 시간)
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