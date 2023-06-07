package study.inflearn.lecture02.section05;

import java.util.*;

/**
 * 전투 게임 - greedy
 * 소요시간 - 47분
 * 강사님 피드백 - 타임아웃나는 로직임..^^ O(n^2)
 */
public class Ex05_05 {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        // 전투 게임 정보 셋팅
        Integer[][] fight = new Integer[n][2]; //[공격력, 반 번호]
        HashMap<Integer, String> teamIdx = new HashMap<>(); // {반 번호 : 팀}
        for (int i = 0; i < n; i++) {
            fight[i][0] = Integer.valueOf(students[i].split(" ")[1]); // 학생 공격력
            fight[i][1] = i; // 학생 반 번호
            teamIdx.put(i, students[i].split(" ")[0]); // 학생 반 번호와 팀
        }
        Arrays.sort(fight, (a,b) -> b[0] - a[0]); // 공격력 기준으로 내림차순 정렬

        // 학생마다 얻을 수 있는 최대 점수
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((fight[i][0] == fight[j][0]) || (teamIdx.get(fight[i][1]).equals(teamIdx.get(fight[j][1])))) {
                    continue; // 같은 팀 또는 공력격이 같을 때 건너뛰기
                }
                if (fight[i][0] > fight[j][0]) {
                    int idx = fight[i][1]; // 반번호
                    answer[idx] = answer[idx] + fight[j][0]; // 공격력 누적
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_05 T = new Ex05_05();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
