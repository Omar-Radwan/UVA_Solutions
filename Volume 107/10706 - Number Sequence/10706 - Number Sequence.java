import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MAXN = (int) (1e7);
    static long s[];
    static int n;

    static int lastTrue(int x) {

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            boolean p = s[mid] < x;
            if (p)
                l = mid;

            else
                r = mid - 1;

        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        int t[] = new int[MAXN];
        s = new long[MAXN];
        int i = 1;

        for (; true; i++) {
            t[i] = (int) (t[i - 1] + (Math.log10(i)) + 1);
            s[i] = t[i] + s[i - 1];
            if (s[i] >= Integer.MAX_VALUE)
                break;
        }

        n = ++i;
        int q = input.nextInt();

        while (q-- > 0) {
            int x = input.nextInt();
            int l = lastTrue(x);
            x -= s[l];

            StringBuilder seq = new StringBuilder();

            for (int j = 1; seq.length() < x; j++) {
                seq.append(j);
            }
            out.println(seq.charAt(x - 1));

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