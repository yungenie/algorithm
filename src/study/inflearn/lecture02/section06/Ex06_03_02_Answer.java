package study.inflearn.lecture02.section06;

import java.util.ArrayList;

/**
 * 바둑대회 - 깊이우선탐색 : DFS (조합문제)
 * 2회독 30분 고민해봤지만 못품
 *  고민했던 부분
 *  - DFS 매개변수
 *  - 흰돌/검은돌 체크 배열을 1개 생성 vs 2개 생성
 *  - 흰돌/검은돌 정보를 담을 배열 (어떤 값을 담아야 하는 지)
 */
public class Ex06_03_02_Answer {
    int n, answer;
    int[] ch;
    int[][] cans;
    public void DFS(int L, int s) {
        // 탈출조건
        if (L == n/2){ // 매번 조합이 완성될 때마다 능력치 최소값 구하기
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for(int j = 0; j < n; j++){ // 체크배열에서 1 : 흰돌, 0 : 검은돌 로 구성
                if(ch[j] == 1) A.add(j); // 1로 체크된 선수는 A팀
                else B.add(j); // 체크가 안된 선수는 B팀
            }
            int sumA = 0, sumB = 0;
            for(int k = 0; k < L; k++){ // ✨ n/2까지 반복하면서 cans의 해당하는 인덱스 가져와서 합하기
                sumA += cans[A.get(k)][0]; // 흰돌팀 합
                sumB += cans[B.get(k)][1]; // 검은돌팀 합
            }

            answer = Integer.min(answer, Math.abs(sumA-sumB));
        } else {
            /*
                ✨반목문의 초기화, 조건식이 왜 아래와 같이 선언해야하는 지?
                - int i = s; s는 i+1이다.
                - 예를 들어 n이 4일때
                    - 레벨 0인 경우 자식은 0,1,2,3
                    - 자식 0은 1,2,3
                    - 자식 1은 2,3으로 뻗어가야한다. 0부터 다시 뻗지 않는 이유는 앞에서 이미 0,1로 흰팀으로 구성해봤음.
                - n은 주어진 숫자 다 비교해봐야한다.
                - 부모레벨부터 자식레벨에서의 값이 어떻게 될지 어느 범위까지 도는 지 잘 생각해야한다.
             */
            for (int i = s; i < n ; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1; // 흰돌팀
                    DFS(L + 1, i + 1);
                    ch[i] = 0; // 검은돌팀
                }
            }
        }
    }
    public int solution(int[][] cans){
        this.cans = cans;
        answer = Integer.MAX_VALUE;
        n = cans.length;
        /*
            ✨1개의 체크 배열로 생성하는 이유?
            - cans.length(n)/2 크기의 2개의 배열이 생성되면 구현하기 더 복잡해진다.
            - cans 2차원 배열 행은 출전구성 열의 0번째는 흰돌, 1번째는 검은돌로 구성되어있다.
            - 출전구성의 열 중에 흰돌/검은돌 둘 중 하나만 출전할 수 있다.
            - 그렇기 때문에 n번째 출전구성에서 흰돌이 출전한 경우 n번째 검은 돌은 출전하지 못하기 때문에
            - 어차피 흰돌 체크 배열에 체크를 하고 동시에 검은돌 체크 배열에도 체크를 해야하는 번거로움이 있다.
            - 그렇기 때문에 1개로 편의상 관리한다. 그래야 나중에 합산할 때도 접근하기 수월하다.
         */
        ch = new int[cans.length]; // 1:흰돌, 0:검은돌
        DFS(0, 0);
        return answer;
    }

    public static void main(String[] args){
        Ex06_03_02_Answer T = new Ex06_03_02_Answer();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
