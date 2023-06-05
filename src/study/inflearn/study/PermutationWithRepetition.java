package study.inflearn.study;

/**
 * 중복순열 - Permutation With Repetition
 */
public class PermutationWithRepetition {

    static int[] pm;
    static int n,m;
    public void DFS(int L) {
        if (L==m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationWithRepetition T = new PermutationWithRepetition();
        n = 3;
        m = 2;
        pm = new int[m];
        T.DFS(0);
    }

}
