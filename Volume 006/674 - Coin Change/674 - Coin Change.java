import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static long[][] memo;
    static boolean[][] v;
    static int[] a = { 50, 25, 10, 5, 1 };

    static long solve(int n, int i) {
        if (n == 0)
            return 1;
        if (n < 0 || i >= a.length)
            return 0;

        if (v[n][i])
            return memo[n][i];

        v[n][i] = true;

        return memo[n][i] = solve(n - a[i], i) + solve(n, i + 1);
    }

    public static void main(String[] args) throws IOException {

        memo = new long[7489 + 5][5];
        v = new boolean[7489 + 5][5];

        while (input.hasNext()) {
            int n = input.nextInt();
            out.println(solve(n, 0));

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