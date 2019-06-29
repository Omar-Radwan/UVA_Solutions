import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static int[] coins = { 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };
    static long[][] memo;
    static boolean[][] v;

    static long solve(int i, int m) {
        if (m == 0)
        return 1;
        
        if (m < 0||i >= coins.length)
            return 0;

        if (v[m][i])
            return memo[m][i];
        
        v[m][i] = true;
        
        return memo[m][i] = (solve(i, m - coins[i]) + solve(i + 1, m));
    }

    public static void main(String[] args) throws IOException {
        memo = new long[30000 + 5][12];
        v = new boolean[30000 + 5][12];

        while (true) {
            String integer = "";
            String s = input.nextLine();
            StringTokenizer st = new StringTokenizer(s, ".");
            integer += st.nextToken();
            integer += st.nextToken();

            int x = Integer.parseInt(integer);
            if (x == 0)
                break;
            long ans = solve(0, x);
            out.printf("%6s%17d\n", s, ans);
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