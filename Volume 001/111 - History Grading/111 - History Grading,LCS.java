import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static int[] real, student;
    static int[][] memo;
    static boolean[][] v;
    static int n;

    static int solve(int i, int j) {

        if (i >= n || j >= n)
            return 0;

        if (v[i][j])
            return memo[i][j];

        v[i][j] = true;

        if (real[i] == student[j])
            return memo[i][j] = 1 + solve(i + 1, j + 1);
        return memo[i][j] = Math.max(solve(i + 1, j), solve(i, j + 1));
    }

    public static void main(String[] args) throws IOException {

        String s = input.nextLine();

        while (input.hasNext()) {
            n = Integer.parseInt(s);

            real = new int[n];

            for (int i = 0; i < n; i++) {
                real[input.nextInt() - 1] = i;
            }

            while (input.hasNext()) {
                s = input.nextLine();
                StringTokenizer st = new StringTokenizer(s);
                if (st.countTokens() == 1)
                    break;
                student = new int[n];
                memo = new int[n + 5][n + 5];
                v = new boolean[n + 5][n + 5];
                for (int i = 0; i < n; i++) {
                    int time = Integer.parseInt(st.nextToken());
                    student[time - 1] = i;
                }

                int ans = solve(0, 0);
                System.out.println(ans);

            }

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