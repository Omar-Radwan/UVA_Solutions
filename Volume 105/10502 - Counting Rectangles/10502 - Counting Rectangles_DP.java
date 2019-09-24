import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (true) {

            int n = input.nextInt();
            if (n == 0)
                break;
            int m = input.nextInt();
            if (m == 0)
                break;

            char c[][] = new char[n][m];
            int dp[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                c[i] = input.nextLine().toCharArray();
                for (int j = 0; j < m; j++) { dp[i][j] = c[i][j] == '1' ? 1 : 0; }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] += i > 0 ? dp[i - 1][j] : 0;
                    dp[i][j] += j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] -= i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                }
            }

            // i j start ... k l end;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = i; k < n; k++) {
                        for (int l = j; l < m; l++) {
                            int x = dp[k][l];
                            x -= i > 0 ? dp[i - 1][l] : 0;
                            x -= j > 0 ? dp[k][j - 1] : 0;
                            x += i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                            if ((k - i + 1) * (l - j + 1) == x) {
                                sum++;
                            }
                        }
                    }

                }
            }
            out.println(sum);

        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) { st = new StringTokenizer(br.readLine()); }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

        long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

        double nextDouble() throws NumberFormatException, IOException { return Double.parseDouble(next()); }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }

        boolean hasNext() throws IOException { return br.ready(); }
    }

}
