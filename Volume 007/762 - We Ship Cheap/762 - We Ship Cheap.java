import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer>[] g;
    static int dist[], n, m;
    static final int INF = (int) 1e9;
    static TreeMap<String, Integer> map;
    static String[] iToS;

    static void bfs(int x, int y) {
        Arrays.fill(dist, INF);

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int v : g[p]) {
                if (dist[v] == INF) {
                    q.add(v);
                    dist[v] = dist[p] + 1;
                }
            }
        }

        if (dist[y] == INF) {
            out.println("No route");
        } else {
            Stack<String> stack = new Stack<>();
            q.add(y);
            int d = dist[y];
            while (!q.isEmpty() && d > 0) {
                int p = q.poll();
                for (int v : g[p]) {
                    if (dist[v] == d - 1) {
                        q.add(v);
                        stack.add(iToS[v] + " " + iToS[p]);
                        d--;
                        break;
                    }
                }
            }
            while (!stack.isEmpty()) { out.println(stack.pop()); }
        }

    }

    public static void main(String[] args) throws IOException {

        while (true) {
            map = new TreeMap<>();
            m = input.nextInt();
            n = (m << 1) + 1;
            int hash = 0;
            g = new ArrayList[n];
            for (int i = 0; i < n; i++)
                g[i] = new ArrayList<>();
            dist = new int[n];
            iToS = new String[n];
            while (m-- > 0) {
                String x = input.next();
                String y = input.next();

                Integer xm = map.get(x);
                Integer ym = map.get(y);
                if (xm == null) {
                    xm = ++hash;
                    map.put(x, xm);
                    iToS[xm] = x;
                }

                if (ym == null) {
                    ym = ++hash;
                    map.put(y, ym);
                    iToS[ym] = y;
                }

                g[ym].add(xm);
                g[xm].add(ym);

            }

            String x = input.next();
            String y = input.next();

            if (!map.containsKey(x) || !map.containsKey(y)) {
                out.println("No route");
            } else {
                bfs(map.get(x), map.get(y));
            }

            if (!input.hasNext())
                break;

            input.nextLine();
            out.println();
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