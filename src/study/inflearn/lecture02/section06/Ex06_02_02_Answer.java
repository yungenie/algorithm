package study.inflearn.lecture02.section06;

import java.util.Stack;

/**
 * 줄다리기 - 깊이우선탐색 : DFS (순열)
 * 2회독 30분 고민해봤지만 못품
 * 구현했던 부분
 * - DFS 구조 틀
 * - 서로 싫어하는 학생 2차원 메모이제이션
 * - 중심 로직인 순열을 만드는 부분에서 막혔다.
 */
public class Ex06_02_02_Answer {

    int n = 7;
    Stack<Integer> pm; // 순열(permutation)을 담는 자료
    int[][] relation; // 싫어하는 학생 정보
    int[] ch; // 학생의 사용 체크
    int answer;
    public void DFS(int L) {
        // 탈출조건
        /*
            원래는 DFS(int L, int nums) 레벨과 순열을 매개변수로 담아 탈출 조건을 처리하려고 했음.
            nums을 제외해도 되는 이유는?
                - 어차피 7자리 숫자가 만들어졌을 때 경우의 수를 구하는 게 목적
                - 레벨 7이면 자동으로 7자리가 만들어졌기 때문에 nums는 필요 없음.
         */
        if(L == n){
            answer++;
        }else {
            for (int i = 1; i <= n; i++) { // 순열의 숫자가 1부터 시작이므로 i는 1로 초기화
                /*
                    relation[pm.peek()][i] == 1 || relation[i][pm.peek()] == 1
                    서로 싫어하는 학생 앞뒤 크로스로 체크해도 되지만
                    재귀에 의해서 자동으로 앞뒤 크로스 체크 된다.
                 */
                if (!pm.isEmpty() && relation[pm.peek()][i] == 1) continue;
                if(ch[i] == 0){
                    ch[i] = 1;
                    System.out.println("L = " + L+1);
                    /*
                       pm.push(L + 1)
                       L+1로 하게 된다면 재귀에 의해서 계속 증가하는 순열이 되버린다.
                       문제에서 구하고자 하는 바는 1~7개의 숫자들 중 7개로 나열하는 경우의 수이므로 i로 채택 해야한다.
                       결국에 statck에 어떤 숫자를 넣어야 하는 지 정의를 잘 해야한다.
                     */
                    pm.push(i);
                    DFS(L+1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;

        // 싫어하는 학생 정보 2차원 배열로 메모이제이션
        relation = new int[n + 1][n + 1];
        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        // 주어진 학생의 사용 체크배열 (이미 사용한 학생 중복으로 사용하지 않게 처리)
        ch = new int[n + 1];
        /*
            Stack은 queue(인터페이스)와 달리 클래스이다.
            ArrayList는 List 인터페이스의 구현체
         */
        // 순열의 조합을 만들기 위한 자료담기
        pm = new Stack<>();
        DFS(0);

        return answer;
    }

    public static void main(String[] args){
        Ex06_02_02_Answer T = new Ex06_02_02_Answer();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
