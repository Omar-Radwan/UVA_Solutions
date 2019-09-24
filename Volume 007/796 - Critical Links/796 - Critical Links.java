import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static ArrayList<Integer>[] g;

    static int dfsNum[], dfsLow[], parent[], timer;
    static final int UNVISITED = 0;

    static ArrayList<Pair> bridges;

    static ArrayList<Integer>[] allocateArrayList(int n) {
        ArrayList<Integer> a[] = new ArrayList[n];
        for (int i = 0; i < n; i++) { a[i] = new ArrayList<>(); }
        return a;
    }

    static void tarjan(int u) {
        dfsNum[u] = dfsLow[u] = timer++;

        for (int v : g[u]) {
            if (dfsNum[v] == UNVISITED) {
                parent[v] = u;

                tarjan(v);

                if (dfsLow[v] > dfsNum[u]) {
                    bridges.add(new Pair(Math.min(u, v), Math.max(u, v)));
                }

                dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);
            }

            else if (parent[u] != v) {
                dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        while (true) {

            int n = input.nextInt();
            g = allocateArrayList(n);

            while (true) {
                String s = input.nextLine();
                if (s == null || s.isEmpty())
                    break;
                StringTokenizer st = new StringTokenizer(s, " ()");

                int cur = Integer.parseInt(st.nextToken());
                st.nextToken();
                while (st.hasMoreTokens()) {
                    int next = Integer.parseInt(st.nextToken());
                    g[cur].add(next);
                }
            }

            timer = 1;
            dfsNum = new int[n];
            dfsLow = new int[n];
            parent = new int[n];
            Arrays.fill(parent, -1);
            bridges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (dfsNum[i] == UNVISITED) {
                    tarjan(i);
                }
            }
            out.println(bridges.size() + " critical links");

            Collections.sort(bridges);

            for (Pair cur : bridges) { out.println(cur.x + " - " + cur.y); }
            out.println();

            if (!input.hasNext()) {
                break;
            }

        }

        out.flush();
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override

        public int compareTo(Pair o) {
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
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