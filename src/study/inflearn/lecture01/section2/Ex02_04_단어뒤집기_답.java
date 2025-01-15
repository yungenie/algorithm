package study.inflearn.lecture01.section2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 직접 뒤집기
 */
public class Ex02_04_단어뒤집기_답 {

    public ArrayList<String> solution(int n, String[] str) {

        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String t = String.valueOf(s);
            answer.add(t);
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex02_04_단어뒤집기_답 T = new Ex02_04_단어뒤집기_답();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = sc.next();
        }
        for (String x :  T.solution(N, str)) {
            System.out.println(x);
        }
    }
}
