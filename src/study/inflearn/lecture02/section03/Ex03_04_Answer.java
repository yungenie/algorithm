package study.inflearn.lecture02.section03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 피부과 - 자료구조 활용
 * 문제개요 - Queue를 활용해서 조건에 따라 처리하고, 시간을 분으로 변경해야하는 문제입니다.
 * 로직요약
 * (1) 문자열 배열에 고객의 방문시간을 분으로 변경하고, 고객의 레이저 종류를 숫자로 변환 후 2차원 숫자형 배열에 담습니다.
 * (2) 대기하는 최대 인원수를 알아내기 위해
 *      (2-1) 첫고객은 앞에 대기하는 고객이 없으므로, 대기실에 레이저 종류를 담은 후 들어온 시간을 끝난 시간에 초기화 시킵니다.
 *      (2-2) 제한사항에 고객의 입장시간은 9:00~20:00까지로 시간 제한을 1200으로 둔다. t는 시간의 흐름을 나타내며 1분씩 증가하고, 초기값은 첫고객의 시술이 끝난 시간으로 초기화합니다.
 *      (2-3) 처리할 고객이 있고, 현재시각과 고객이 들어온 시간이 같은 경우는 대기실에 넣어줍니다. (단, 대기실이 비었거나 시술이 끝난 시간 이후에 고객이 들어온 경우는  고객이 들어온 시간을 끝난시간으로 넣습니다.)
 *      (2-4) 현재시각과 현재 시술이 끝난 시간이 같고, 대기 고객이 있는 경우는 다음 고객 시술이 끝날 시간을 업데이트 해줍니다.
 *      (2-5) 현재 대기실의 고객 인원수를 구합니다.
 * 배운점
 * int[][] inList = new int[n][2]; 왜 [2]인지 정확히 몰랐음, 2차원 배열 선언에서 행과 열의 의미
 * LinkedList는 Queue 인터페이스의 대표적인 구현체이다. Queue q = new Queue 선언하고 있었음
 *
 */
public class Ex03_04_Answer {
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;

        //고객이 방문한 시간과 시술받을 레이저 번호 정보 (1)
        int[][] inList = new int[n][2]; // 문자열 배열을 2차원 정수형 배열로 변환
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]); //고객의 방문시간 (분단위로 변경)
            int b = Integer.parseInt(enter[i].split(" ")[1]); //고객의 레이저 종류
            inList[i][0] = a; //도착시간
            inList[i][1] = b; //시술시간
        }

        //대기하는 최대 인원수 (2)
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]); //첫고객의 레이저 종류 (2-1)
        int fT = inList[0][0]; //시술 끝난 시간 - 첫번째 고객의 들어온시간으로 초기화 (앞에 고객이 없기 때문에 앞의 고객이 끝났다 가정) (2-1)
        int pos = 1; //inList 접근하기 위한 변수로 두번째 고객부터 접근
        for(int t = fT; t <= 1200; t++){ //고객이 방문한시간 09:00부터 20:00까지이므로 1200(20:00)까지로 설정 (1분씩 증가) (2-2)
            if(pos < n && t == inList[pos][0]){ //현재시각과 고객들어온 시간이 같은 경우 (2-3)
                if(Q.isEmpty() && inList[pos][0] > fT) {
                    fT = t; //fT= inList[pos][0]; //대기 고객 없고, 시술 끝난 시간 이후에 고객이 들어온 경우
                }
                Q.offer(inList[pos][1]); // 시술 중에 왔거나, 시술 끝난 시간에 온 경우 대기실 넣기 - 레이저 종류를 값으로 넣기
                pos++; //다음 고객 처리
            }
            if(t == fT && !Q.isEmpty()){ //현재시각과 현재 시술 끝난 시간이 같고, 대기 고객 있는 경우 (2-4)
                int idx = Q.poll(); //다음 대기고객 시술시간
                fT += laser[idx]; //대기고객 시술 끝날 시간 (현재 시술 끝난 시간 + 시술시간)
            }
            answer = Math.max(answer, Q.size()); //(2-5)
        }
        return answer;
    }

    public static void main(String[] args){
        Ex03_04_Answer T = new Ex03_04_Answer();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
