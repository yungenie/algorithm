
# 1. 사다리타기(배열의 교환)
```java
public class Ex01_01_03_Answer {
    public char[] solution(int n, int[][] ladder){
        // answer 배열에 알파벳 대문자 저장하기
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
        }

        // 사다리타기 -  배열의 인덱스를 통해서 알파벳 교환 로직
        for (int[] info : ladder) {
            for (int x : info) {
                char temp = answer[x];
                answer[x] = answer[x-1];
                answer[x - 1] = temp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_01_03_Answer T = new Ex01_01_03_Answer();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
```


# 2.청소 (방향배열)
- 청소로봇이 지도정보에서 k초 후 멈추는 로봇의 위치 반환

```java
public class Ex01_02_02_Answer {
    public int[] solution(int[][] board, int k){
        int n = board.length; // 방의 길이(정사각형)

        // 방향배열 시계방향(우하좌상)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        //x행 y열 시작위치, d회전방향, count움직이는 시간
        int x = 0, y = 0, d = 0, count = 0;

        //로봇이 움직이는 시간
        while (count < k) {
            count++; // 이동 하거나, 방향 변경을 해도 무조건 1초

            //로봇의 다음 위치 : 현재위치 + 이동방향
            int nx = x + dx[d];
            int ny = y + dy[d];

            //격자 밖 경우, 장애물 만났을 경우 회전
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) {
                d = (d + 1) % 4; // 90도 회전, 회전 하는 개수 % 반복되는 수열의 수
                continue; //회전시간 추가
            }
            // 현재위치에 다음 위치 초기화
            x = nx;
            y = ny;
        }

        // k초 후 로봇위치(좌표)
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        Ex01_02_02_Answer T = new Ex01_02_02_Answer();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
```

# 3. 잃어버린 강아지 (방향배열, 현수와 강아지 동시에 움직임)

```java

public class Ex01_03_02_Answer {
    public int solution(int[][] board){
        int answer = 0;
        int n = board.length;

        //시계 방향에 따른 행열의 이동
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 현수와 강아지 시작 위치
        int hx = 0, hy = 0, px = 0, py = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    hx = i;
                    hy = j;
                }else if (board[i][j] == 3) {
                    px = i;
                    py = j;
                }
            }
        }

        // 몇 분 후에 현수와 강아지를 찾는 지 구하기
        int count = 0, hd = 0, pd = 0;
        while (count < 10000) {
            count++;
            // 현수 다음 위치 : 현재 위치 + 회전 방향
            int hnx = hx + dx[hd];
            int hny = hy + dy[hd];
            // 강아지 다음 위치 : 현재 위치 + 회전 방향
            int pnx = px + dx[pd];
            int pny = py + dy[pd];

            // 현수와 강아지 회전 - 나무나 지도 끝에 이르면 회전
            boolean flag1 = false, flag2 = false; // 회전의 유무
            if (board[hnx][hny] == 1 || hnx < 0 || hny < 0 || hnx >= n || hny >= n) {
                hd = (hd + 1) % 4; // 90도 회전, 회전 하는 개수 % 반복되는 수열의 수
                flag1 = true;
            }
            if ( board[pnx][pny] == 1 || pnx < 0 || pny < 0 || pnx >= n || pny >= n) {
                pd = (pd + 1) % 4; // 90도 회전, 회전 하는 개수 % 반복되는 수열의 수
                flag2 = true;
            }

            // 현수와 강아지 이동 - 회전유무에 따라 이동
            if (flag1 == false) {
                hx = hnx;
                hy = hny;
            }
            if (flag2 == false) {
                px = pnx;
                py = pny;
            }
            // 현수와 강아지 만남
            if (hx == px && hy == py) break;

        }
        return count >= 10000? answer : count;
    }

    public static void main(String[] args){
        Ex01_03_02_Answer T = new Ex01_03_02_Answer();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }

}
```

# 4. 좌석번호 (방향배열)
- c와 r에 강연장의 크기가 주어지면, k번째로 온 사람이 앉을 좌석번호 반환
```java
public class Ex01_04_02 {
    public int[] solution(int c, int r, int k){
        // k번째분 좌석번호 초기화
        int[] answer = new int[2];

        // 방향배열 (시계방향)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 좌석번호 초기화 배열
        int[][] placeChk = new int[c][r];
        // 현재 행, 열, 방향, 좌석번호, 전체좌석 개수
        int x = 0, y = 0, d = 0, cnt = 1, limitCnt = c*r;

        // k번째 좌석번호 찾기
        while (cnt <= limitCnt && limitCnt >= k) {
            placeChk[x][y] = cnt; // 좌석번호 셋팅

            // 다음 좌석 배치 (다음좌석 = 현재좌석 + 방향)
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 좌석배치 범위 밖 or 이미 배치된 좌석
            if (nx < 0 || ny < 0 || nx >= c || ny >= r || placeChk[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            // 현재좌석 업데이트
            x = nx;
            y = ny;
            cnt++; // 좌석번호 배분

            // k번째분 좌석 반환
            if (k == cnt) return new int[]{x+1, y+1};
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_04_02 T = new Ex01_04_02();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
```

# 5.최대길이 바이토닉
- 봉우리지점(인덱스)를 통해 연속부분수열 찾기

```java
public class Ex01_05_Answer {
    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;

        // 수열의 봉우리지점 인덱스 담기  이전 < 현재(봉우리) > 이후
        ArrayList<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) { // 배열의 n-2까지 도는 이유는 i+1까지 보기 때문.
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peaks.add(i);
            }
        }

        // 봉우리지점 인덱스를 기준으로 양방향으로 바이토닉 수열의 개수 구하기
        for(int x : peaks){
            int left = x; // 왼쪽방향 인덱스
            int right = x; // 오른쪽방향 인덱스
            int cnt = 1; // 봉우리지점 카운팅 

            // 연속부분수열 측정
            while(left-1 >= 0 && nums[left] > nums[left-1]){ //왼쪽 탐색
                left--; // 왼쪽방향 인덱스 감소
                cnt++; // 바이토닉 수열의 개수
            }
            while(right+1 < n && nums[right] > nums[right+1]){ //오른쪽 탐색
                right++; // 오른쪽방향 인덱스 감소
                cnt++; // 바이토닉 수열의 개수
            }
            //가장 긴 바이토닉 수열의 길이
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_05_Answer T = new Ex01_05_Answer();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
```

# 7.비밀번호 (행열좌표 빼기)
-  keypad에 키패드의 숫자배열이이 주어지고, password에 입력해야 할 비밀번호가 주어지면 비밀번호가 모두 입력되는데 걸리는 총 시간
```java
public class Ex01_07 {
    public int solution(int[] keypad, String password){
        int answer = 0;
        char[] pwdChar = password.toCharArray();

        // 키패드 숫자들 배열에 초기화
        int[][] keypadArr = new int[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keypadArr[i][j] = keypad[index];
                index++;
            }
        }

        // 비밀번호가 입력되는 총 시간
        int first = 0, tempi = 0, tempj = 0;
        for (char c : pwdChar) { // 패스워드 숫자와 동일한 키패드 행열 찾기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypadArr[i][j] == Character.getNumericValue(c)) {
                        if (first != 0) {
                            int a = Math.abs(tempi - i);
                            int b = Math.abs(tempj - j);
                            int max = Math.max(a, b);
                            answer += max;
                        } // 키패드 첫 패스워드 0초 이기 때문에 그 다음 패스워드부터 걸리는 시간 카운팅
                        tempi = i;
                        tempj = j;
                        first++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_07 T = new Ex01_07();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
/*
- char to int : Character.getNumericValue(); // char 7 -> int 바꾸면 아스키코드값으로 변경되는데 char 7이라는 문자값 그대로 숫자로 변형해줌
- 절대값 : Math.abs();
 */
```