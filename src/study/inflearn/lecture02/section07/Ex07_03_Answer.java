package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지를 잡자 - 넓이우선탐색 : BFS
 */
public class Ex07_03_Answer {
    public int solution(int s, int e){
        int[][] ch = new int[2][200001]; // 행 : 이동한 위치, 열 : 짝수0/홀수1 레벨(시간)
        ch[0][s] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s); // 현수 이동한 위치 넣기

        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++; // 시간의 흐름 초로 정의(레벨)
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx >= 0 && nx <= 200000 && ch[L%2][nx] == 0){ // 짝수/홀수 방문여부 확인
                        ch[L%2][nx] = 1; // 현수가 방문한 위치 체크
                        Q.offer(nx);
                    }
                }
            }
            e = e + L; // 송아지 이동한 위치 (L : 이전이동거리 + 1)
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return L; // 송아지의 현재 위치에 현수가 갔으면 만난 것으로 보고 반환
        }
        return -1;
    }

    public static void main(String[] args){
        /*
            문제 : 현수가 송아지를 잡는 가장 빠른 시간
            움직이는 생명 : 2명
            도착지점 : 유동 (움직이다 만나는 지점)
            가중치 :
                - A : 이동한 위치 +1/-1/*2 3가지 존재
                - B : 이전이동거리 + 1

            L%2로 체크하는 이유?
            - 패턴을 분석하면 한레벨 거치면 전전레벨의 경우의 수를 포함하고 있다.
            - 홀수/짝수로 나눠서 체크만 하면 된다.

           문제해독
            - 이전이동거리 + 1 의미가 그냥 1씩 증가한다는 의미로 받아들임
            - 송아지 이동경로를 상세히 봤다면 1,2,3,4, ... 증가한다는 걸 알 수 있음.
         */
        Ex07_03_Answer T = new Ex07_03_Answer();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
