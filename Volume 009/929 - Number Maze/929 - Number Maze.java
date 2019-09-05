import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m, c[][], d[][];
    static final int INF = (int) Integer.MAX_VALUE;
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            m = input.nextInt();

            c = new int[n][m];
            d = new int[n][m];
            for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) { c[i][j] = input.nextInt(); } }
            for (int i = 0; i < n; i++) { Arrays.fill(d[i], INF); }

            PriorityQueue<Triple> pq = new PriorityQueue<>();
            pq.add(new Triple(c[0][0], 0, 0));
            d[0][0] = c[0][0];

            while (!pq.isEmpty()) {
                Triple cur = pq.poll();

                int pdist = cur.x;
                int px = cur.y;
                int py = cur.z;

                if (pdist > d[px][py])
                    continue;

                for (int i = 0; i < dx.length; i++) {
                    int nx = px + dx[i];
                    int ny = py + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;

                    int nd = pdist + c[nx][ny];
                    if (nd < d[nx][ny]) {
                        d[nx][ny] = nd;
                        pq.add(new Triple(nd, nx, ny));
                    }

                }
            }

            out.println(d[n - 1][m - 1]);

        }
        out.flush();
    }

    static class Triple implements Comparable<Triple> {
        int x;
        int y;
        int z;

        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Triple o) {
            if (x == o.x && y == o.y)
                return z - o.z;
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + x + ", " + y + ", " + z + ")"; }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) { st = new StringTokenizer(br.readLine()); }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

        long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

        double nextDouble() throws NumberFormatException, IOException { return Double.parseDouble(next()); }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }

        boolean hasNext() throws IOException { return br.ready(); }
    }

}