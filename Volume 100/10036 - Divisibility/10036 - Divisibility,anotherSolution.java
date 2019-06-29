import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();

    static int[] a;
    static int n, k;

    static boolean[][] memo;
    static boolean[][] v;

    static boolean solve(int i, int m) {
        if (i >= n)
            return m == 0;

        if (v[i][m])
            return memo[i][m];

        v[i][m] = true;

        boolean x = solve(i + 1, (a[i] + m) % k);
        boolean y = solve(i + 1, (k + (a[i] - m)) % k);
        return x | y;
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            k = input.nextInt();

            a = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = (k + (input.nextInt() % k)) % k;

            memo = new boolean[n + 5][105];
            v = new boolean[n + 5][105];

            System.out.println(solve(0, 0) ? "Divisible" : "Not divisible");
        }
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