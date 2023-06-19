package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_03_Answer {
    public int solution(int s, int e){
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++; // 레벨과 시간의 흐름 초로 정의
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx >= 0 && nx <= 200000 && ch[L%2][nx] == 0){
                        ch[L%2][nx] = 1; // 현수가 방문한 위치 체크
                        Q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return L; // 송아지의 현재 위치에 현수가 갔으면 만난 것으로 보고 반환
        }
        return -1;

    }

    public static void main(String[] args){
        Ex07_03_Answer T = new Ex07_03_Answer();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
