import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        for (int z = 1; z <= t; z++) {
            input.nextLine();
            int n = input.nextInt();
            int m = input.nextInt();

            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++) { g[i] = new ArrayList<>(); }

            int[] value = new int[n];

            for (int i = 0; i < n; i++)
                value[i] = input.nextInt();

            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                g[x].add(y);
            }

            int cur = 0;
            int ans = 0;

            while (true) {
                int max = 0;
                int maxIndx = -1;

                ans += value[cur];

                for (int v : g[cur]) {
                    if (value[v] > max) {
                        max = value[v];
                        maxIndx = v;
                    }
                }
                if (maxIndx == -1) {
                    break;
                }

                cur = maxIndx;
            }
            out.println("Case " + z + ": " + ans + " " + cur);

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