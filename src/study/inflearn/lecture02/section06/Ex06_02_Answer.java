package study.inflearn.lecture02.section06;

import java.util.Stack;

/**
 * 줄다리기 - 깊이우선탐색 : DFS
 * 순열
 */
public class Ex06_02_Answer {

    int answer;
    final int level = 8;
    int[] ch;
    int[][] relation;
    Stack<Integer> stack;

    public void DFS(int L){
        if(L==(level-1)) answer++;
        else{
            for(int i = 1; i < level; i++){
                //if (!stack.empty() && relation[stack.peek()][i] == 1) continue;
                if (!stack.empty() && relation[i][stack.peek()] == 1) continue;
                // 왜 [stack.peek()][i]만 비교하는 건지? [i][stack.peek()]도 비교해야 되는 거 아닌지 의문이 들었음. stack.pop을 하기 때문에 재귀에 의해서 반대도 비교하게 되어 있음.
                if (ch[i] == 0) {
                    ch[i] = 1;
                    stack.push(i);
                    DFS(L+1);
                    ch[i] = 0;
                    stack.pop(); // 다음 경우의 수도 계산하기 위함
                }
            }
        }
    }
    public int solution(int[][] fight){
        answer = 0;
        stack = new Stack<>();
        ch = new int[level]; // 순열 판별

        // 2차원 배열에 싫어하는 관계 표시
        relation = new int[level][level]; // 학생의 고유번호는 1~ 7번까지, 7번 인덱스까지 존재해야 하므로 level 8로 초기화
        for (int[] x : fight) {
            int a = x[0];
            int b = x[1];
            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        DFS(0);

        return answer;
    }

    public static void main(String[] args){
        Ex06_02_Answer T = new Ex06_02_Answer();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}})); //1968
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}})); //864
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}})); //720
        System.out.println(T.solution(new int[][]{{1, 7}})); //3600
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}})); //646
    }
}
