package study.inflearn.lecture02.section08;

import java.util.*;

/**
 * 교육 과정 - 그래프 최단거리 : Graph
 * 틀림
 */
public class Ex08_06 {
    public String[] solution(String[] subjects, String[] course){
        String[] answer = {};

        HashMap<String, ArrayList<String>> relMap = new HashMap<>();
        for (String subject : subjects) {
            for (String s : course) {
                String a = s.split(" ")[0];
                String b = s.split(" ")[1];

                if (subject.equals(a)) {
                    relMap.putIfAbsent(subject, new ArrayList<>());
                    relMap.get(subject).add(b);
                }
            }
        }

        Deque<String> dq = new ArrayDeque<>();
        for (String subject : relMap.keySet()) {
            if (relMap.get(relMap.get(subject)) == null && !dq.contains(subject)) {
                dq.addFirst(subject);
            }

            if (relMap.get(subject) != null) {
                ArrayList<String> list = relMap.get(subject);
                for (String s : list) {
                    if (relMap.get(relMap.get(s)) == null && !dq.contains(s)) {
                        dq.addFirst(s);
                    } else if (relMap.get(relMap.get(s)) != null && !dq.contains(s)) {
                        dq.addLast(s);
                    }

                }
            }
        }
        System.out.println("dq = " + dq);

        return answer;
    }

    public static void main(String[] args){
        Ex08_06 T = new Ex08_06();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"}));
        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
