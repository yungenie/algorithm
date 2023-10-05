package study.programmers.dfs_bfs;

public class Level2_타겟넘버 {

    int result;
    int[] num;
    int target;

    public void DFS(int L, int sum){
        if (L == this.num.length) {
            if (sum == this.target) {
                result++;
            }
            return;
        }

        DFS(L + 1, sum + num[L]);
        DFS(L + 1, sum - num[L]);

    }
    public int solution(int[] numbers, int target) {
        this.result = 0;
        this.num = numbers;
        this.target = target;

        DFS(0, 0);

        return result;
    }
    public static void main(String[] args) {
        Level2_타겟넘버 T = new Level2_타겟넘버();
        System.out.println(T.solution(new int[]{1, 1, 1, 1, 1},3)); //5
        System.out.println(T.solution(new int[]{4, 1, 2, 1},4)); //2
    }
}
