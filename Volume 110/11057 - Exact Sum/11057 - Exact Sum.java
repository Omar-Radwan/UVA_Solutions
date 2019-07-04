import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        while (true) {

            int n = input.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();

            int x = input.nextInt();
            input.nextLine();
            Arrays.sort(a);

            int l = 0;
            int r = n - 1;

            int u = -1;
            int v = -1;

            while (l < r) {
                if (a[l] + a[r] > x) {
                    r--;
                } else if (a[l] + a[r] < x) {
                    l++;
                } else {
                    u = a[l];
                    v = a[r];
                    l++;
                    r--;
                }
            }
            out.println("Peter should buy books whose prices are " + u + " and " + v + ".\n");
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