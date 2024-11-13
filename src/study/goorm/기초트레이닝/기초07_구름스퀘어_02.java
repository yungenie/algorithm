package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Event implements Comparable<Event> {
    int start;
    int end;

    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Event o) {
        if (this.end == o.end) { // 끝나는 시간이 같다면 시작시간 오름차순
            return Integer.compare(this.start, o.start);
        }
        return Integer.compare(this.end, o.end); // 끝나는 시간 오름차순
    }
}

public class 기초07_구름스퀘어_02 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 행사의 개수
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            events.add(new Event(start, end));
        }

        Collections.sort(events);

        int count = 0;
        int lastEndTime = 0;

        // 그리디 알고리즘 적용
        for (Event event : events) {
            if (event.start >= lastEndTime) { // 시작시간이 마지막 끝나는 시간보다 커야함.
                count++;
                lastEndTime = event.end + 1; // 최소 1의 시간이 지난 뒤 행사 시작 가능.
            }
        }

        System.out.println(count);

    }


}
