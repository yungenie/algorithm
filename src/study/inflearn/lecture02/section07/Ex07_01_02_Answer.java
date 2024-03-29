package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 타일 점프 - 넓이우선탐색 : BFS
 * 레벨 탐색
 * 2회독 틀림
 */
public class Ex07_01_02_Answer {

    public int solution(int[] nums){
        int n = nums.length; // 배열의 크기
        int[] ch = new int[n]; // 타일의 사용 체크
        ch[0] = 1; // 무조건 0번째부터 출발하므로 체크해둔다.
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // ✨ 배열의 인덱스를 넣어 탐색한다. (타일의 위치)

        // BFS 레벨탐색
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int cur = q.poll(); //현재레벨, 배열의 인덱스
                for (int j = 1; j <= nums[cur]; j++) { // 배열의 인덱스에 해당하는 점프력들 탐색
                    int jump = cur + j; //자식레벨 (점프하는 다음 타일)
                    if (jump == n-1) return L+1;
                    if (jump < n && ch[jump] == 0) {
                        ch[jump] = 1;
                        q.offer(jump);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){

        /*
            메모이제이션 1차원으로 하는 이유?
            - 타일이 행열로 되어 있는 게 아니라, 1차원 배열의 인덱스가 위치이다.
            - 집(0번째)에서 상점(n-1번째)까지의 타일(거리) 중에 최소 점프 횟수를 구하는 문제이므로
            - 1차원 체크배열을 생성하여 한 번 갔던 타일은 1로 체크 표시를 한다.

            i번째 타일 위에서 오른쪽으로 Ai이하만큼 점프
            - nums[i] == Ai
            - 예를들어
                - 0번째 타일에서 2이하만큼 점프를 한다면,
                - 0 -> 0,1,2타일로 점프해서 이동할 수 있다.
                - 1번째 타일에서 3이하만큼 점프를 한다면,
                - 1 -> 1,2,3,4타일로 점프할 수 있다.
                - 0의 점프력은 제자리 걸음이기 때문에 굳이 계산하지 않고 1의 점프력부터 레벨 탐색을 한다.
            - * 문제를 제대로 파악하지 못해 Ai ~ i + Ai 만큼 이동할 수 있구나 착각함.
         */
        Ex07_01_02_Answer T = new Ex07_01_02_Answer();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}



