package study.etc.study;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 경로탐색(인접리스트, ArrayList)
 * 방향그래프 - 1번 정점에서 N번 정점으로 가는 모든 경우의 수
 */
public class Graph_AdjacencyMatrix_ArrayList {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int L){
        if(L==n) answer++;
        else{
            for(int nl : graph.get(L)){ // nl : next element
                if(ch[nl]==0){
                    ch[nl]=1;
                    DFS(nl);
                    ch[nl]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph_AdjacencyMatrix_ArrayList T = new Graph_AdjacencyMatrix_ArrayList();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }

}
