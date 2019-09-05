import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static final int _INF = (int) -1e9;

    static int memo[][], n, wl[][];
    static boolean v[][];

    // topdown code
    static int solve(int i, int rem) {
        if (rem < 0)
            return _INF;

        if (i >= n)
            return 0;

        if (v[i][rem])
            return memo[i][rem];

        v[i][rem] = true;
        int take = 1 + solve(i + 1, Math.min(rem - wl[i][0], wl[i][1]));
        int leave = solve(i + 1, rem);

        return memo[i][rem] = Math.max(take, leave);
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            n = input.nextInt();
            if (n == 0)
                break;

            wl = new int[n][2];
            memo = new int[n + 1][7001];
            v = new boolean[n + 1][7001];

            for (int i = 0; i < n; i++) {
                wl[i][0] = input.nextInt();
                wl[i][1] = input.nextInt();
            }

            // out.println(solve(0, 7000));

            // buttom up code
            int dp[][] = new int[n + 1][7001];

            for (int i = n - 1; i >= 0; i--) {
                for (int rem = 1; rem < 7001; rem++) {
                    int min = Math.min(rem - wl[i][0], wl[i][1]);
                    int take = min >= 0 ? 1 + dp[i + 1][min] : _INF;
                    int leave = dp[i + 1][rem];
                    dp[i][rem] = Math.max(take, leave);
                }
            }
            out.println(dp[0][7000]);
        }

        out.flush();
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