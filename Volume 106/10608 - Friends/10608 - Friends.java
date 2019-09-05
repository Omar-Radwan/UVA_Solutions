import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m;
    static int size[], p[], r[];

    static void initialize(int n) {
        p = new int[n];
        r = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    static void connect(int x, int y) {

        if (!query(x, y)) {
            int i = findParent(x);
            int j = findParent(y);

            if (r[i] > r[j]) {
                p[j] = i;
                size[i] += size[j];
            } else {
                p[i] = j;
                size[j] += size[i];
                if (r[j] == r[i]) {
                    r[j]++;
                }
            }

        }
    }

    static boolean query(int x, int y) { return findParent(x) == findParent(y); }

    static int findParent(int x) { return p[x] == x ? x : findParent(p[x]); }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            initialize(n);

            for (int i = 0; i < m; i++) {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                connect(x, y);
            }
            int max = 1;

            for (int i = 0; i < n; i++) { max = Math.max(max, size[i]); }
            out.println(max);
        }
        out.flush();
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