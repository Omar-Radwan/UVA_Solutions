import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MAXN = (int) 1e6;

    public static void main(String[] args) throws IOException {

        while (true) {

            int y = input.nextInt();
            int p = input.nextInt();

            int a[] = new int[p];
            for (int i = 0; i < p; i++) {
                a[i] = input.nextInt();
            }

            int max = -1, u = -1, v = -1;
            for (int i = 0; i < p; i++) {
                while (i < p - 1 && a[i + 1] == a[i])
                    i++;

                int x = a[i] - y + 1;

                int l = 0;
                int r = i;

                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (a[m] >= x)
                        r = m;
                    else
                        l = m + 1;
                }

                int curr = i - l + 1;
                if (curr > max) {
                    max = curr;
                    u = a[l];
                    v = a[i];
                }

            }

            out.println(max + " " + u + " " + v);

            if (!input.hasNext())
                break;

            input.nextLine();
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