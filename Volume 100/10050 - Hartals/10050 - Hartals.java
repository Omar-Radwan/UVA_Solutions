import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, p;
    static boolean days[];

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            days = new boolean[n + 1];
            p = input.nextInt();

            for (int i = 0; i < p; i++) {
                int h = input.nextInt();

                for (int k = h; k <= n; k += h) {
                    if (k % 7 == 0 || (k - 6) % 7 == 0)
                        continue;
                    days[k] = true;
                }

            }
            int cnt = 0;
            for (boolean b : days) {
                cnt += b ? 1 : 0;
            }
            out.println(cnt);
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