import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {

            int x = input.nextInt();

            int[] c = new int[x + 1];

            for (int i = 0; i <= x; i++) {
                c[i] = input.nextInt();
            }

            int d = input.nextInt();
            int k = input.nextInt();

            int m = 1;
            int n = 1;
            while (m + (n * d) <= k) {
                m += (n * d);
                n++;
            }

            long ans = 0;

            for (int i = 0; i <= x; i++) {
                ans += (1L * c[i] * Math.pow(n, i));
            }

            System.out.println(ans);

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
    }

}