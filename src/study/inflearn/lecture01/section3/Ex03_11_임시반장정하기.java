package study.inflearn.lecture01.section3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 정답.
 * 하루에 걸쳐서 풀었음.
 */
public class Ex03_11_임시반장정하기 {

    public int solution(int n, int[][] classInfo) {
        int tmpLeader = -1;
        int now;
        int[] sameClassInfo = new int[n];
        Set<Integer> sameStudent = new HashSet<>();

        // 학생 수 만큼 반복
        for (int i = 0; i < n; i++) {

            // 기준 학생
            for (int j = 0; j < 5; j++) {
                now = classInfo[i][j];

                // 비교 학생들
                boolean stop = false;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < 5; y++) {
                        // 다른 학생이면서 같은 학년 비교
                        if (x != i && j == y) {
                            // 같은 반 비교
                            if (now == classInfo[x][y]) {
                                sameStudent.add(x); // 학생 번호
                                // 이미 같은 반 했던 학생 중복 제거
                                stop = true;
                                break;
                            }
                        }
                    }

                    if (stop) {
                        continue; // 다음 학생과 비교
                    }
                }

            }

            sameClassInfo[i] = sameStudent.size();
            sameStudent = new HashSet<>();

        }

        //System.out.println(Arrays.toString(sameClassInfo));

        // 임시 반장 - 후보 여러명인 경우 작은 번호 출력
        int maxCnt = Arrays.stream(sameClassInfo).max().getAsInt();
        for (int i = 0; i < n; i++) {
            if (maxCnt == sameClassInfo[i]) {
                tmpLeader = i+1;
                break;
            }
        }


        return tmpLeader;
    }

    public static void main(String[] args) {
        Ex03_11_임시반장정하기 T = new Ex03_11_임시반장정하기();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] classInfo = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                classInfo[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, classInfo));
    }
}
