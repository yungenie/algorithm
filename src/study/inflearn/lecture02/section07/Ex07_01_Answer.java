package study.inflearn.lecture02.section07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 타일 점프 - 넓이우선탐색 : BFS
 * 레벨 탐색
 */
public class Ex07_01_Answer {
    public int solution(int[] nums){
        int n = nums.length;
        int[] ch = new int[n]; // 한번 방문한 지점 체크, 방문했던 지점은 탐색하지 않기 위함
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        ch[0] = 1;
        int L = 0;

        // 레벨 탐색
        while(!q.isEmpty()){
            int len = q.size(); // 레벌의 노드수
            // 부모 레벨 탐색
            for(int i = 0; i < len; i++){
                int x = q.poll();
                // 자식노드 레벨 탐색 (최단 거리)
                for(int j = 1; j <= nums[x]; j++){ // j는 1씩 덧셈, nums[x] x는 q에 저장되어 있는 인덱스.
                    int nx = x + j; // 부모레벨(배열인덱스)에서 점프가능횟수까지 점프력 더하기
                    if(nx == n-1) return L + 1; // 현수가 상점에 도착했을 경우
                    if(nx < n  && ch[nx]==0){ // 점프력이 상점위치보다 작고, 방문한 지점이 아닌 경우
                        ch[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Ex07_01_Answer T = new Ex07_01_Answer();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
