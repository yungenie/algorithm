package study.inflearn;

import java.util.Arrays;

/**
 * 좌석번호 - 시뮬레이션 & 구현
 *
 * 문제 포인트 : 문제에서 주어진 격자형태를 90도 회전해서 행열로 변환, 회전하는 조건 (빈좌석이 아닌 경우)
 */
public class Ex01_04_Answer {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        // k번째 온 사람이 앉을 좌석이 없을 경우 - {0,0} 반환 (2차원 배열 선언 및 값대입)
        if(k > c * r) return new int[] {0, 0};

        // 강연장에 사람들이 온 순서
        int[][] seat = new int[c][r]; // new 연산자로 배열의 크기에 맞게
        int x = 0, y = 0, count = 1, d = 0; // d : 방향배열 인덱스 초기화
        // 시계방향에 따른 행열 좌표배열 - 인덱스 1부터 시작할 수 있게 셋팅
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // k번째로 온 사람들 빈 좌석 앉기 (시계 방향으로 돌아가면서)
        while(count < k){ // N번째 조건에, N+1번째의 좌석번호 셋팅
            // 다음 사람이 앉을 좌석 (이동하는 좌석)
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 시계 방향으로 돌기
            if(nx < 0 || nx >= c || ny < 0 || ny >=r || seat[nx][ny] > 0){ //seat[nx][ny] > 0 빈자리가 아닌 경우
                d = (d + 1) % 4;
                continue;
            }

            // 빈자리에 앉기
            seat[x][y] = count;

            // 다음 손님을 위한 값 셋팅
            count++;
            x = nx;
            y = ny;
        }
        // k번째 좌석번호 구하기 (좌석번호는 1부터 이므로, 배열의 인덱스 + 1)
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;

    }

    public static void main(String[] args){
        Ex01_04_Answer T = new Ex01_04_Answer();
        System.out.println(Arrays.toString(T.solution(6, 5, 1)));
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }

}

/*

- 문제 문해력, 이해력은 좋아짐.
- 문제 파악, 문제 해법, 코드로 표현하는 풀이법 부족.
- 배열선언(array) 헷갈림
-> 1. 타입[] 변수 = new 타입[길이]
-> 1. 타입[] 변수 = {값, 값, 값} // 타입에 맞는 값 넣어야함.
-> 2. 타입[] 변수 = new 타입[]{값, 값, 값} (new 연산자로 배열 생성시 기본값으로 초기화 됨, 정수배열은 0, 실수배열은 0.0, 논리배열은 false, 참조배열은 null)

 */