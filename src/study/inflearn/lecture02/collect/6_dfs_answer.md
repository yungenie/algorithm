# DFS(깊이우선탐색/완전탐색) 정답 코드 정리

# 1. 가장 가까운 큰 수 (수열)

- 주어진 수보다 큰 수들 중에 가장 작은 수 반환하기

```java
package study.inflearn.lecture02.section06;

import java.util.Arrays;

public class Ex06_01_02_Answer {

    int target, len, answer; // 주어진 숫자, 주어진 숫자 길이, 가장 가까운 큰 수
    int[] arr; // 주어진 숫자가 담긴 배열
    int[] ch; // 주어진 숫자 사용 배열
    boolean flag; // 재귀함수 탈출 플래그
    public void DFS(int L, int nums) { // L:레벨, nums: 각 자릿수의 조합의 수
        if (flag) return; // 탈출조건
        if (L == len && target < nums) { // target : 주어진 n수, nums : 순열
            answer = nums;
            flag = true;
        } else { // 재귀로 순열을 만드는 로직
            for (int i = 0; i < len; i++) { // 배열의 0부터 시작하기 위해 i는 0으로 초기화
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, (nums * 10) + arr[i]);
                    ch[i] = 0;
                }
            }

        }
    }
    public int solution(int n){
        answer = -1;
        target = n;
        flag = false; // 탈출 플래그

        String str = String.valueOf(n);
        len = str.length();
        ch = new int[len]; // 주어진 숫자의 사용 체크배열
        arr = new int[len]; // 주어진 숫자가 담긴 배열
        for (int k = 0; k < len; k++) {
            arr[k] = Integer.parseInt(String.valueOf(str.charAt(k)));
        }
        Arrays.sort(arr);

        DFS(0, 0);

        return answer;
    }

    public static void main(String[] args){
        Ex06_01_02_Answer T = new Ex06_01_02_Answer();
        System.out.println(T.solution(123)); //132
        System.out.println(T.solution(321)); //-1
        System.out.println(T.solution(20573)); //20735
        System.out.println(T.solution(27711)); //71127
        System.out.println(T.solution(54312)); //54321
    }
}
```

# 2. 줄다리기 (수열의 경우의 개수)

- 싫어하는 학생끼리 일렬로 세우지 않는 모든 경우의 수 반환하기

```java
package study.inflearn.lecture02.section06;

import java.util.Stack;

public class Ex06_02_02_Answer {

    int n = 7;
    Stack<Integer> pm; // 순열(permutation)을 담는 자료
    int[][] relation; // 싫어하는 학생 정보
    int[] ch; // 학생의 사용 체크
    int answer;
    public void DFS(int L) {
        if(L == n){
            answer++;
        }else {
            for (int i = 1; i <= n; i++) { // 학생 번호가 1부터 N까지 시작
                if (!pm.isEmpty() && relation[pm.peek()][i] == 1) continue;
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L+1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        // 싫어하는 학생 정보 2차원 배열로 메모이제이션
        relation = new int[n + 1][n + 1];
        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        // 주어진 학생의 사용 체크배열 (이미 나열한 학생 중복으로 나열되지 않게 처리)
        ch = new int[n + 1];
		// 순열의 조합을 만들기 위한 자료담기
        pm = new Stack<>();
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        Ex06_02_02_Answer T = new Ex06_02_02_Answer();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
```

# 3. 바둑대회 (숫자 조합의 합계 중 최소값)

- 바둑대회에 출전하는 흰돌팀과 검은돌팀의 능력차의 최소값

```java
package study.inflearn.lecture02.section06;

import java.util.ArrayList;

public class Ex06_03_02_Answer {
    int n, answer; // 선수의 수, 정답
    int[] ch; // 선수의 흰돌,검은돌 사용 체크 (1:흰돌, 0:검은돌)
    int[][] cans; // 선수 명단 (각 선수의 흰돌, 검은돌 능력치 포함)
    public void DFS(int L, int s) {
        // 탈출조건
        if (L == n/2){ // 매번 조합이 완성될 때마다 능력치 최소값 구하기
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for(int j = 0; j < n; j++){ // 체크배열에서 1 : 흰돌, 0 : 검은돌 로 구성
                if(ch[j] == 1) A.add(j); // 1로 체크된 선수는 A팀
                else B.add(j); // 체크가 안된 선수는 B팀
            }
            int sumA = 0, sumB = 0;
            for(int k = 0; k < L; k++){ // ✨ n/2까지 반복하면서 cans의 해당하는 인덱스 가져와서 합하기
                sumA += cans[A.get(k)][0]; // 흰돌팀 합
                sumB += cans[B.get(k)][1]; // 검은돌팀 합
            }

            answer = Integer.min(answer, Math.abs(sumA-sumB));
        } else {
            for (int i = s; i < n ; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1; // 흰돌팀
                    DFS(L + 1, i + 1);
                    ch[i] = 0; // 검은돌팀
                }
            }
        }
    }
    public int solution(int[][] cans){
        this.cans = cans;
        answer = Integer.MAX_VALUE;
        n = cans.length; // 선수의 수
        ch = new int[cans.length]; // 1:흰돌, 0:검은돌
        DFS(0, 0);
        return answer;
    }

    public static void main(String[] args){
        Ex06_03_02_Answer T = new Ex06_03_02_Answer();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
```

# 4. 팰린드롬의 경우수 (팰린드롬 경우의 수들)

- 주어진 문자열의 모든 문자들을 가지고 만들 수 있는 팰린드롬의 경우들

```java
package study.inflearn.lecture02.section06;

import java.util.*;

public class Ex06_04_03 {

    ArrayList<String> result; // 팰린드롬 경우의 수들 담는 자료구조
    HashMap<Character, Integer> map; // 주어진 문자의 빈도수 해싱
    Deque<Character> deque; // 팰린드롬 만드는 자료구조
    int n;
    public void DFS() {
        // 탈출조건 : 주어진 문자열 크기의 팰린드롬 완성했을 경우, ArrayList에 담기
        if (deque.size() == n){
            StringBuilder sb = new StringBuilder();
            for (Character ch : deque) sb.append(ch);
            result.add(String.valueOf(sb));
        } else {
            for (Map.Entry<Character, Integer> ele : map.entrySet()) {
                int getValue = ele.getValue();
                char getKey = ele.getKey();
                // 각 문자열의 개수가 0 인 것은 제외
                if (getValue > 0) {
                    //앞뒤로 넣고 개수 차감
                    deque.addFirst(getKey);
                    deque.addLast(getKey);
                    map.put(getKey, getValue - 2);
                    DFS();
                    // 앞뒤로 빼고 개수 증가
                    //map.put(deque.peek(), map.getOrDefault(deque.peek(),0) + 2);
                    deque.pollFirst();
                    deque.pollLast();
                    map.put(getKey, map.get(getKey) + 2);
                }
            }
        }
    }
    public String[] solution(String s){
        n = s.length();
        result = new ArrayList<>();

        // 주어진 문자의 빈도수 해싱 ex) abbcceee ->  a:1, e:3, b:2, c:2
        map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        // 주어진 문자의 빈도수가 홀수 개수인 key 2개 이상인 경우 빈배열 반환
        int cnt = 0;
        for (Integer value : map.values()) {
            if (value%2 == 1) cnt++;
        }
        if (cnt >= 2) return new String[]{};

        // 홀수 개수인 key 1개인 경우 팰린드롬 가운데에 넣기.
        deque = new LinkedList<>();
        if (cnt == 1) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue()%2 == 1) {
                    deque.push(entry.getKey()); // 가운데 넣기
                    map.put(entry.getKey(), entry.getValue() - 1); // 넣은 개수 차감
                }
            }
        }

        DFS();

        // 팰린드롬 출력
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Ex06_04_03 T = new Ex06_04_03();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
```

# 5. IP 주소 (경우의 수들)

- 유효한 IP주소들 반환하기

```java
package study.inflearn.lecture02.section06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Ex06_05_02_Answer {
    String s; // 주어진 문자열
    int n; // 문자열 길이
    Stack<String> temp; // ip 4자리 주소 담는 바구니
    ArrayList<String> result; // 유효한 ip 주소 모음함
    public void DFS(int start) {
        if (temp.size() == 4 && start == s.length()) {  // 하나의 유효한 ip가 만들어진 경우
            String ip = "";
            for (String x : temp) ip += x + ".";
            result.add(ip.substring(0, ip.length()-1));
        } else {
            for (int i = start; i < n ; i++) {
								//ex) 03: start는 4이고, i는 5인 경우
                if (s.charAt(start) == '0' && start < i) return; 
                String str = s.substring(start, i + 1);
                if (Integer.parseInt(str) > 255) return;
                temp.add(str);
                DFS(i+1);
                temp.pop();

            }
        }
    }
    public String[] solution(String s){
        this.s = s; // 주어진 문자열
        n = s.length(); // 문자열 길이
        temp = new Stack(); // ip 4자리 주소 담는 바구니
        result = new ArrayList<>(); // 유효한 ip 주소 모음함

        // 완전 탐색
        DFS( 0);

        // 결과 반환
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
    public static void main(String[] args){
        /*
			유효한 IP 주소 조건 
            1) IP 주소는 4개의 숫자가 . 로 구분되어 있습니다.
            2) IP 주소의 4개의 숫자는 0 ~ 255사이의 숫자로 구성됩니다.(0, 255포함)
            3) IP 주소의 4개의 숫자는 0으로 시작하는 2자리 이상의 숫자는 안됩니다.
         */
        Ex06_05_02_Answer T = new Ex06_05_02_Answer();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
```

# 6. 알파코드 (암호화코드 경우의 개수, 조합)

- 암호화된 코드가 주어지면 그것을 알파벳으로 복원하는 방법의 개수 반환
- `경우의 수 조합을 메모이제이션` 으로 조합하여 사용

```java
package study.inflearn.lecture02.section06;

public class Ex06_06_02_Answer {
    
    String s; // 주어진 수
    int n; // 주어진 수의 길이
    int[] dy; // 인덱스 : 부모레벨, 값 : 자식레벨 경우의 수 조합

		public int DFS(int start){
        /*
            앞 문제들은 데이터의 조합을 완전탐색으로 구했다면,
            이 문제는 경우의 수 조합으로 메모이제이션으로 시간복잡도를 줄인다.
            예를 들어,
            2로 시작할 때 '5114'의 모든 경우의 수 + 25로 시작할 때 '114'의 모든 경우의 수를 더한다.
         */
        if(dy[start] > 0) return dy[start];
        if(start < n && s.charAt(start) == '0') return 0;
        if(start == n-1 || start == n) return 1; // 재귀의 종착점 or 종착점 + 1 인 경우
        else{
			/*
                처음 재귀함수는 요소 1개씩만 보기 때문에
                백트랙킹으로 요소를 2개 이상씩 탐색할 때 알파벳 암호 범위를 체크한다.
             */
            int res = DFS(start + 1);
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if(tmp <= 26) res += DFS(start + 2);
            return dy[start] = res;
        }
    }

    public int solution(String s){
        this.s = s; // 주어진 수
        n = s.length(); // 주어진 수의 길이
        dy = new int[51]; // 인덱스 : 부모레벨, 값 : 자식레벨 경우의 수 조합
        int answer = DFS(0);
        return answer;
    }

    public static void main(String[] args){
        /*
            알파벳 암호화 코드 조건
            알파벳 A ~ Z까지 1 ~ 26 할당 번호
         */
        Ex06_06_02_Answer T = new Ex06_06_02_Answer();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
```