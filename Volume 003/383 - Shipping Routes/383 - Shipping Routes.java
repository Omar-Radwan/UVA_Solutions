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

    static ArrayList<Integer> g[];
    static int m, n, p;
    static int dist[];
    static TreeMap<String, Integer> map;
    static final int INF = (int) 1e9;

    static int bfs(int x, int y) {
        Arrays.fill(dist, INF);
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int v : g[parent]) {
                if (dist[v] == INF) {
                    dist[v] = dist[parent] + 1;
                    q.add(v);
                }
            }
        }

        return dist[y];
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        out.println("SHIPPING ROUTES OUTPUT");
        out.println();
        int z = 0;
        while (t-- > 0) {
            out.println("DATA SET  " + ++z);
            out.println();
            m = input.nextInt();
            n = input.nextInt();
            p = input.nextInt();

            g = new ArrayList[m];
            for (int i = 0; i < m; i++)
                g[i] = new ArrayList<>();

            dist = new int[m];
            map = new TreeMap<>();
            int hash = 0;

            for (int i = 0; i < m; i++) {
                String x = input.next();
                Integer f = map.get(x);
                if (f == null) {
                    map.put(x, hash++);
                }
            }

            for (int i = 0; i < n; i++) {
                int x = map.get(input.next());
                int y = map.get(input.next());
                g[x].add(y);
                g[y].add(x);
            }

            for (int i = 0; i < p; i++) {
                int size = input.nextInt();
                int x = map.get(input.next());
                int y = map.get(input.next());
                int ans = bfs(x, y);
                if (ans == INF)
                    out.println("NO SHIPMENT POSSIBLE");
                else {
                    out.println("$" + ((long) size * ans * 100));
                }
            }
            out.println();

        }
        
        out.println("END OF OUTPUT");

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