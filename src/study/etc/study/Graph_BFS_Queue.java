package study.etc.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 그래프 최단거리 BFS
 * 방향그래프 - 1번 정점에서 각 정점으로 가는 최소 이동 간선 수
 */
public class Graph_BFS_Queue {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int L){
        ch[L]=1;
        dis[L]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(L);
        while(!queue.isEmpty()){
            int cv=queue.poll(); //cv : current vertex
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv]=dis[cv]+1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph_BFS_Queue T = new Graph_BFS_Queue();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
