package study.inflearn.lecture02.section02;

import java.util.*;

/**
 * 경고 메일 - 해싱, 시간파싱
 * 소요시간 - 62분
 */
public class Ex02_07 {

    // HH:mm -> 분단위로 변환
    public int getMinute(String s) {
        int h = Integer.parseInt(s.split(":")[0]);
        int m = Integer.parseInt(s.split(":")[1]);
        
        return h * 60 + m;
    }
    public String[] solution(String[] reports, int time){
        String[] answer = {};
        int n = reports.length;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        // 직원들이 보안실을 이용한 총시간 명단
        for (int i = 0; i < n; i++) {
            String name = reports[i].split(" ")[0];
            String inoutTime = reports[i].split(" ")[1];
            String inout = reports[i].split(" ")[2];

            if (inout.equals("in")) {
                /*if (map.getOrDefault(name, 0) == 0) {
                    map.put(name, getMinute(inoutTime));
                }*/
                map.put(name, getMinute(inoutTime));
            } else if (inout.equals("out")) {
                int totalTime = getMinute(inoutTime) - map.getOrDefault(name, 0); // 총 이용시간
                total.put(name, total.getOrDefault(name, 0)+totalTime); // 총 이용시간 누적
                //map.put(name, 0); // 총 이용시간 초기화

            }
        }
        //System.out.println("total = " + total);

        // 경고 메일을 받는 직원들 (특정시간을 넘기면 경고 메일 받음)
        ArrayList<String> email = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : total.entrySet()) {
            if (entry.getValue() > time) email.add(entry.getKey());
        }
        // 정렬 (직원의 이름을 알파벳 사전순)
        Collections.sort(email);

        // 직원 출력
        answer = new String[email.size()];
        int size = email.size();
        for (int i = 0; i < size; i++) {
            answer[i] = email.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex02_07 T = new Ex02_07();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
