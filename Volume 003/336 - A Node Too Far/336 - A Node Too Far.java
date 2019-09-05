import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer>[] g;
    static int dist[], n = 31, m;
    static final int INF = (int) 1e9;
    static TreeMap<Integer, Integer> map;

    static int bfs(int s, int ttl) {

        Queue<Integer> q = new LinkedList<Integer>();
        Integer indx = map.get(s);

        if (indx == null) {
            return dist.length - 1;
        }

        q.add(indx);
        dist[indx] = 0;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int v : g[p]) {
                if (dist[v] == INF) {
                    q.add(v);
                    dist[v] = Math.min(dist[v], dist[p] + 1);
                }
            }
        }

        int sum = 0;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > ttl) {
                sum++;
            }
        }
        return sum;

    }

    public static void main(String[] args) throws IOException {
        int f = 1;

        while (true) {

            int cnt = 0;
            m = input.nextInt();

            if (m == 0)
                break;

            map = new TreeMap<>();
            g = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) { g[i] = new ArrayList<>(); }

            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                int y = input.nextInt();

                Integer xm = map.get(x);

                if (xm == null) {
                    xm = ++cnt;
                    map.put(x, xm);
                }

                Integer ym = map.get(y);
                if (ym == null) {
                    ym = ++cnt;
                    map.put(y, ym);
                }

                g[xm].add(ym);
                g[ym].add(xm);

            }

            while (true) {
                dist = new int[cnt + 1];
                Arrays.fill(dist, INF);

                int s = input.nextInt();
                int ttl = input.nextInt();

                if (s == 0 && ttl == 0)
                    break;

                else {

                    int ans = bfs(s, ttl);
                    out.println("Case " + f + ": " + ans + " nodes not reachable from node " + s + " with TTL = " + ttl
                            + ".");
                    f++;
                }
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