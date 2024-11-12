package study.goorm.유형트레이닝;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 자료구조02_블록게임 {
    public static void main(String[] args) throws Exception{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 블록 놓는 횟수
        String D = br.readLine(); // 블록 놓는 방향
        int[] scores = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); // 블록의 점수

        // 초기화
        Stack<int[]> stack = new Stack<>(); // 블록의 x 위치, y위치, 점수
        Set<String> hashSet = new HashSet<>(); // 블록의 xy 위치 고유값 만들기

        // 초기 블록 (0,0)위치와 점수1 세팅
        int x = 0, y = 0;
        stack.push(new int[]{x, y, 1});
        hashSet.add(x + "," + y);

        for (int i = 0; i < N; i++) {
            // 이동방향에 따른 x,y 위치
            String dir = String.valueOf(D.charAt(i));
            switch (dir) {
                case "R" -> x++;
                case "L" -> x--;
                case "U" -> y++;
                case "D" -> y--;
            }
            String key = x + "," + y;

            // 이미 블록이 있는 경우 제거
            while (hashSet.contains(key)) {
                // stack 제거
                int[] lastBlock = stack.pop();
                // 고유 키값 제거
                hashSet.remove(lastBlock[0] + "," + lastBlock[1]);
            }

            // 블럭 올려 놓기
            stack.push(new int[]{x, y, scores[i]});
            hashSet.add(key);

        }

        // 남은 블록 합산
        int totalScore = 0;
        for (int[] block : stack) {
            totalScore += block[2];
        }

        System.out.println(totalScore);
    }
}
/**
 * 블록게임 문제는 Stack, HashSet 자료구조 이용하는 것.
 * 각 자료구조의 저장하는 데이터 형식이 매우 중요
 * 스택 데이터 형식 : new int[]{x위치,y위치,점수}
 * 해쉬셋 데이터 형식 : x위치 + "," + y위치
 * - 점수는 달라도 x,y 위치가 동일한 케이스를 식별하기 위해 x와 y 조합으로 고유 키값을 관리하는 것이 핵심 포인트
 * - 문자열 조합은 자유 형태여도 상관없다.
 * 동일한 위치가 스택에 포함된다면, 스택에서 맨마지막 요소를 pop()하고, 요소의 정보로 HashSet에 고유키값을 제거할 수 있도록 한다.
 */