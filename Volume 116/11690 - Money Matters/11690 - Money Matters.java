import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int p[], rank[], setSize[], money[];

    static void initialize(int n) {
        p = new int[n];
        setSize = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            setSize[i] = 1;
        }
        rank = new int[n];
    }

    static void connect(int x, int y) {
        if (!isSameSet(x, y)) {
            int i = parent(x);
            int j = parent(y);

            if (rank[i] > rank[j]) {
                p[j] = i;
                setSize[i] += setSize[j];
                money[i] += money[j];
            } else {
                p[i] = j;
                setSize[j] += setSize[i];
                money[j] += money[i];
                if (rank[i] == rank[j]) {
                    rank[j]++;
                }
            }

        }
    }

    static boolean isSameSet(int x, int y) { return parent(x) == parent(y); }

    static int parent(int x) { return p[x] == x ? x : parent(p[x]); }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {

            int n = input.nextInt();
            int m = input.nextInt();

            money = new int[n];
            initialize(n);

            for (int i = 0; i < n; i++) { money[i] = input.nextInt(); }

            for (int i = 0; i < m; i++) { connect(input.nextInt(), input.nextInt()); }

            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                if (money[parent(i)] != 0) {
                    isPossible = false;
                    break;
                }
            }

            out.println(isPossible ? "POSSIBLE" : "IMPOSSIBLE");

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