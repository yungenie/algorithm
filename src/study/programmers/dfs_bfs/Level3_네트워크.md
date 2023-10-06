# DFS - 네트워크

## 문제
https://school.programmers.co.kr/learn/courses/30/lessons/43162

## 풀이
- 컴퓨터끼리 연결되어 있는 네트워크 그룹의 개수를 찾는 문제로 graph 자료구조를 떠올릴 수 있다.
- 연결되어 있는 컴퓨터를 확인하기 위해 깊이 우선 탐색 알고리즘으로 풀 수 있다.
>  1. 탐색한 컴퓨터(노드)의 체크 배열을 만들기
>  2. 노드 배열의 값이 false 일 때만 탐색하여 연결된 노드를 DFS로 모두 탐색하여 연결된 노드(컴퓨터)를 true 변경한다.
>  3. 한 컴퓨터에 연결된 컴퓨터를 모두 탐색했으면, DFS() 메소드가 종료되면 answer 값을 증가 시켜준다.

```java
public class Level3_네트워크 {
    int n;
    int[][] computers;
    boolean[] visited;

    public void DFS(int start) {
        visited[start] = true; // 탐색한 노드 체크
        for (int j = 0; j < n ; j++) { // 연결 노드 확인
            if (start != j && !visited[j] && computers[start][j] == 1) { // 연결 노드 중 탐색하지 않은 노드만 탐색하기
                DFS(j);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        this.visited  = new boolean[n]; // 탐색한 노드(컴퓨터) 체크 배열

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 첫 방문인 경우
                DFS(i);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Level3_네트워크 T = new Level3_네트워크();
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(T.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
```
- n개의 각 컴퓨터마다 탐색한다. 
- 해당 컴퓨터와 네트워크된 컴퓨터를 탐색한다. 
- answer++ 를 통해 네트워크(연결)된 컴퓨터 그룹의 수를 확인할 수 있다.
- 네트워크된 컴퓨터는 visited 배열의 true 값을 통해 확인할 수 있다.