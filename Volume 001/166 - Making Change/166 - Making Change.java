import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int a[], memo[][], memo1[][][];
    static int coins[] = { 5, 10, 20, 50, 100, 200 };
    static final int IINF = (int) (1e8);
    static boolean v1[][][], v[][];
    static int value, n = 6;

    static int evaluate(int i, int c) {
        if (c == 0)
            return 0;

        if (c < 0 || i >= n)
            return IINF;

        if (v[i][c])
            return memo[i][c];
        v[i][c] = true;

        return memo[i][c] = Math.min(1 + evaluate(i, c - coins[i]), evaluate(i + 1, c));

    }

    static int solve(int i, int r, int c) {
        if (c > 700)
            return IINF;

        if (v1[i][r][c])
            return memo1[i][r][c];
        v1[i][r][c] = true;

        int x = IINF, y = IINF, z = IINF;

        if (c >= value) {
            x = evaluate(0, c - value);
        }

        if (r > 0)
            y = solve(i, r - 1, c + coins[i]);

        if (i + 1 < n)
            z = solve(i + 1, a[i + 1], c);

        return memo1[i][r][c] = Math.min(x, Math.min(1 + y, z));
    }

    public static void main(String[] args) throws IOException {

        memo = new int[n + 1][705];
        v = new boolean[n + 1][705];

        while (true) {
            a = new int[n];

            boolean isDone = true;

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                if (isDone && a[i] != 0)
                    isDone = false;
            }

            if (isDone)
                break;

            StringTokenizer st = new StringTokenizer(input.next(), ".");
            String ss = st.nextToken() + st.nextToken();

            value = Integer.parseInt(ss);

            memo1 = new int[7][705][705];
            v1 = new boolean[7][705][705];
            int sol = solve(0, a[0], 0);
            out.printf("%3d\n", sol);

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