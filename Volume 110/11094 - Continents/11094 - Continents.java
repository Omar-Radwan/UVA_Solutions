import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static char g[][];
    static int n, m;
    static char L, W = 'X';
    static int dr[] = { 0, 0, 1, -1 };
    static int dc[] = { -1, 1, 0, 0 };

    static boolean isOut(int r, int c) {
        return r >= n || r < 0 || c >= m || c < 0;
    }

    static int count(int r, int c) {
        int ret = 0;
        if (!isOut(r, c) && g[r][c] == L) {
            g[r][c] = W;
            ret = 1;
            for (int i = 0; i < dr.length; i++) {
                int nC = c + dc[i];
                if (nC == m)
                    nC = 0;
                else if (nC == -1)
                    nC = m - 1;
                ret += count(r + dr[i], nC);
            }

        }
        return ret;
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            n = input.nextInt();
            m = input.nextInt();

            g = new char[n][];

            for (int i = 0; i < n; i++) {
                g[i] = input.nextLine().toCharArray();
            }

            int x = input.nextInt();
            int y = input.nextInt();

            L = g[x][y];
            count(x, y);
            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    if (g[i][j] == L) {
                        max = Math.max(max, count(i, j));
                    }
                }
            }

            input.nextLine();
            out.println(max);

            if (!input.hasNext()) {
                break;
            }
        }
        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }

        boolean hasNext() throws IOException {
            return br.ready();
        }
    }

}