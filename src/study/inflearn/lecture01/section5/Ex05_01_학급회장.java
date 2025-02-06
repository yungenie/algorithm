package study.inflearn.lecture01.section5;

import java.util.*;

public class Ex05_01_학급회장 {

    public String solution(int n, String[] voteArr) {
        String answer = "";

        Map<String, Integer> voteMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            voteMap.put(voteArr[i], voteMap.getOrDefault(voteArr[i], 0) +1);
        }
        int max = Collections.max(voteMap.values());
        for (Map.Entry<String, Integer> entry: voteMap.entrySet()) {
            if (max == entry.getValue()) {
                return entry.getKey();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Ex05_01_학급회장 T = new Ex05_01_학급회장();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] voteArr = sc.next().split("");
        System.out.println(T.solution(n, voteArr));
    }
}
