# BFS(너비우선탐색) 정답 코드 정리

# 목차
1. 타일점프 (수직선상 집에서 상점까지 가는 최소 점프 횟수, 출발/도착 대상 : 문제 그대로, 이동하는 지점의 방문 조건 : 1차원 체크배열, 이동거리 누적 안함, 최소값 : 레벨 반환)
2. 집으로 이동 (수직선상 집으로 가는 최소 점프 횟수, 출발/도착 대상 : 문제 그대로, 이동하는 지점의 방문 조건 : 재정의, 이동거리 누적 안함, 최소값 : 레벨 반환)
3. 송아지를 잡자 (수직선상 가장 빠른 시간, 출발/도착 대상 : 문제 그대로, 이동하는 지점의 방문 조건 : 재정의/레벨 규칙화, 이동거리 누적 안함, 최소값 : 레벨 반환)
4. 미로의 최단거리 통로 (지도에서 탈출하는 최단경로 , 출발/도착 대상 : 문제그대로, 이동하는 지점의 방문 조건 : 어떤 조건만 허용, 이동거리 누적 안함, 최소값 : 도착지점의 이동거리값 반환)
5. 집을 짓자 (지도에서 이동거리의 총합의 최소값 , 출발/도착 대상 : 문제그대로, 이동하는 지점의 방문 조건 : 출발대상 탐색 할때 재정의, 이동거리 누적, 최소값 : 레벨탐색 안에서 찾기)
6. 숲속의 기사 (지도에서 이동하는 가장 짧은 날 수, 출발/도착 대상 : 재정의, 이동하는 지점의 방문 조건 : 어떤 지점이 아닐때, 이동거리 누적, 최소값 : 이동거리 배열의 산딸기 지점 중 최소값)


# 1. 타일점프 (수직선상 집에서 상점까지 가는 최소 점프 횟수, 출발/도착 대상 : 문제 그대로, 이동하는 지점의 방문 조건 : 1차원 체크배열, 이동거리 누적 안함, 최소값 : 레벨 반환)
- 문제 : 수직선상 집에서 상점까지 가는 최소 점프 횟수
- 출발/도착 대상 : 문제 그대로
- 이동하는 지점의 방문 조건 : 1차원 배열로 체크
- 이동 거리 : 레벨탐색하면서 L++로 처리한다.
- 최소값 : 점프하다가 도착점에 도착하면 레벨 반환

```java
public class Ex07_01_02_Answer {

    public int solution(int[] nums){
        int n = nums.length; // 배열의 크기
        int[] ch = new int[n]; // 타일의 사용 체크
        ch[0] = 1; // 무조건 0번째부터 출발하므로 체크해둔다.
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // ✨ 배열의 인덱스를 넣어 탐색한다. (타일의 위치)

        // BFS 레벨탐색
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll(); //현재레벨, 배열의 인덱스
                for (int j = 1; j <= nums[cur]; j++) { // ✨배열의 인덱스에 해당하는 점프력들 탐색
                    int jump = cur + j; //자식레벨 (점프하는 다음 타일)
                    if (jump == n-1) return L+1;
                    if (jump < n && ch[jump] == 0) {
                        ch[jump] = 1;
                        q.offer(jump);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){

        /*
            메모이제이션 1차원으로 하는 이유?
            - 타일이 행열로 되어 있는 게 아니라, 1차원 배열의 인덱스가 위치이다.
            - 집(0번째)에서 상점(n-1번째)까지의 타일(거리) 중에 최소 점프 횟수를 구하는 문제이므로
            - 1차원 체크배열을 생성하여 한 번 갔던 타일은 1로 체크 표시를 한다.

            i번째 타일 위에서 오른쪽으로 Ai이하만큼 점프
            - nums[i] == Ai
            - 예를들어
                - 0번째 타일에서 2이하만큼 점프를 한다면,
                - 0 -> 0,1,2타일로 점프해서 이동할 수 있다.
                - 1번째 타일에서 3이하만큼 점프를 한다면,
                - 1 -> 1,2,3,4타일로 점프할 수 있다.
                - 0의 점프력은 제자리 걸음이기 때문에 굳이 계산하지 않고 1의 점프력부터 레벨 탐색을 한다.
            - * 문제를 제대로 파악하지 못해 Ai ~ i + Ai 만큼 이동할 수 있구나 착각함.
         */
        Ex07_01_02_Answer T = new Ex07_01_02_Answer();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
```


# 2. 집으로 이동 (수직선상 집으로 가는 최소 점프 횟수, 출발/도착 대상 : 문제 그대로, 이동하는 지점의 방문 조건 : 재정의, 이동거리 누적 안함, 최소값 : 레벨 반환)
- 문제 : 수직선상 0에서 집으로 가는 최소 점프 횟수
- 출발/도착 대상 : 문제 그대로
- 이동하는 지점의 방문 조건 : 2차원 체크 배열로 행 : 이동지점, 열 : 앞(0)/뒤(1) 체크, 뒤로 2번 점프 못함
- 이동 거리 : 레벨탐색하면서 L++로 처리한다.
- 최소값 : 점프하다가 도착점에 도착하면 레벨 반환

```java
public class Ex07_02_Answer {
    public int solution(int[] pool, int a, int b, int home){

        // 방문한 위치 체크 초기화
        int[][] ch = new int[2][10001]; // 열 : 첫번째-앞점프(0) 두번째-뒤점프(1), 행 : 점프 위치
        // 웅덩이 지점 못가게 체크
        for (int x : pool) {
            ch[0][x] = 1; // 0행:앞으로 점프
            ch[1][x] = 1; // 1행:뒤로 점프
        }

        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0}); // {점프한 위치(배열의 인덱스), 점프 앞(0)/뒤(1) 플러그}
        // 현수 위치 체크
        ch[0][0] = 1;
        ch[1][0] = 1;
        
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            // 레벨 탐색
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();

                if(cur[0] == home) return L; // 집도착

                // 앞으로 점프
                int nx = cur[0] + a;
                if (nx <=10000 && ch[0][nx] == 0) { // ch[0][nx] == 0 앞으로 점프해서 방문한 첫 위치
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }

                // 뒤로 점프
                nx = cur[0] - b;
                if (nx >= 0 && ch[1][nx] == 0 && cur[1] == 0) {
                    // 방문가능한 위치인지, 연속 뒤로 점프하지 않기 위해 현재레벨이 뒤 점프를 했는 지 확인
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        /*
            체크배열 : 방문한 지점을 재방문 하지 않도록 시간복잡도(비용)을 줄인다.
            뒤쪽으로 연속 두번 점프 못한다. (1이 아닐때만 or 0일 때만)
            가면 안되는 웅덩이에 대한 조건 주어짐.

            움직이는 생명 : 1명
            도착지점 : 고정
            가중치 : 이동한 위치에 가중치가 앞/뒤로 2개 존재함.
         */
        Ex07_02_Answer T = new Ex07_02_Answer();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
```

# 3. 송아지를 잡자 (수직선상 가장 빠른 시간, 출발/도착 대상 : 문제 그대로, 이동하는 지점의 방문 조건 : 재정의/레벨 규칙화, 이동거리 누적 안함, 최소값 : 레벨 반환)
- 문제 : 현수가 송아지를 잡는 가장 빠른 시간
- 출발/도착 대상 : 문제 그대로
- 이동하는 지점의 방문 조건 : 2차원 체크배열을 사용해서 짝수/홀수 레벨의 방문지점을 체크한다.
- 이동 거리 : 레벨탐색을 하면서 L++로 처리한다.
- 최소값 : 레벨탐색으로 현수 이동지점을 체크배열로 체크하고, 송아지가 이동하는 지점이 체크되어 있으면 레벨을 반환

```java
public class Ex07_03_Answer {
  public int solution(int s, int e) {
    int[][] ch = new int[2][200001]; // 열 : 짝수0/홀수1 레벨(시간), 행 : 이동한 위치
    ch[0][s] = 1;
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(s); // 현수 이동한 위치 넣기

    int L = 0;
    while (!Q.isEmpty()) {
      int len = Q.size();
      L++; // 시간의 흐름 초로 정의(레벨)
      for (int i = 0; i < len; i++) {
        int x = Q.poll();
        for (int nx : new int[]{x - 1, x + 1, x * 2}) {
          if (nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0) { // 짝수/홀수 방문여부 확인
            ch[L % 2][nx] = 1; // 현수가 방문한 위치 체크
            Q.offer(nx);
          }
        }
      }
      e = e + L; // 송아지 이동한 위치 (L : 이전이동거리 + 1)
      if (e > 200000) return -1;
      if (ch[L % 2][e] == 1) return L; // 송아지의 현재 위치에 현수가 갔으면 만난 것으로 보고 반환
    }
    return -1;
  }

  public static void main(String[] args) {
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
```

# 4. 미로의 최단거리 통로 (지도에서 탈출하는 최단경로 , 출발/도착 대상 : 문제그대로, 이동하는 지점의 방문 조건 : 어떤 조건만 허용, 이동거리 누적 안함, 최소값 : 도착지점의 이동거리값 반환)
- 문제 : 미로를 탈출하는 최단경로 길이 반환
- 출발/도착 대상 : 출발 대상은 (0,0) 도착 대상은 (6,6)
- 이동하는 지점의 방문 조건 : 도로만 이동가능 하게 처리
- 이동거리 누적 안함 : 출발 대상이 1개 뿐 이므로 누적 안한다.
- 최소값 : 도착지점이 1개로 정해져 있으므로 이동거리 배열에서 도착지점을 반환한다. (출발지점부터 도착지점까지의 최소 거리값이 구해진다.)

```java
public class Ex07_04_03_Answer {
    public int solution(int[][] board){
        int[][] dist = new int[7][7]; // 출발지점에서 거리를 계산하는 배열 (이동횟수)
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0}); //출발지점

        int L = 0;
        while(!Q.isEmpty()){ // BFS 레벨 탐색
            // 2차원 배열에서 최단 거리를 구할 때 먼저 증가.
            L++; // L레벨 먼저 증가 (자식노드 레벨) L 값을 미리 증가
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                // 자식레벨 탐색
                for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향 배열 (인접한 4방향)
                    int nx= cur[0] + dir[0];
                    int ny= cur[1] + dir[1];
                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
                        board[nx][ny] = 1; // 방문한 지점 벽으로 만들기, 움직이는 대상이 1명 뿐이라서 가능
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L; // 레벨 저장(이동횟수)
                    }
                }
            }
        }
        // 도착지점 반환
        if(dist[6][6]==0) return -1;
        else return dist[6][6];
    }
    public static void main(String[] args){
        Ex07_04_03_Answer T = new Ex07_04_03_Answer();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
        int[][] arr2={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr2));
    }
}
```

# 5. 집을 짓자 (지도에서 이동거리의 총합의 최소값 , 출발/도착 대상 : 문제그대로, 이동하는 지점의 방문 조건 : 출발대상 탐색 할때 재정의, 이동거리 누적, 최소값 : 레벨탐색 안에서 찾기)
- 문제 : 각 빌딩의 이동거리의 총합의 최소값 반환 (최소지점에 현수네 집 짓기)
  - 모든 빌딩에서 이동거리의 합이 최소가 되는 빈땅 지점에 집을 짓기
- 출발/도착 대상 : 출발 대상은 '빌딩', 도착 대상은 고정되지 않음. (빌딩의 이동거리 총합의 최소값)
- 이동하는 지점의 방문 조건 : 빌딩지점을 찾을 때 이동할 수 있는 지점을 emptyLand변수에 -1 감소한다. (emptyLand만 방문 가능하게 처리) 
- 이동거리 누적 : 빌딩의 방향배열로 각자 지도 내에서 움직일 수 있는 지점을 이동하며 이동하는 지점까지 온 이동거리를 누적한다.
- 최소값 : 빌딩지점으로 탐색을 하기 때문에 빌딩지점에서 이동하는 레벨탐색을 하면서 최소값을 구한다.

```java
public class Ex07_05_02_Answer {
    public int solution(int[][] board){ // 지도 정보
        int answer = 0;
        int n = board.length; // 지도의 크기
        int[][] dist = new int[n][n]; // 각 빌딩에서 i행,j열 지점으로 오는 이동거리의 합 (최소이동횟수)
        Queue<int[]> Q = new LinkedList<>(); // 빌딩의 이동거리 (빈땅으로만 이동가능)

        // 빌딩 배열에서 빌딩 찾아 빈땅으로 이동하며 각 빌딩으로부터 최적의 거리의 집 좌표 구하기
        int emptyLand = 0; // 빈땅, 각 빌딩들 빈땅으로의 거리 구할 때마다 감소
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) { // 빌딩 찾기
                    answer = Integer.MAX_VALUE; // 빌딩마다 초기화
                    Q.offer(new int[]{i, j}); // 빌딩의 좌표

                    int L = 0;
                    while(!Q.isEmpty()){
                        L++; // L레벨 먼저 증가 (자식노드 레벨)
                        int len = Q.size();
                        for(int k = 0; k < len; k++){
                            int[] cur = Q.poll();
                            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향 배열 (인접한 4방향)
                                int nx = cur[0] + dir[0]; // 이동하는 행좌표
                                int ny = cur[1] + dir[1]; // 이동하는 열좌표
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){ //시간복잡도를 줄이기 위해서 한번 방문했던 빈땅 체크하기
                                    board[nx][ny]--; // 규칙에 의해서 빈땅 감소하기
                                    dist[nx][ny] += L; // 모든 빌딩에서 이동하는 좌표의 이동거리 누적
                                    Q.offer(new int[]{nx, ny}); // 이동하는 좌표 넣기
                                    answer = Math.min(answer, dist[nx][ny]); // 이동거리의 최소합
                                }
                            }
                        }
                    }
                    emptyLand--; // 빌딩의 개수 만큼 감소된다.
                }
            }
        }
        // 빈땅이 없어서 막혔을 경우 -1 반환
        return answer == Integer.MAX_VALUE? -1 : answer;
    }

    public static void main(String[] args){
        Ex07_05_02_Answer T = new Ex07_05_02_Answer();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
```
# 6. 숲속의 기사 (지도에서 이동하는 가장 짧은 날 수, 출발/도착 대상 : 재정의, 이동하는 지점의 방문 조건 : 어떤 지점이 아닐때, 이동거리 누적, 최소값 : 이동거리 배열의 산딸기 지점 중 최소값)
- 문제 : 지도에서 영희가 산딸기를 기사에게 가져다주는 가장 짧은 날 수 반환
  - 문제에서 출발 대상은 '영희'와 '산딸기', 도착 대상은 '기사'
  - 문제 그대로 해석을 하면 영희 -> 산딸기, 산딸기 -> 기사로 이동해야하는 복잡한 로직이 되므로 아래와 같이 재정의 해야한다.
- 출발/도착 대상 : 출발 대상은 '영희'와 '기사', 도착 대상은 '산딸기'로 정의 해야한다.
  - 영희가 산딸기를 가지고 기사에게 전해주는 가장 짧은 날이나, 영희와 기사가 산딸기 지점까지 가장 짧은 날을 합하면 똑같은 의미가 된다. 
  - 그러므로 기사를 제2의 영희처럼 생각하고 움직이면 된다. 
- 이동하는 지점의 방문 조건 : 영희의 움직임 조건은 1의 지점을 제외하고 모두 움직일 수 있다. 
- 이동거리 누적 : 영희/기사가 방향배열로 각자 지도 내에서 움직일 수 있는 지점을 이동하며 이동하는 지점까지 온 이동거리를 누적한다.
- 최소값 : 영희/기사를 대상으로 레벨 탐색을 하기 때문에 모든 이동거리의 누적합을 구하고, 탐색이 끝나면 산딸기 지점 중 가장 작은 최소 값을 구한다. 
  - 산딸기 지점을 대상으로 탐색을 한게 아니기 때문에 5번과 다르게 탐색이 끝나면 정답을 구한다.  

```java
package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_06_02_Answer {
    public int solution(int[][] board){ // 숲의 지도 정보
        int n = board.length; // 가로(행)
        int m = board[0].length; // 세로(열)
        int[][] dist = new int[n][m]; // dist[i][j]는 영희와 기사가 딸기지점까지 가는 최소이동거리
        Queue<int[]> Q = new LinkedList<>(); // 영희와 기사의 이동좌표

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2 || board[i][j] == 3) { //2:영희, 3:기사(기사를 영희가 움직이는 것 처럼 생각하기)
                    Q.offer(new int[]{i, j}); // 영희와 기사의 이동좌표 넣기
                    int[][] ch = new int[n][m]; // 영희,기사 각각 체크배열 생성
                    ch[i][j] = 1;

                    int L = 0;
                    while (!Q.isEmpty()) {
                        L++;
                        int len = Q.size();
                        for (int k = 0; k < len; k++) {
                            int[] cur = Q.poll();
                            for (int[] dir : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) { // 방향배열 상하좌우
                                int nx = cur[0] + dir[0]; // 이동하는 행좌표
                                int ny = cur[1] + dir[1]; // 이동하는 열좌표
                                if (nx >= 0 && nx < n && ny >=0 && ny < m && board[nx][ny] != 1) { // 지도 범위 넘어가지 않게, 움직일 수 없는 곳을 제외
                                    if(ch[nx][ny] == 0){
                                        ch[nx][ny] = 1;
                                        dist[nx][ny] += L; // 영희와 기사가 지도에서 이동하는 지점의 이동거리 누적 합 
                                        Q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 영희와 기사가 각 산딸기 지점까지의 최소이동거리(최소 날수)
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 4 && dist[i][j] > 0) { // 산딸기 지점을 못간 경우는 거르기
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex07_06_02_Answer T = new Ex07_06_02_Answer();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}


```