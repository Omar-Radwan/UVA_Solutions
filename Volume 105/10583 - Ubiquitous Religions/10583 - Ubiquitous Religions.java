import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int p[];
    static int r[];
    static int count;

    static void initialize(int n) {
        p = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;
        count = n;
    }

    static void connect(int x, int y) {
        if (!query(x, y)) {
            count--;
            int i = findset(x);
            int j = findset(y);
            if (r[i] > r[j]) {
                p[j] = i;
            } else {
                p[i] = j;
                if (r[i] == r[j]) {
                    r[j]++;
                }
            }
        }
    }

    static boolean query(int x, int y) { return findset(x) == findset(y); }

    static int findset(int x) { return p[x] = p[x] == x ? x : findset(p[x]); }

    public static void main(String[] args) throws IOException {

        int z = 0;
        while (true) {
            int n = input.nextInt();
            int m = input.nextInt();
            if (n == 0 && m == 0)
                break;
            initialize(n);

            for (int i = 0; i < m; i++) {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                connect(x, y);
            }
            
            out.println("Case " + (++z) + ": " + count);
        
            if (!input.hasNext()) break;
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