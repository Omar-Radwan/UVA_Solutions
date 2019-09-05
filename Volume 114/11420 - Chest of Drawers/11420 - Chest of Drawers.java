import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static final int MAXN = 65;
    static BigInteger memo[][][];
    static boolean v[][][];

    static BigInteger solve(int n, int s, int p) {
        if (s == 0 && n == 0)
            return BigInteger.ONE;

        if (n <= 0 || s < 0)
            return BigInteger.ZERO;

        if (v[n][s][p])
            return memo[n][s][p];
        v[n][s][p] = true;

        BigInteger x = p == 1 ? solve(n - 1, s - 1, 1) : solve(n - 1, s, 1);
        BigInteger y = solve(n - 1, s, 0);

        return memo[n][s][p] = x.add(y);
    }

    public static void main(String[] args) throws IOException {
        memo = new BigInteger[MAXN + 10][MAXN + 10][5];
        v = new boolean[MAXN + 10][MAXN + 10][5];

        while (true) {
            int n = input.nextInt();
            int s = input.nextInt();
            if (n < 0)
                break;

            BigInteger ans = solve(n, s, 1);
            out.println(ans.toString());
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