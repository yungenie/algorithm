package study.etc.study;

public class UnionFind {
    static int[] parent;

    public static void main(String[] args) {
        int n = 5;
        parent = new int[n + 1];

        // 부모 노드 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //위의 예제 실행
        union(1, 2);
        parentPrint();
        union(3, 4);
        parentPrint();
        union(3, 5);
        parentPrint();
        System.out.println("find(2): " + find(2));
        System.out.println("find(4): " + find(4));
        union(2, 4);
        parentPrint();
        System.out.println("find(4): " + find(4));
    }

    // 두 노드의 연결
    public static boolean union(int x, int y) {
        x = find(x); // x의 부모노드 찾기
        y = find(y); // y의 부모노드 찾기

        // 이미 같은 그래프에 속해 있을 때 false 반환
        if (x == y) return false;
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    // 부모 노드 찾기
    public static int find(int z) {
        if (parent[z] == z) return z;
        return find(parent[z]);
    }

    // parent 출력
    public static void parentPrint() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i]+ " ");
        }
        System.out.println("]");
    }
}
