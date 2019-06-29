import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int[][] matrix;
    static long[][] memo;
    static boolean[][] v;
    static int n, m;

    static long solve(int i, int j) {
        if (j >= m) {
            return 0;
        }

        if (v[i][j])
            return memo[i][j];
        v[i][j] = true;

        int prev = i - 1 < 0 ? n - 1 : i - 1;
        int next = i + 1 == n ? 0 : i + 1;

        long x = Math.min(solve(prev, j + 1), solve(next, j + 1));
        long y = solve(i, j + 1);
        return memo[i][j] = matrix[i][j] + Math.min(x, y);
    }

    static void print(int i, int j) {
        if (j >= m) {
            return;
        }

        int prev = i - 1 < 0 ? n - 1 : i - 1;
        int next = i + 1 == n ? 0 : i + 1;

        long optimal = solve(i, j) - matrix[i][j];

        if (j != 0)
            out.print(" ");

        out.print((i + 1));
        if (j == m - 1)
            out.println();

        int[] candidates = { i, prev, next };
        Arrays.sort(candidates);
        for (int k = 0; k < 3; k++) {
            if (optimal == solve(candidates[k], j + 1)) {
                print(candidates[k], j + 1);
                return;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        while (input.hasNext()) {
            n = input.nextInt();
            m = input.nextInt();

            matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            memo = new long[n + 5][m + 5];
            v = new boolean[n + 5][m + 5];

            long ans = Integer.MAX_VALUE;
            int ansRow = -1;

            for (int j = 0; j < n; j++) {
                long curr = solve(j, 0);
                if (curr < ans) {
                    ans = curr;
                    ansRow = j;
                }
            }

            print(ansRow, 0);
            out.println(ans);

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