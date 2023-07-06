package study.baekjoon;


public class DP_12865_v4 {
    public static void main(String[] args) throws Exception {
        int N = read(), K = read();
        int[] DP = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int W = read(), V = read();
            for (int j = K; j >= W; j--)
                if (DP[j] < DP[j - W] + V) DP[j] = DP[j - W] + V;
        }

        System.out.print(DP[K]);
    }
    //https://velog.io/@kku64r/read
    //https://blog.naver.com/jihogrammer/222314445259

    /**
     * IO Template reference : 백준 	uhuru0614님
     */
    private static int read() throws Exception {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;

    }
}
