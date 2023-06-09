package study.inflearn.lecture02.section05;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 최대 인원수 - greedy
 */
public class Ex05_06_Answer {
    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;
        int[] sum = new int[n + 1]; // n+1 이유? 0부터 누적합산하기 위함.

        // 기차역마다 최대 승차 인원수
        for (int[] x : trans) {
            sum[x[0]] += x[2]; // 출발역 수용인원 만큼 승차
            sum[x[1]] -= x[2]; // 도착역 수용인원 만큼 하차
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i] + sum[i - 1]; // i번째 역에서 태울 수 있는 최대 인원
        }

        Arrays.sort(bookings, (a,b) -> a[0] - b[0]); // 승차역 오름차순

        int idx = 0, bLen = bookings.length;
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n ; i++) {

            // 도착역에 내리는 어린이 하차 시키기
            while(!nums.isEmpty() && nums.peek() == i) {
                answer++;
                nums.pollFirst();
            }

            // 역마다 기차 태우기
            while(idx < bLen && bookings[idx][0] == i) {
                nums.add(bookings[idx][1]); // 도착역 추가
                idx++;
            }
            Collections.sort(nums); // 도착역 오름차순

            // 수용인원보다 넘치는 경우
            while(nums.size() > sum[i]){
                nums.pollLast(); // 가장 멀리가는 어린이 하차
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Ex05_06_Answer T = new Ex05_06_Answer();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
