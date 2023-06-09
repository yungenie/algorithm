package study.inflearn.lecture02.section06;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 가장 가까운 큰수 - 깊이우선탐색 : DFS
 */
public class Ex06_01_Answer {

    int answer, target, m;
    ArrayList<Integer> nums;
    int[] ch;
    boolean flag;
    public void DFS(int L, int number){ // L:레벨, number: 각 자릿수를 합친 값
        if (flag) return;
        if (L == m) {
            System.out.println("L == m");
                if (number > target) {
                    answer = number;
                    flag = true;
                }
        } else {
            for (int i = 0; i < m; i++) {
                System.out.println("i = " + i);
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }
    public int solution(int n){
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;

        // n을 자릿수별로 분리해 10진수 순열 만들기
        while (tmp > 0) {
            int t = tmp%10; // 나머지
            nums.add(t);
            tmp = tmp/10; // 몫
        }
        Collections.sort(nums); // 오름차순

        m = nums.size();
        ch = new int[m];
        DFS(0,0);
        if(flag == false) return - 1;

        return answer;
    }

    public static void main(String[] args){
        Ex06_01_Answer T = new Ex06_01_Answer();
        //System.out.println(T.solution(123));
        //System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        //System.out.println(T.solution(27711));
        //System.out.println(T.solution(54312));
    }
}
