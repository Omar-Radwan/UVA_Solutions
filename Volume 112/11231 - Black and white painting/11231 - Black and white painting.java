import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String args[]) throws IOException {

        while (true) {

            int n = input.nextInt();
            int m = input.nextInt();
            int c = input.nextInt();

            if (n == 0 && m == 0 && c == 0)
                break;

            int x = n * m - 7 * m - (n - 7) * 7;

            if (c == 1)
                out.println((x + 1) / 2);

            else
                out.println(x / 2);

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
    }

}
