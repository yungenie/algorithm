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
        int[] tiket = new int[n + 1]; // n+1의 이유는 0부터 누적합산하기 위함.

        // 주어진 trans 배열의 데이터로만 탑승 및 하차 인원 초기화
        for (int[] x : trans) {
            tiket[x[0]] += x[2]; // 출발역 수용인원 만큼 승차
            tiket[x[1]] -= x[2]; // 도착역 수용인원 만큼 하차
        }
        // 기차역마다 최대 승차 인원수
        for (int i = 1; i < tiket.length; i++) {
            tiket[i] = tiket[i] + tiket[i - 1]; // i번째 역에서 태울 수 있는 최대 인원
        }
//        System.out.println(Arrays.toString(tiket));
        // 승차역 오름차순
        Arrays.sort(bookings, (a,b) -> a[0] - b[0]);

        // 어린이 번호, 어린이 예약 총 수
        int cidx = 0, cLen = bookings.length;

        // 어린이 태우기 (도착역 번호 붙여서)
        LinkedList<Integer> trains = new LinkedList<>();
        for (int i = 1; i <= n ; i++) { // 기차역 탐색

            // 도착역에 내리는 어린이 하차 시키기
            while(!trains.isEmpty() && trains.peek() == i) {
//                answer++;
                trains.pollFirst(); // 도착역 오름차순으로 정렬했기 때문에 하차
            }

            // 각 예약정보의 해당 역에서 어린이 기차 태우기
            while(cidx < cLen && i == bookings[cidx][0]) {
                trains.add(bookings[cidx][1]); // 도착역 번호
                cidx++;
                answer++;
            }
            Collections.sort(trains); // 도착역 오름차순

            // 수용인원보다 넘치는 경우
            while(trains.size() > tiket[i]){ // 기차에 탑승한 어린이 수보다 수용인원에 넘치는 경우
                trains.pollLast(); // 가장 나중에 내리는 어린이 하차
                answer--;
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
