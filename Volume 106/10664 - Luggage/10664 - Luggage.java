import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, a[];
    static boolean v[][][], memo[][][];;

    static boolean solve(int i, int w1, int w2) {

        if (i >= n)
            return w1 == w2;

        if (v[i][w1][w2])
            return memo[i][w1][w2];

        v[i][w1][w2] = true;

        return memo[i][w1][w2] = solve(i + 1, w1 + a[i], w2) || solve(i + 1, w1, w2 + a[i]);
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {

            String s = input.nextLine();

            StringTokenizer st = new StringTokenizer(s);

            n = st.countTokens();
            a = new int[n];
            memo = new boolean[n + 5][200 + 5][200 + 5];
            v = new boolean[n + 5][200 + 5][200 + 5];

            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            boolean sol = solve(0, 0, 0);

            out.println(sol ? "YES" : "NO");

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