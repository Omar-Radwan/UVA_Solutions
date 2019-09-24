import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (true) {
            int n = input.nextInt();
            boolean d[][] = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = input.nextInt();
                    d[i][j] = x == 1 ? true : false;
                }
            }

            ArrayList<Triple> ans = new ArrayList<Triple>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (d[i][j] && d[j][k] && d[k][i]) {
                            ans.add(new Triple(i + 1, j + 1, k + 1));
                        } else if (d[i][k] && d[k][j] && d[j][i]) {
                            ans.add(new Triple(k + 1, j + 1, i + 1));
                        }

                        else {
                            if (!(d[i][k] || d[k][i] || d[j][k] || d[k][j] || d[i][j] || d[j][i])) {
                                ans.add(new Triple(i + 1, j + 1, k + 1));
                            }
                        }

                    }
                }
            }

            Collections.sort(ans);
            out.println(ans.size());
            for (Triple s : ans) { out.println(s.x + " " + s.y + " " + s.z); }
            if (!input.hasNext())
                break;
        }
        out.flush();
    }

    static class Triple implements Comparable<Triple> {
        int x;
        int y;
        int z;

        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Triple o) {
            if (x == o.x && y == o.y)
                return z - o.z;
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + x + ", " + y + ", " + z + ")"; }
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
