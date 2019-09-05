import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int m;
    static int size[], p[], r[];
    static TreeMap<String, Integer> map;

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

    static int size(int x) { return size[findParent(x)]; }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {
            int m = input.nextInt();
            map = new TreeMap<>();
            int hash = 0;
            initialize((m << 1) + 1);

            for (int i = 0; i < m; i++) {
                String x = input.next();
                String y = input.next();
                Integer xm = map.get(x);
                if (xm == null) {
                    map.put(x, hash);
                    xm = hash++;

                }
                Integer ym = map.get(y);
                if (ym == null) {
                    map.put(y, hash);
                    ym = hash++;
                }
                connect(xm, ym);
                out.println(size(xm));

            }

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