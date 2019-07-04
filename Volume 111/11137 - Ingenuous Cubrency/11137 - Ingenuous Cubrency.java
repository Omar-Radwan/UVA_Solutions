import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, a[];
    static long memo[][];
    static boolean v[][];
    static final int MAXN = 10000;

    static long solve(int i, int rem) {
        if (rem == 0)
            return 1;

        if (i <= 0 || rem < 0)
            return 0;

        if (v[i][rem])
            return memo[i][rem];

        v[i][rem] = true;

        return memo[i][rem] = solve(i, rem - a[i]) + solve(i - 1, rem);

    }

    public static void main(String[] args) throws IOException {

        n = 22;
        a = new int[n];

        for (int i = 1; i < n; i++)
            a[i] = i * i * i;

        memo = new long[n][MAXN + 5];
        v = new boolean[n][MAXN + 5];

        while (input.hasNext()) {
            int x = input.nextInt();
            long sol = solve(21, x);
            out.println(sol);
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