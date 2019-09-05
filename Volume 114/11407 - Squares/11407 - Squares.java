import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MAXN = (int) 1e4;
    static int memo[];
    static boolean v[];

    static int solve(int n) {
        if (n == 0)
            return 0;
        if (v[n])
            return memo[n];
        v[n] = true;
        int min = n;
        int s = binarySearch(n);
        while (s > 0) {
            min = Math.min(min, 1 + solve(n - (s * s)));
            s--;
        }
        return memo[n] = min;

    }

    static int binarySearch(int key) {
        int l = 1;
        int r = key;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (m * m <= key) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        v = new boolean[MAXN + 1];
        memo = new int[MAXN + 1];
        while (t-- > 0) {
            int n = input.nextInt();
            out.println(solve(n));
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