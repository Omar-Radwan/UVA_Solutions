import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int _IINF = (int) (-1e9 - 20);

    /*
    * 
    */

    static int[][] a;
    static int[][][] memo;
    static boolean[][][] v;

    static int solve(int m, int i, int j) {
        if (m < 0)
            return _IINF;
        if (i >= a.length)
            return 0;
        if (j >= a[i].length)
            return _IINF;

        if (v[m][i][j])
            return memo[m][i][j];
        v[m][i][j] = true;

        return memo[m][i][j] = Math.max(a[i][j] + solve(m - a[i][j], i + 1, 0), solve(m, i, j + 1));
    }

    public static void main(String[] args) throws IOException {
        int n = input.nextInt();
        while (n-- > 0) {
            int m = input.nextInt();
            int c = input.nextInt();
            a = new int[c][];
            for (int i = 0; i < c; i++) {

                a[i] = new int[input.nextInt()];

                for (int j = 0; j < a[i].length; j++)
                    a[i][j] = input.nextInt();
            }
            memo = new int[m + 5][c + 5][25];
            v = new boolean[m + 5][c + 5][25];
            int ans = solve(m, 0, 0);
            out.println(ans >= 0 ? ans : "no solution");
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