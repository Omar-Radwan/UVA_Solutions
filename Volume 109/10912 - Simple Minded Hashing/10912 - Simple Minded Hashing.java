import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MAXN = (int) 400;
    static int l, s, memo[][][];
    static boolean v[][][];

    static int solve(int rem, int prev, int length) {
        if (rem == 0 && length == 0)
            return 1;

        if (rem <= 0 || prev <= 0 || length <= 0)
            return 0;

        if (v[rem][prev][length])
            return memo[rem][prev][length];
        v[rem][prev][length] = true;

        int sum = 0;

        for (int i = prev - 1; i >= 1; i--) {
            sum += solve(rem - i, i, length - 1);
        }

        return memo[rem][prev][length] = sum;

    }

    public static void main(String[] args) throws IOException {

        memo = new int[MAXN][28][28];
        v = new boolean[MAXN][28][28];
        int x = 1;
        while (true) {
            l = input.nextInt();
            s = input.nextInt();
            if (l == 0)
                break;
            int ans = 0;
            if (s < MAXN && l < 27)
                ans = solve(s, 27, l);

            out.println("Case " + x++ + ": " + ans);
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