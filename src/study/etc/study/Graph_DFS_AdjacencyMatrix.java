package study.etc.study;

import java.util.Scanner;

/**
 * 그래프 - 경로탐색(인접행렬)
 * 방향그래프 - 1번 정점에서 N번 정점으로 가는 모든 경우의 수
 */
public class Graph_DFS_AdjacencyMatrix {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int L){
        if(L==n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[L][i]==1 && ch[i]==0){ // 해당 레벨에서 모든 경우의 수
                    ch[i]=1; // 방문한 지점 체크
                    DFS(i);
                    ch[i]=0; // Back Tracking 체크 풀기
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph_DFS_AdjacencyMatrix T = new Graph_DFS_AdjacencyMatrix();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt(); // 5
        m=kb.nextInt(); // 9

        graph=new int[n+1][n+1]; // 1부터 N까지 표시
        ch=new int[n+1]; // 1부터 N까지 방문지점 체크
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph[a][b]=1;
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }

}
