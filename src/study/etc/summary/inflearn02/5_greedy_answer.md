
# 1. 침몰하는 타이타닉
- 타이타닉에 구명보트 2개 이하로, 각 한개 보트당 M kg 이하로 제한되어 승객 모두가 탈출 있도록 구명보트의 최소개수 반환
- 이 문제의 핵심 : 제공된 보트에 2명 이하의 몸무게가 총 M kg이하 맞춰 승객을 태워야함.
  - 승객의 몸무게를 오름차순으로 나열
  - 몸무게가 적은 사람 + 무거운 사람 태우는 게 가장 효율적이다.

```java
public class Ex05_01_Answer {
    public int solution(int[] nums, int m){
        int answer = 0;

        // 승객 몸무게 오름차순
        Arrays.sort(nums);

        // 구명보트 태우기
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= m) { // 승객 2명 태우기
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--; // 오른쪽 무거운 승객 혼자 태우기
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_01_Answer T = new Ex05_01_Answer();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
```

# 2.이동 횟수
- 모든 물건을 A창고에서 B창고로 옮기는데 필요한 최소 이동 횟수 반환 (한번에 5Kg 이하)

```java
public class Ex05_02 {
    public int solution(int[] nums){
        int answer = 0;

        // 물건 정렬
        Integer[] items = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(items, (a,b) -> b-a); // 내림차순 정렬

        int left = 0;
        int right = nums.length-1 ;

        while(left <= right) {
            if (items[left] + items[right] <= 5) { // 물건 2개 이동
                answer++;
                left++;
                right--;
            } else { // 무거운 물건만 이동
                answer++;
                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_02 T = new Ex05_02();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
```
# 3. 스프링 쿨러
- 모든 잔디밭에 물을 줄 수 있는 최소 스프링 쿨러의 개수
  - 조건 : (3,2) 3번 위치에 스프링 쿨러값이 2이면 (3-2, 3+2) 1~5범위에 물을 뿌릴 수 있다.
  - 참고 : inflearn\lecture02\section05\Ex05_03_Answer.md
- 포인트 : 스프링 쿨러 시작 위치가 작은 것 부터 멀리 뿌릴 수 있는 범위 찾기

```java
public class Ex05_03_Answer {
    public int solution(int n, int[] nums){
        int answer = 0;

        // 스프링 쿨러 범위 (시작, 끝) 2차원 배열에 초기화
        int[][] line = new int[n+1][2];
        for(int i = 0; i <= n; i++){
            line[i][0] = Math.max(0, i - nums[i]); // 시작 값이 음수인 경우 0으로 셋팅
            line[i][1] = Math.min(n, i + nums[i]); // 끝 값이 n개를 넘는 경우 n으로 셋팅
        }
        Arrays.sort(line, Comparator.comparingInt(a -> a[0])); //(a, b) -> a[0] - b[0]

        // 스프링 쿨러 최소개수
        int start = 0, end = 0, i = 0;
        // 잔디밭의 각 위치마다 체크
        while(i < line.length){
            // 스타트지점에서 범위가 오른쪽에서 가장 긴거 선택
            while(i < line.length && line[i][0] <= start){
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++; // 스프링쿨러 개수 카운팅
            if(end == n) return answer; //
            if(start == end) return -1; // 중간에 끊긴 경우는 end 값이 갱신되지 않아서 s==e가 같다.
            start = end;
        }
        return answer;
    }

    public static void main(String[] args){
        Ex05_03_Answer T = new Ex05_03_Answer();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
```

# 4. 꽃이 피는 최단시간
- 모든 꽃씨를 화단에 심고, 모든 꽃이 피기까지 걸리는 최단시간
  - 조건 : 꽃씨가 심는 기간 2일, 성장하는 기간 3일 (하루에 1개씩만 꽃을 심을 수 있다)
  - 참고 : 0번 꽃시는 심는 시간 2일 (2), 성장 기간 3일 (5) 5일째 되는 날 핀다.

```java
public class Ex05_04 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = growTime.length;

        // 꽃 심기 및 성장 기간이 담긴 2차원 배열
        List<int[]> pg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pg.add(new int[]{plantTime[i], growTime[i]});
        }
        Collections.sort(pg, (a,b) -> b[1] - a[1]); // 성장 기간이 가장 긴 꽃씨 내림차순
        
        // 성장 기간이 가장 긴 꽃시 먼저 심기
        int start = 0, end = 0;
        for (int[] x : pg) {
            start = start + x[0]; // 꽃 심기
            end = start + x[1]; // 꽃이 피는 날 : 꽃 심기 + 성장
            answer = Math.max(end, answer); // 가장 늦게 꽃이 피는 날
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_04 T = new Ex05_04();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
```

# 6. 최대인원수 (그리디 + 시뮬레이션)
- 각 기차의 출발->도착 수용인원과 예약정보를 통해서 기차의 최대 예약 어린 수

```java
public class Ex05_06_Answer {
    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;
        int[] tiket = new int[n + 1]; // n+1의 이유는 0부터 누적합산하기 위함.

        // 주어진 trans 배열의 데이터로만 탑승 및 하차 인원 초기화
        for (int[] x : trans) {
            tiket[x[0]] += x[2]; // 출발역 수용인원 만큼 승차
            tiket[x[1]] -= x[2]; // 도착역 수용인원 만큼 하차
        }
        // 기차역마다 최대 승차 인원수
        for (int i = 1; i < tiket.length; i++) {
            tiket[i] = tiket[i] + tiket[i - 1]; // i번째 역에서 태울 수 있는 최대 인원
        }

        // 승차역 오름차순
        Arrays.sort(bookings, (a,b) -> a[0] - b[0]);

        // 어린이 번호, 어린이 예약 총 수
        int cidx = 0, cLen = bookings.length;

        // 어린이 태우기 (도착역 번호 붙여서)
        LinkedList<Integer> trains = new LinkedList<>();
        for (int i = 1; i <= n ; i++) { // 기차역 탐색

            // 도착역에 내리는 어린이 하차 시키기
            while(!trains.isEmpty() && trains.peek() == i) {
                trains.pollFirst(); // 도착역 오름차순으로 정렬했기 때문에 하차
            }

            // 각 예약정보의 해당 역에서 어린이 기차 태우기
            while(cidx < cLen && i == bookings[cidx][0]) {
                trains.add(bookings[cidx][1]); // 도착역 번호
                cidx++;
                answer++;
            }
            Collections.sort(trains); // 도착역 오름차순

            // 수용인원보다 넘치는 경우
            while(trains.size() > tiket[i]){ // 기차에 탑승한 어린이 수보다 수용인원에 넘치는 경우
                trains.pollLast(); // 가장 나중에 내리는 어린이 하차
                answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_06_Answer T = new Ex05_06_Answer();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
```