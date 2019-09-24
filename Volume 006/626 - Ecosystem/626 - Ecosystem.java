import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (true) {
            int n = input.nextInt();

            boolean adj[][] = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) { adj[i][j] = input.nextInt() == 1 ? true : false; }
            }

            PriorityQueue<Triple> pq = new PriorityQueue<>();

            int total = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = i + 1; k < n; k++) {
                        if (j == k)
                            continue;

                        if (adj[i][j] && adj[j][k] && adj[k][i]) {
                            total++;
                            if (j < k) {
                                pq.add(new Triple(i + 1, j + 1, k + 1));
                            } else {
                                pq.add(new Triple(j + 1, k + 1, i + 1));
                            }
                        }
                    }
                }
            }

            while (!pq.isEmpty()) {
                Triple cur = pq.poll();
                out.println(cur.x + " " + cur.y + " " + cur.z);
            }
            out.println("total:" + total);
            out.println();
            if (!input.hasNext())
                break;
        }

        out.flush();
    }

    static class Triple implements Comparable<Triple> {
        int x, y, z;

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
