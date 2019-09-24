import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {

            int m = input.nextInt();
            int n = input.nextInt();
            int q = input.nextInt();

            char s[][] = new char[m][];

            for (int i = 0; i < m; i++) { s[i] = input.nextLine().toCharArray(); }
            int f = 0;
            out.println(m+" "+n+" "+q);
            while (f++ < q) {
                int r = input.nextInt();
                int c = input.nextInt();

                int boundRow = Math.min(r, m - r - 1);
                int boundCol = Math.min(c, n - c - 1);
                int bound = Math.min(boundRow, boundCol);

                // j k start row start col .. x y end row end col
                int max = Integer.MIN_VALUE;

                for (int i = 0; i <= bound; i++) {
                    int j = r - i, k = c - i, x = r + i, y = c + i;
                    char must = s[j][c - i];
                    int cur = x - j + 1;

                    for (; j <= x; j++) {
                        for (k = c - i; k <= y; k++) {
                            if (s[j][k] != must) {
                                cur = -1;
                                break;
                            }
                        }
                    }

                    max = Math.max(max, cur);
                }
                out.println(max);

            }

            out.flush();
        }

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
