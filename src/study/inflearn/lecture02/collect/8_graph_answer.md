# 그래프 정답 코드 정리

# 1. 최소 비행료
- 문제 : 현수가 사는 도시에서 목적지 도시까지 가는데 드는 최소비용을 반환
- 인접리스트, 연결리스트, 다익스트라 변형

```java
public class Ex08_01_03_Answer {
    public int solution(int n, int[][] flights, int s, int e, int k) {
        int answer = -1;

        // 인접리스트 - 행 : 도시, 열 : {목적지,비용}
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]}); // {목적지, 비용}
        }

        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[s] = 0; // 출발도시 비용 0으로 초기화

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0}); // {출발지, 비용}

        int L = 0;
        while (!q.isEmpty()){
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();
                int curPlace = cur[0]; //출발지
                int curCost = cur[1]; //출발지 비용
                for (int[] info : graph.get(curPlace)) { // 목적지 도시 탐색
                    int nextPlace = info[0]; // 목적지
                    int nextCost = info[1]; // 목적지 비용
                    int cost = curCost + nextCost; // 출발지에서 목적지까지 비용
                    if (costs[nextPlace] > cost) { // 기존비용 > 출발지에서 목적지까지 비용
                        costs[nextPlace] = cost; // 최소비용을 찾는 문제이므로, 더 저렴한 비용을 선택
                        q.offer(new int[]{nextPlace, cost}); //목적지, 비용
                    }
                }
            }
            if (L > k) break; // 최소 환승 횟수 (레벨은 0부터 시작하는 것을 생각하기)
        }
        // 현수가 목적지까지 갈 수 없으면 비용은 최대로 초기화 되어 있기 때문에 아래 조건으로 처리
        return costs[e] == Integer.MAX_VALUE ? answer : costs[e];
    }

    public static void main(String[] args) {
        /*
            문제 : 현수가 사는 동네에서 목적지까지 가는데 최소비용
            n 도시, 출발s -> 도착e, 직항 없으면 환승 가능 (k번 가능)
         */
        Ex08_01_03_Answer T = new Ex08_01_03_Answer();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59}, {2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
```

# 2. 최소 환승 경로
- 문제 : 출발역에서 도착역까지 최소 환승 경로로 이동했을 때 최소 환승 횟수

```java
public class Ex08_02_03_Answer {
    public int solution(int[][] routes, int s, int e){

        // 역에 대한 지하철 호선들 해싱
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length; // 전체 호선
        for (int i = 0; i < n; i++) {// 전체 호선에 대한 역탐색
            for (int route : routes[i]) { // 역
                graph.putIfAbsent(route, new HashSet<>());
                graph.get(route).add(i); // 역, {호선들} 예를들어 1역:{1호선, 2호선}
            }
        }
        // 지하철 호선 체크
        int[] ch = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(s); // 출발역

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int curStaion = q.poll(); // 출발역
                for (Integer line : graph.get(curStaion)) { //출발역에서 환승 가능한 호선들
                    if (ch[line] == 1) continue;
                    ch[line] = 1;
                    for (int station : routes[line]) {
                        if (station == e) return L; // 도착역 탐색
                        q.offer(station); // 환승 가능한 호선에 있는 역 넣기
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args){
        Ex08_02_03_Answer T = new Ex08_02_03_Answer();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}

```
# 3. 벽 허물기
- 현수가 (0, 0) 지점에서 (n-1, m-1)지점까지 가기 위해서 허물어야 하는 최소 벽의 개수

```java
public class Ex08_03_03_Answer {
    public int solution(int[][] board) {
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)

        int[][] cost = new int[n][m]; // 비용
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = board[0][0]; // 출발지점 비용 초기화

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // 비용 오름차순
        pq.offer(new int[]{0, 0, board[0][0]}); // {행, 열, 비용}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[2] > cost[cur[0]][cur[1]]) continue; // 이미 최대값으로 초기화 되어 있는데, 그것보다 크면 스킵해야된다.

            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int nextCost = cur[2] + board[nx][ny];
                if (cost[nx][ny] > nextCost) {
                    cost[nx][ny] = nextCost;
                    pq.offer(new int[]{nx, ny, nextCost});
                }
            }
        }
        return cost[n-1][m-1];
    }

    public static void main(String[] args){
        Ex08_03_03_Answer T = new Ex08_03_03_Answer();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
```