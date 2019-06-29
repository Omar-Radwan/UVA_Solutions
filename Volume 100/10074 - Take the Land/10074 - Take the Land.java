import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int[][] a;

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            int m = input.nextInt();
            if (n == 0 && m == 0)
                break;
            a = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = input.nextInt();
                    a[i][j] += i > 0 ? a[i - 1][j] : 0;
                    a[i][j] += j > 0 ? a[i][j - 1] : 0;
                    a[i][j] -= i > 0 && j > 0 ? a[i - 1][j - 1] : 0;

                }
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int l = i; l < n; l++) {
                        for (int k = j; k < m; k++) {
                            int sum = a[l][k];
                            sum -= i > 0 ? a[i - 1][k] : 0;
                            sum -= j > 0 ? a[l][j - 1] : 0;
                            sum += i > 0 && j > 0 ? a[i - 1][j - 1] : 0;
                            if (sum == 0)
                                max = Math.max(max, (l - i + 1) * (k - j + 1));
                        }
                    }
                }
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