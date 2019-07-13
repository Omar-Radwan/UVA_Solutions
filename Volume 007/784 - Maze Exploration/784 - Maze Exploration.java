import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static char g[][];
    static final int n = 30;
    static int length;
    static int dr[] = { 0, 0, 1, 1, 1, -1, -1, -1 };
    static int dc[] = { -1, 1, -1, 0, 1, -1, 0, 1 };

    static boolean isOut(int r, int c) {
        return r >= length || r < 0 || c >= g[r].length || c < 0;
    }

    static void paint(int r, int c) {
        if (!isOut(r, c) && (g[r][c] == ' ')) {
            g[r][c] = '#';

            for (int i = 0; i < dr.length; i++)
                paint(r + dr[i], c + dc[i]);

        }
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {
            g = new char[n][];

            for (int i = 0; i < n; i++) {
                g[i] = input.nextLine().toCharArray();
                if (g[i][0] == '_') {
                    length = i + 1;
                    break;
                }

            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    if (g[i][j] == '*') {
                        g[i][j] = ' ';
                        paint(i, j);
                        break;
                    }
                }
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    out.print(g[i][j]);
                }
                out.println();
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