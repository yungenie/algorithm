package study.inflearn.lecture02.section08;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 교육 과정 - 그래프 최단거리 : Graph
 */
public class Ex08_06_04_Answer {
    /**
     *
     * @param subjects : 과목목록
     * @param course : 선수과목 정보
     * @return
     */
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length; // 전과목 개수

        // 과목별 인덱싱
        HashMap<String, Integer> subjectsHash = new HashMap<>();
        for (int idx = 0; idx < n; idx++) {
            subjectsHash.put(subjects[idx], idx);
        }

        // 인접리스트 초기화 (선수과목 - 교육과목들)
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
        }
        int[] indegree = new int[n]; // 진입차수 초기화
        for (String info : course) {
            int preSubIdx = subjectsHash.get(info.split(" ")[1]);
            int postSubIdx = subjectsHash.get(info.split(" ")[0]);
            //선수과목의 교육과목들 셋팅(선수과목 먼저 수강 후, 들을 수 있는 수강과목들 넣기)
            relation.get(preSubIdx).add(postSubIdx);
            indegree[postSubIdx]++; // 해당 수강과목은 선수과목이 있다는 뜻으로 진입차수 증감 (선수과목 개수 카운팅)
        }

        // 위상정렬 알고리즘 수행
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i); // 선수과목이 없는 교육과목부터 탐색
        }
        while (!q.isEmpty()) {
            int sub = q.poll();
            result.add(sub);
            for (Integer x : relation.get(sub)) {
                indegree[x]--;
                if (indegree[x] == 0) q.offer(x);
            }
        }

        // 정답 반환
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = subjects[result.get(i)];
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static void main(String[] args){
        Ex08_06_04_Answer T = new Ex08_06_04_Answer();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
