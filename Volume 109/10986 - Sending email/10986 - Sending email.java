import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int N, n, m, s, t;
    static int dist[];
    static ArrayList<Pair>[] g;
    static PriorityQueue<Pair> pq;
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {

        N = input.nextInt();
        for (int z = 1; z <= N; z++) {

            n = input.nextInt();
            m = input.nextInt();
            s = input.nextInt();
            t = input.nextInt();

            dist = new int[n];
            Arrays.fill(dist, INF);
            pq = new PriorityQueue<>();
            g = new ArrayList[n];
            for (int i = 0; i < n; i++) { g[i] = new ArrayList<>(); }

            while (m-- > 0) {
                int x = input.nextInt();
                int y = input.nextInt();
                int w = input.nextInt();
                g[x].add(new Pair(w, y));
                g[y].add(new Pair(w, x));
            }

            pq.add(new Pair(0, s));
            dist[s] = 0;

            while (!pq.isEmpty()) {
                Pair cur = pq.poll();
                int p = cur.y;
                int pdist = cur.x;
                if (pdist > dist[p])
                    continue;

                for (Pair v : g[p]) {
                    int nd = pdist + v.x;
                    if (nd < dist[v.y]) {
                        dist[v.y] = nd;
                        pq.add(new Pair(nd, v.y));
                    }
                }

            }

            out.println("Case #" + z + ": " + (dist[t] == INF ? "unreachable" : dist[t]));

        }

        out.flush();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(Pair o) {
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + this.x + "," + this.y + ")"; }
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