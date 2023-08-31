package study.inflearn.lecture02.section08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 교육 과정 - 그래프 최단거리 : Graph
 */
public class Ex08_06_Answer {
    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length; // 전과목 개수

        // 과목별 인덱싱 (인접리스트의 인덱스를 사용하기 위해서)
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i < n; i++) {
            node.put(subjects[i], i);
        }

        // 선수과목에 대한 교육과목들 인접리스트 셋팅
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for(String x : course){
            int a = node.get(x.split(" ")[0]); //교육과목
            int b = node.get(x.split(" ")[1]); //선수과목
            graph.get(b).add(a); //선수과목 기준으로 교육과목들 인접리스트에 넣기
            indegree[a]++; // 진입차수 (교육과목의 선수과목 수)
        }

        //  n개의 과목을 모두 이수할 수 있는 순서 담기
        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) queue.offer(i); // 선수과목이 없는 과목부터 탐색
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);
            for(int x : graph.get(pre)){ // 선수과목 기준으로 수강해야하는 과목들 가져오기
                indegree[x]--; // 선수과목 감소
                if(indegree[x] == 0){ // 해당 과목은 선수과목이 없어지므로
                    queue.offer(x);  // 해당 과목을 넣어, 해당 과목이 선수과목이 되게끔 처리
                }
            }
        }

        String[] answer = new String[n];
        System.out.println(order);
        for(int i = 0; i < n; i++){
            answer[i] = subjects[order.get(i)];
        }
        return answer;
    }
    public static void main(String[] args){
        Ex08_06_Answer T = new Ex08_06_Answer();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
