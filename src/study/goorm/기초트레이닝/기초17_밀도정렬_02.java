package study.goorm.기초트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 기초17_밀도정렬_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /**
         * 밀도 = 무게/부피
         * 밀도가 같다면, 무게가 무거운 번호
         * 밀도와 부피도 같으면 더 작은 번호
         */

        List<Matter> matterList = new ArrayList<>();
        for (int i = 1; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            matterList.add(new Matter(i, w, v ));
        }

        Collections.sort(matterList);
        System.out.println(matterList.get(0).number);


    }
}

class Matter implements Comparable<Matter> {

    int number; // 번호
    int weight; // 무게
    int volume; // 부피

    public Matter(int number, int weight, int volume) {
        this.number = number;
        this.weight = weight;
        this.volume = volume;
    }

    @Override
    // 객체가 어떤 기준으로 정렬 하는지 기준 정의
    public int compareTo(Matter o) {
        double matter = weight / (double) volume;
        double matter2 = o.weight / (double) o.volume;

        if (matter == matter2) { // 밀도 동일한 경우
            if (weight == o.weight) { // 무게도 동일한 경우
                return number - o.number; // 작은 번호
            }
            return o.weight - weight; // 더 무거운 무게
        }

        return Double.compare(matter, matter2); // 높은 물질 반환
    }
}
