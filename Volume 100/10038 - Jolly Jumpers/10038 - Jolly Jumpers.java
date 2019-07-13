import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }
            boolean found[] = new boolean[n];
            found[0] = true;

            for (int i = 1; i < n; i++) {
                int diff = Math.abs(a[i] - a[i - 1]);
                if (diff > 0 && diff < found.length) {
                    found[diff] = true;
                }
            }

            boolean ans = true;

            for (int i = 0; i < n; i++) {
                if (!found[i]) {
                    ans = false;
                    break;
                }
            }

            out.println(ans ? "Jolly" : "Not jolly");

            if (!input.hasNext())
                break;

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