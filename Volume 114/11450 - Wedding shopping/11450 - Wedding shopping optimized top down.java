import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int _IINF = (int) (-1e9 - 20);

    /*
    * 
    */

    static int[][] a;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        int n = input.nextInt();
        while (n-- > 0) {
            int m = input.nextInt();
            int c = input.nextInt();

            a = new int[c][];
            v = new boolean[2][m + 1];

            for (int i = 0; i < c; i++) {

                a[i] = new int[input.nextInt()];

                for (int j = 0; j < a[i].length; j++)
                    a[i][j] = input.nextInt();
            }

            for (int i = 0; i < a[0].length; i++) {
                int p = a[0][i];
                if (m - p >= 0)
                    v[0][m - p] = true;
            }
            int current = 1;
            int prev = 0;

            for (int i = 1; i < a.length; i++) {
                for (int k = 0; k < a[i].length; k++) {
                    int p = a[i][k];
                    for (int j = 0; j <= m; j++) {
                        if (v[prev][j] && j - p >= 0) {
                            v[current][j - p] = true;
                        }
                    }
                }
                Arrays.fill(v[prev], false);
                prev ^= 1;
                current ^= 1;
            }

            int best = -1;

            for (int i = 0; i <= m && best == -1; i++) {
                if (v[prev][i])
                    best = i;
            }

            out.println(best >= 0 ? m - best : "no solution");
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
    }

}