package study.inflearn.lecture02.section05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 전투 게임 - greedy
 */
public class Ex05_05_Answer {

    class Info implements Comparable<Info> {
        public int idx;
        public Character temm;
        public int power;

        Info(int idx, Character temm, int power) {
            this.idx = idx;
            this.temm = temm;
            this.power = power;
        }
        @Override
        public int compareTo(Info o) {
            return this.power - o.power;
        }
    }
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        // 전투게임 정보
        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Character x = students[i].split(" ")[0].charAt(0); // 팀
            int y = Integer.parseInt(students[i].split(" ")[1]); // 공격력
            list.add(new Info(i, x, y)); // [반 번호, 팀, 공격력]
        }
        Collections.sort(list); // 공격력 기준으로 오름차순

        // 학생마다 얻을 수 있는 최대 점수
        HashMap<Character, Integer> map = new HashMap<>(); // 팀에 따른 공격력 누적
        int j = 0, total = 0;
        // 1번 학생부터 시작
        for (int i = 1; i < n; i++) { // 0번은 자기보다 공격력이 작은 학생이 없으므로 1번부터 시작.
            // 1번 학생부터 마지막 학생까지 얻을 수 있는 최대점수
            while (j < n) {
                if (list.get(j).power < list.get(i).power) {
                    total += list.get(j).power; // 공격 누적
                    char c = list.get(j).temm; // 팀
                    // 본인팀 공격력 누적
                    map.put(c, map.getOrDefault(c, 0) + list.get(j).power);
                    j++;
                } else break;
            }
            // 학생의 최대점수에서 학생의 팀 공격력은 제외
            answer[list.get(i).idx] = total - map.getOrDefault(list.get(i).temm, 0); // 최대점수 (같은 팀 공격력 제외)
        }
        return answer;
    }

    public static void main(String[] args){
        Ex05_05_Answer T = new Ex05_05_Answer();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
