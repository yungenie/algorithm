package study.inflearn;

import java.util.Arrays;

public class Ex01_07_Answer {
    public int solution(int[] keypad, String password){
        int answer = 0;
        // 어떤 숫자의 인접한 8방향 (시계방향)
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10]; // dist[i][j] = i번 숫자에서 j번 숫자까지 이동하는 이동시간 배열

        // 키패드 숫자 행열로 채우기
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                pad[i][j] = keypad[i*3 + j]; // 1차원 배열의 keypad 요소를 2차원 배열로 셋팅 (i*3+j = 0~8)
            }
        }

        // 이동시간 배열 초기화
        for(int i = 0; i < 10; i++){
            Arrays.fill(dist[i], 2); // 0~8행 셋팅 (2차원 행열 모두 2로 초기화)
        }
        for(int i = 0; i < 10; i++) dist[i][i] = 0; // 현재위치 → 현재위치 (자기자신) = 이동시간 0초

        // 인접한 번호 1로 초기화
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int from = pad[i][j];
                for(int k = 0; k < 8; k++){ // 인접한 8방향으로 탐색하면서 인접한 번호의 이동시간 1로 초기화
                    if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){ // 격자 밖 제한
                        int to = pad[i+dx[k]][j+dy[k]]; // 이웃한 숫자
                        dist[from][to] = 1;
                    }
                }
            }
        }

        //password 총 입력 시간
        for(int i = 1; i < password.length(); i++){
            int from = (int)password.charAt(i-1)-48; // String을 int 캐스팅 문자인 숫자 int화 시키면 아스키 코드로 된다.
            int to = (int)password.charAt(i)-48;
            answer += dist[from][to];
        }
        return answer;
    }

    public static void main(String[] args){
        Ex01_07_Answer T = new Ex01_07_Answer();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
