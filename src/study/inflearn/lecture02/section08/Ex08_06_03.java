package study.inflearn.lecture02.section08;

import java.util.*;

/**
 * 교육 과정 - 그래프 최단거리 : Graph
 * 강사님 해법 듣고 재도전 (1시간 소요)
 */
public class Ex08_06_03 {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;

        // 과목별 인덱스 해싱 {과목 : 인덱스}
        HashMap<String, Integer> subIdxMap = new HashMap<>();
        for (int i = 0; i < n; i++) subIdxMap.put(subjects[i], i); // note 리팩토리

        // 다음 수강해야하는 과목 인접리스트 ex) [[], [2,3], [0] ...]
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) arr.add(new ArrayList<>());
        // 진입차수
        int[] indegree = new int[n];
        for (String rel : course) {
            Integer aIdx = subIdxMap.get(rel.split(" ")[0]); // note 리팩토리
            Integer bIdx = subIdxMap.get(rel.split(" ")[1]); // note 리팩토리
            arr.get(bIdx).add(aIdx);
            indegree[aIdx]++;
        }

        // 모든 과목 이수할 수 있게 순서대로 담기
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) if (indegree[i] == 0) q.offer(i);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer nextSub : arr.get(cur)) {
                if (indegree[nextSub] !=0 ) indegree[nextSub]--; // note 리팩토리
                if (indegree[nextSub] == 0) q.offer(nextSub);
            }
            order.add(cur);
        }

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = subjects[order.get(i)]; // note 리팩토리
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args){
        Ex08_06_03 T = new Ex08_06_03();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
