package study.programmers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Level5_방의개수_Answer {
    class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x,y);
        }

        public boolean equals(Object o) {
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }
    public int solution(int[] arrows) {
        // 초기화
        int cnt = 0;
        Pair node = new Pair(0, 0);

        // x,y 방향 배열 선언
        int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };


        // 방문 여부 선언
        // key = 시작 node의 hashcode, value = 연결된 node들의 hashcode
        HashMap<Pair, ArrayList<Pair>> visitied = new HashMap<>();

        // 로직 처리
        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // todo 파악필요 - 교차점 처리를 위한 스케일업(반복 2번)

                // 이동 진행
                Pair newNode = new Pair(node.x + dx[arrow], node.y + dy[arrow]);

                // 다음 node 처음 방문하는 경우 = map에 키값이 없는 경우
                if (!visitied.containsKey(newNode)) {

                    // 리스트에 다음 node에 따른 현재 node 추가
                    visitied.put(newNode, makeEdgeList(node));

                    // 현재 노드 방문여부에 따라 리스트 업데이트 및 추가
                    if(visitied.get(node) == null) { // 현재 노드 첫방문이면 업데이트
                        visitied.put(node, makeEdgeList(newNode));
                    } else {  // 현재 노드 재방문이면 다음 node 추가
                        visitied.get(node).add(newNode);
                    }

                // 재방문했고 간선을 처음 통과하는 경우
                } else if (visitied.containsKey(newNode) && !(visitied.get(newNode).contains(node))) {
                    visitied.get(newNode).add(node);
                    visitied.get(node).add(newNode);
                    cnt++;
                }

                // 이동 완료
                node = newNode;
            }
        }

        return cnt;
    }

    // 밸류값에 넣기 위한 리스트 만들기
    public ArrayList<Pair> makeEdgeList(Pair point) {
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(point);
        return edge;
    }
    public static void main(String[] args) {
        Level5_방의개수_Answer T = new Level5_방의개수_Answer();
        System.out.println(T.solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}));
    }
}
