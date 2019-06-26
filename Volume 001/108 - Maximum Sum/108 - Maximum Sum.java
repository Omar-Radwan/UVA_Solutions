import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        while (input.hasNext()) {
            int n = input.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = input.nextInt();
                    if (i > 0)
                        a[i][j] += a[i - 1][j];
                    if (j > 0)
                        a[i][j] += a[i][j - 1];
                    if (i > 0 && j > 0)
                        a[i][j] -= a[i - 1][j - 1];
                }
            }

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = i; l < n; l++) {
                        for (int k = j; k < n; k++) {
                            int current = a[l][k];
                            if (i > 0)
                                current -= a[i - 1][k];
                            if (j > 0)
                                current -= a[l][j - 1];

                            if (i > 0 && j > 0)
                                current += a[i - 1][j - 1];
                            max = Math.max(max, current);
                        }
                    }
                }
            }
            System.out.println(max);
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