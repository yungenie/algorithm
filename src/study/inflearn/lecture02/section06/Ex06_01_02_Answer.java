package study.inflearn.lecture02.section06;

import java.util.Arrays;

/**
 * 가장 가까운 큰 수 - 깊이우선탐색 : DFS
 * 순열
 * 2회독 틀림
 *
 * 요약
 * - 자연수 n보다 큰 제일 작은 수 찾기
 *     - 자연수 n 정렬해서 시간 복잡도 줄이기.
 *     - 자연수 n 데이터 크기 만큼 체크배열로 메모이제이션 하기.
 *     - return 값이 정해진 게 없기 때문에 조건에 맞는 flag 값이 둬서 백트래킹으로 return 되게 한다.
 */
public class Ex06_01_02_Answer {

    int target, len, answer;
    int[] arr;
    int[] ch;
    boolean flag;
    public void DFS(int L, int nums) { // L:레벨, nums: 각 자릿수의 조합의 수
        /*
            DFS()의 탈출조건이 자연수 n보다 큰 수가 오면 answer변수에 답을 초기화 해준다.
            - 플래그값을 두는 이유는? ✨
                - 그 다음에 스택에 남아 있는 재귀호출들은 호출되자마자 return되서 끝냅니다.
                - 남아 있는 재귀함수들 모두 백트래킹으로 return, return..된다.
         */
        if (flag) return; // 탈출조건
        if (L == len && target < nums) {
            answer = nums;
            flag = true;
        } else { // 재귀로 순열을 만드는 로직
            for (int i = 0; i < len; i++) { // 배열의 0부터 시작하기 위해 i는 0으로 초기화
                if (ch[i] == 0) {
                    /*
                        정렬된 순열에서 하나씩 조합 ✨
                        ex) n = 54312, 정렬한 배열 = [1,2,3,4,5]
                        1
                        12
                        123
                        1234
                        12345

                        2
                        21
                        213
                        2134
                        21345
                        등..

                        nums * 10 + arr[i] 점화식으로 구성요소의 조합을 만들고
                        재귀로 순열을 만들 때 요소(배열[i]) 인덱스 0~N-1까지 가지가 뻗어나간다.
                        자기자신과 사용한 요소는 메모이제이션을 통해 시간복잡도를 줄여야한다.
                     */
                    ch[i] = 1;
                    DFS(L + 1, (nums * 10) + arr[i]);
                    ch[i] = 0;
                }
            }

        }
    }
    public int solution(int n){
        answer = -1;
        target = n;
        flag = false; // 탈출 플래그

        String str = String.valueOf(n);
        len = str.length();
        ch = new int[len]; // 체크배열
        /*
            자연수 n과 구성이 같은 숫자로 중 n보다 큰 수 중 가장 작은 수를 반환하는 문제
            - 큰 수들을 모든 구한 후 작은 수를 구하면 time limit 납니다.
                - 큰 수의 모든 경우의 수를 구해야하기 때문
            - 시간복잡도를 줄이려면 자연수 n을 정렬해서 작은 경우의 수부터 찾아 n보다 크면 바로 반환을 하도록 합니다.
            - 즉, 정렬을 하는 이유✨는 만들어지는 조합의 수의 순서가 오름차순으로 나타나게 하기 위해서 입니다.
         */
        arr = new int[len]; // 순열배열
        for (int k = 0; k < len; k++) {
            arr[k] = Integer.parseInt(String.valueOf(str.charAt(k)));
        }
        Arrays.sort(arr);

        DFS(0, 0);

        return answer;
    }

    public static void main(String[] args){
        Ex06_01_02_Answer T = new Ex06_01_02_Answer();
        System.out.println(T.solution(123)); //132
        System.out.println(T.solution(321)); //-1
        System.out.println(T.solution(20573)); //20735
        System.out.println(T.solution(27711)); //71127
        System.out.println(T.solution(54312)); //54321
    }
}
