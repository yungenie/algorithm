package study.inflearn.lecture02.section02;

import java.time.LocalTime;
import java.util.*;

/**
 * 문서도난 - 해싱, 시간파싱
 * 소요시간 - 50분
 * LocalTime.of(int hour, int minute, int second)
 * equals(LocalDate other) - 주어진 날짜가, 파라미터로 전달받은 날짜와 같을 경우 true를 리턴합니다.
 * isBefore(LocalDate other) - 주어진 날짜가, 파라미터로 전달받은 날짜와 작을 경우 true를 리턴합니다.
 * isAfter(LocalDate other) - 주어진 날짜가, 파라미터로 전달받은 날짜와 클 경우 true를 리턴합니다.
 */
public class Ex02_06 {

    /***
     *
     * @param s : 주어진 문자열
     * @param i : HH:ss HH:ss 주어진 문자열의 첫번째 0, 두번째 1
     * @param j : HH:ss 시간 0, 초 1
     * @return 문자열의 숫자변환 (24시간제)
     */
    public int getNum(String s, int i, int j){
        return Integer.parseInt(s.split(" ")[i].split(":")[j]);
    }
    public String[] solution(String[] reports, String times){
        String[] answer = {};
        int n = reports.length;

        LocalTime start = LocalTime.of(getNum(times,0,0), getNum(times,0,1));
        LocalTime end = LocalTime.of(getNum(times,1,0), getNum(times,1,1));

        // 특정 범위의 시간에 보안키를 사용한 사람 명단
        HashMap<LocalTime, String> hashMap = new HashMap<>(); // 특정 범위의 시간에 보안키를 사용한 사람들
        List<LocalTime> useTime = new ArrayList<>(); // 특정 범위의 시간에 보안키를 사용한 사람들 사용시간
        for (int i = 0; i < n; i++) {
            String name = reports[i].split(" ")[0];
            LocalTime time = LocalTime.of(getNum(reports[i],1,0 ),getNum(reports[i],1,1));

            // start < time < end
            if ( (start.equals(time) || start.isBefore(time)) && (end.isAfter(time) || end.equals(time))) {
                hashMap.put(time, name);
                useTime.add(time);
            }
        }
        //System.out.println("hashMap = " + hashMap); //hashMap = {09:30=daniel, 08:57=luis}

        // 사용시간 오름차순
        useTime.sort(LocalTime::compareTo);
        //System.out.println("useTime = " + useTime); //useTime = [08:57, 09:30]

        // 보안키를 사용한 시간순인 사람 출력
        int useTimeSize = useTime.size();
        answer = new String[useTimeSize];
        for (int i = 0; i < useTimeSize; i++) {
            answer[i] =  hashMap.getOrDefault(useTime.get(i), "");
        }

        return answer;
    }

    public static void main(String[] args){
        Ex02_06 T = new Ex02_06();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
