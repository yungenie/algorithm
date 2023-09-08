# 그래프 최단거리 정답 코드 정리

# 1. 최소 비행료 (인접리스트, 다익스트라 변형 LinkedList)
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

# 2. 최소 환승 경로 (연결되는 지점 LinkedList, 해싱)
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
# 3. 벽 허물기 (다익스트라 PriorityQueue)
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

            if (cur[2] > cost[cur[0]][cur[1]]) continue;

            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                // ✨ 꺼낸 지점의 최신화된 비용보다 꺼낸 지점의 비용이 더 크다면 다음 레벨 뻗지 않는다.
                // 최소값을 구하는 문제이므로, 이미 최소비용이 있기 때문에 더 이상 다음 레벨을 계산하지 않는다.
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


# 4. 방향 바꾸기 (다익스트라 PriorityQueue)
- 현수가 (0, 0) 지점에서 (n-1, m-1)지점까지 가기 위해서 방향을 바꾸어야 하는 최소 격자의 개수
- 한 격자의 방향은 현수가 원하는 방향으로 오직 한번 바꿀 수 있다.
    - 의미해석 : 한 격자의 방향이 달라지면 비용이 1씩 든다.
    - 예를 들어, 3의 방향인데 2방향으로 간다면 그 비용이 1 들고, 1방향으로 가도 비용이 1이 든다.
    - 코드조건으로 본다면 3!=방향 => 비용이 1씩 든다.

```java
public class Ex08_04_Answer {
    public int solution(int[][] board) {
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)

        // 방향배열 (순서 : 오른쪽 > 왼쪽 > 아래 > 위)
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[0][0] = 0; // 출발지점

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0}); // {행, 열, 비용(방향을 바꿀 때 1의 비용이 든다)}

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            // ✨ 꺼낸 지점의 최신화된 비용보다 꺼낸 지점의 비용이 더 크다면 다음 레벨 뻗지 않는다.
            // 최소값을 구하는 문제이므로, 이미 최소비용이 있기 때문에 더 이상 다음 레벨을 계산하지 않는다.
            if(cur[2] > cost[cur[0]][cur[1]]) continue;

            for(int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int dir = board[cur[0]][cur[1]] - 1;
                if(k == dir && cost[nx][ny] > cur[2]) {
                    cost[nx][ny] = cur[2];
                    pq.offer(new int[]{nx, ny, cur[2]});
                }
                else { // 해당 지점의 방향과 다른 방향일 때 1의 비용
                    if (cost[nx][ny] > cur[2] + 1) {
                        cost[nx][ny] = cur[2] + 1;
                        pq.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }
        return cost[n - 1][m - 1];
    }
    public static void main(String[] args){
        Ex08_04_02 T = new Ex08_04_02();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
```

# 5. 공 굴리기 (다익스트라 PriorityQueue)
- 시작위치에서 목표위치까지 이동하는 최단거리를 반환
- 상, 하, 좌, 우 네 방향으로 빈 공간을 수직 또는 수평으로 이동하다가 벽을 만나면 멈춥니다.

```java
public class Ex08_05_Answer {
    public int solution(int[][] board, int[] s, int[] e){
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)

        // 다익스트라 비용 초기화
        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[s[0]][s[1]] = 0; // 출발지점 비용 초기화

        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pQ.offer(new int[]{s[0], s[1], 0});

        // 다익스트라 최소 격자 이동 수
        while (!pQ.isEmpty()) {
            int[] cur = pQ.poll();

            if (cur[2] > cost[cur[0]][cur[1]]) continue;// BFS에서 체크한 지점 안가는 것도 동일한 효과의 역할
            if (cur[0] == e[0] && cur[1] == e[1]) return cost[cur[0]][cur[1]]; // 도착지점에 도착했을 때 반환

            // 겪자밖 또는 벽을 만날때까지 이동
            for(int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) { // 방향 배열 (상하좌우)
                int nx = cur[0]; // 행
                int ny = cur[1]; // 열
                int cnt = cur[2]; // 이동거리

                // 빈공간일 경우에만 쭉 이동해서 벽의 지점까지 도착해서 멈춘다.
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    nx += dir[0]; // 멈추는 행 지점
                    ny += dir[1];  // 멈추는 열 지점
                    cnt++; // 멈추는 지점까지 이동거리
                }
                // 그러므로 벽 지점의 위치와, 이동거리를 빼준다.
                nx -= dir[0];
                ny -= dir[1];
                cnt--;

                if (cost[nx][ny] > cnt){
                    cost[nx][ny] = cnt;
                    pQ.offer(new int[]{nx, ny, cnt});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Ex08_05_Answer T = new Ex08_05_Answer();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
```

# 6. 교육과정 (위상정렬, 인접리스트, LinkedList)
- 현수가 n개의 과목을 모두 이수할 수 있는 순서를 배열 반환
- 답이 여러개면 그 중 아무거나 반환
- 조건 : 
  - 교육과목에는 선수과목이 있습니다. 
  - 만약 ["art math"]라는 정보는 art과목을 수강하기 위해서 는 math과목을 먼저 수강해야 합니다.

```java
public class Ex08_06_04_Answer {
    /**
     *
     * @param subjects : 과목목록
     * @param course : 선수과목 정보
     * @return 이수과목 배열 
     */
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length; // 전과목 개수

        // 과목별 인덱싱
        HashMap<String, Integer> subjectsHash = new HashMap<>();
        for (int idx = 0; idx < n; idx++) {
            subjectsHash.put(subjects[idx], idx);
        }

        // 인접리스트 초기화 (선수과목 - 교육과목들)
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
        }
        int[] indegree = new int[n]; // 진입차수 초기화
        for (String info : course) {
            int preSubIdx = subjectsHash.get(info.split(" ")[1]);
            int postSubIdx = subjectsHash.get(info.split(" ")[0]);
            //선수과목의 교육과목들 셋팅(선수과목 먼저 수강 후, 들을 수 있는 수강과목들 넣기)
            relation.get(preSubIdx).add(postSubIdx);
            indegree[postSubIdx]++; // 해당 수강과목은 선수과목이 있다는 뜻으로 진입차수 증감 (선수과목 개수 카운팅)
        }

        // 위상정렬 알고리즘 수행
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i); // 선수과목이 없는 교육과목부터 탐색
        }
        while (!q.isEmpty()) {
            int sub = q.poll();
            result.add(sub); 
            for (Integer x : relation.get(sub)) {
                indegree[x]--;
                if (indegree[x] == 0) q.offer(x);
            }
        }

        // 정답 반환
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = subjects[result.get(i)];
        }
        return answer;
    }
    public static void main(String[] args){
        Ex08_06_04_Answer T = new Ex08_06_04_Answer();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
```