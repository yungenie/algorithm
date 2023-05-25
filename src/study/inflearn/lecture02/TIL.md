# 인프런 자바 코딩테스트 - it 대기업 유제
- 강의를 듣고 풀면서 새롭게 알게 된 사실이나, 실수한 점, 잘못 생각 했던 점을 기록합니다.

# Ex03_04~Ex04_2
## Ex03_04
int[][] inList = new int[n][2];
- 2차원 배열 선언에서 행과 열의 의미
- 왜 [2]인지 정확히 몰랐음,

Queue<Object o> q = new LinkedList<>();
- 링크드리스트는 큐 인터페이스의 대표적인 구현체이다.
- (잘못생각) Queue q = new Queue 선언하고 있었음..


## Ex03_05
LinkedList<Object o> ll = new LinkedList<>();
- 연결리스트는 저장순서가 유지되는 자료구조
- (잘못생각) 연결리스트 저장순서 유지 안되는 줄 알았음..

ll.pollFirst()
- 연결리스트 첫번째 요소 꺼내서 반환 가능
- (잘못생각) list기반으로만 생각해서 stack,queue처럼 요소를 꺼내오는 걸 생각못함..

PriorityQueue<Object o> pq = new PriorityQueue<>();
- 우선순위가 높은 것(요소값 작은) 부터 꺼내는 우선순위 큐 구현체
- (잘못생각) 우선순위 큐 구현체 처음 알았음..

while (!taskInfo.isEmpty() || !waitQ.isEmpty())
- 논리연산자 || (OR결합) 피연산자 중 어느 한쪽만 true이면 true를 결과로 얻는다.

## Ex03_06
Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
- (잘못생각) 2차원 배열의 원소들을 어떻게 비교하는 지 몰랐음.. 

TreeSet<Integer> useRoom = new TreeSet<>();
useRoom.pollFirst()
- 중복이 없고, 기본적으로 오름차순으로 정렬해주는 자료구조임.
- TreeSet 은 레드블랙트리 자료구조로 구현되어있어 O(logn)만에 오름차순 정렬됩니다.
- TreeSet의 첫번째 요소(제일 작은 값의 객체)를 반환.

## Ex04_01
Integer.toBinaryString() 
- 이진수 변환 함수

Arrays.sort()
- (잘못생각) Arrays.sort()에는 Comparator 제공이 안되는 줄 알았음.. 
- Arrays.sort()는 내부적으로도 Dual Pivot Quick Sort로 구현되어 있음.
- 시간 복잡도가 O(nlog₂n)를 가지는 다른 정렬 알고리즘과 비교했을 때도 가장 빠르다.
- PriorityQueue 우선순위 큐 생성자에 람다식으로 Comparator.compare() 정렬기준 추가해서 풀었으나,
- PriorityQueue는 힙(완전이진트리)으로 구현되어 있어 시간복잡도 측면으로는 Arrays.sort()가 더 적합




