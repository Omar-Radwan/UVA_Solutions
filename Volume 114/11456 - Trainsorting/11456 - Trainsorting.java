import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, a[];
    static boolean[][] vLis, vLds;
    static int[][] lis, lds;

    static int lis(int i, int p) {
        if (i >= n)
            return 0;

        if (vLis[i][p])
            return lis[i][p];
        vLis[i][p] = true;

        int take = a[i] >= a[p] ? 1 + lis(i + 1, i) : 0;
        int leave = lis(i + 1, p);

        return lis[i][p] = Math.max(take, leave);
    }

    static int lds(int i, int p) {
        if (i >= n)
            return 0;

        if (vLds[i][p])
            return lds[i][p];
        vLds[i][p] = true;

        int take = a[i] <= a[p] ? 1 + lds(i + 1, i) : 0;
        int leave = lds(i + 1, p);

        return lds[i][p] = Math.max(take, leave);

    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            lis = new int[n + 1][n + 1];
            lds = new int[n + 1][n + 1];
            vLis = new boolean[n + 1][n + 1];
            vLds = new boolean[n + 1][n + 1];

            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();

            int max = 0;

            for (int i = 0; i < n; i++) {
                max = Math.max(lds(i, i) + lis(i, i) - 1, max);
            }
            out.println(max);

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