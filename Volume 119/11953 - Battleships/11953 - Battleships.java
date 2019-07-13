import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static char g[][];
    static int n;

    static int dr[] = { 0, 0, -1, 1 };
    static int dc[] = { -1, 1, 0, 0 };

    static boolean isOut(int r, int c) {
        return r >= n || r < 0 || c >= n || c < 0;
    }

    static void delShip(int r, int c) {
        if (!isOut(r, c) && g[r][c] != '.') {
            g[r][c] = '.';
            for (int i = 0; i < dr.length; i++) {
                delShip(r + dr[i], c + dc[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        for (int k = 1; k <= t; k++) {
            n = input.nextInt();

            g = new char[n][];
            for (int i = 0; i < n; i++) {
                g[i] = input.nextLine().toCharArray();
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == 'x') {
                        delShip(i, j);
                        sum++;
                    }
                }
            }
            out.println("Case " + k + ": " + sum);

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