import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int t, p, n, a[];

    static boolean solve(int n, int i) {
        if (n == 0)
            return true;
        if (i >= p || n < 0)
            return false;
        return solve(n - a[i], i + 1) || solve(n, i + 1);
    }

    public static void main(String[] args) throws IOException {
        t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            p = input.nextInt();
            a = new int[p];

            for (int i = 0; i < p; i++)
                a[i] = input.nextInt();

            boolean ans = solve(n, 0);
            out.println(ans ? "YES" : "NO");
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