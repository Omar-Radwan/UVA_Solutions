import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    static int firstTrueInc(int k) {
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            int m = l + ((r - l) >> 2);

            if (a[m] >= k)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) throws IOException {

        while (input.hasNext()) {
            n = input.nextInt();
            a = new int[n];

            int[] bInc = new int[n];
            int[] bDec = new int[n];
            int[] s = new int[n];
            int incL = 0;
            int decL = 0;
            for (int i = 0; i < n; i++) {
                s[i] = input.nextInt();
            }
            Arrays.fill(a, Integer.MAX_VALUE);

            for (int i = 0; i < n; i++) {
                int x = s[i];
                int indx = firstTrueInc(x);
                if (a[indx] == Integer.MAX_VALUE)
                    incL++;
                bInc[i] = incL;
                a[indx] = x;

            }

            Arrays.fill(a, Integer.MAX_VALUE);

            for (int i = n - 1; i >= 0; i--) {
                int x = s[i];
                int indx = firstTrueInc(x);
                if (a[indx] == Integer.MAX_VALUE)
                    decL++;
                bDec[i] = decL;
                a[indx] = x;
            }

            int max = 1;
            for (int i = 0; i < n - 1; i++) {
                int x = bInc[i];
                int y = bDec[i];
                max = x == y ? Math.max(2 * x - 1, max) : max;
            }
            out.println(max);
            out.flush();
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