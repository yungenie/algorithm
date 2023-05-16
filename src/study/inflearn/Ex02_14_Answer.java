package study.inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 문서 도난 - 해싱, 시간파싱 (시간흐름을 분으로 변환, HH:mm -> 분단위로 해싱)
 */
class Info implements Comparable<Info>{
    public String name;
    public int time;
    Info(String name, int time){
        this.name = name;
        this.time = time;
    }
    @Override
    public int compareTo(Info ob){
        return this.time - ob.time;
    }
}
public class Ex02_14_Answer {
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public String[] solution(String[] reports, String times){
        //String[] answer ={};

        // 보안키를 사용한 사람과 시간 명단
        ArrayList<Info> tmp = new ArrayList<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        // 보안키를 사용한 사람 시간순으로 정렬
        Collections.sort(tmp); //tmp = tom:443, tmp = luis:537, tmp = daniel:570, tmp = park:599, tmp = john:923,
        tmp.forEach((x)-> System.out.print("tmp = " + x.name + ":" + x.time + ", "));

        // 특정 범위의 시간에 보안키를 사용한 사람들
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        //System.out.printf("\ns = %d, e = %d \n", s, e);
        ArrayList<String> res = new ArrayList<>(); //answer 배열의 크기를 모르기때문에 ArrayList에 담기
        for(Info ob : tmp){
            if(ob.time >= s && ob.time <= e){
                res.add(ob.name); // 시간순으로 추가
            }
            if(ob.time > e) break;
        }
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Ex02_14_Answer T = new Ex02_14_Answer();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        //System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        //System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
