package study.inflearn.lecture01.section3;

import java.util.Scanner;

public class Ex03_10_봉우리_답 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int n, int[][] map){
        int answer=0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                boolean flag = true;
                for(int k = 0; k < 4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] >= map[i][j]){
                        // 앞에서 미리 경계선을 걸러내야한다.
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex03_10_봉우리_답 T = new Ex03_10_봉우리_답();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, map));
    }
}
