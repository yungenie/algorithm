# 인프런 자바 코딩테스트 - it 대기업 유제
- 강의를 듣고 풀면서 새롭게 알게 된 사실이나, 실수한 점, 잘못 생각 했던 점을 기록합니다.

# Ex04_03~Ex05_01
## Ex04_03
강사님 해법 듣고 재도전한 문제
- 큰 수부터 차례대로 가져오면 되니깐 내림차순 후, 순차적으로 가져와야겠다. 까지만 생각해냄.
- 어떻게 총합의 최대를 만들어야할 지 떠오르지 않았음. 일일이 다 계산해봐야하나 확률문제인가 고민했음.
- 어차피 내림차순으로 정렬해서 앞에서 2개씩 라운드되므로, 2개의 요소 차이가 많이 나는 값을 k번 더해주면 된다.
- 어차피 현수가 가져온 값 + 차이를 더해주면 원래 가져와야할 값을 뜻하는 것

Arrays.stream(nums).boxed().toArray(Integer[]::new);
- 정수형 배열의 내림차순은 기본형인 int형은 안되고, 클래스 형인 Integer형으로 해야 됨

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


## Ex04_02
선택정렬 알고리즘 활용
- 해당 알고리즘은 O(n^2) 이므로 데이터가 커지면 비효율적임..

HashMap.getOrDefault()
- (잘못생각)정렬문제여서 HashMap 사용할 생각도 못했다..
- 자료구조를 국한되지 않게 생각하기.

