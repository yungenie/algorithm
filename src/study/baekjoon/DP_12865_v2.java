package study.baekjoon;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DP_12865_v2 {
    public int solution(int N, int K, int[][] WV) {

        // DP탐색
        int[] dp = new int[K + 1]; // idx 버틸무게, value 가치
        for (int i = 0; i < N; i++) {
            int W = WV[i][0]; // 각 물건 무게 W
            int V = WV[i][1]; // 각 물건의 가치 V

            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }
        return dp[K];
    }

    public static void main(String[] args) throws IOException {
        DP_12865_v2 T = new DP_12865_v2();
        FastReader fr = new FastReader();
        int N = fr.nextInt(); // 물품 수 N
        int K = fr.nextInt(); // 버틸 무게 K

        int[][] WV = new int[N][2];
        for (int i = 0; i < N; i++) {
            WV[i][0] = fr.nextInt(); // 각 물건 무게 W
            WV[i][1] = fr.nextInt(); // 각 물건의 가치 V
        }
        System.out.println(T.solution(N, K, WV));
    }

    /**
     *  IO Template reference : 백준 soato1405님
     */
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}
