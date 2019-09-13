import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static ArrayList<Integer>[] g;

    static int dfsNum[], dfsLow[], parent[], timer = 1, dfsRoot, rootChildren;
    static final int UNVISITED = 0;

    static boolean articulationPoint[];

    static ArrayList<Integer>[] allocateArrayList(int n) {
        ArrayList<Integer> a[] = new ArrayList[n];
        for (int i = 0; i < n; i++) { a[i] = new ArrayList<>(); }
        return a;
    }

    static void doTarjan(int u) {
        dfsNum[u] = dfsLow[u] = timer++;

        for (int v : g[u]) {

            if (dfsNum[v] == UNVISITED) {
                parent[v] = u;
                if (dfsRoot == u)
                    rootChildren++;

                doTarjan(v);

                if (dfsLow[v] >= dfsNum[u])
                    articulationPoint[u] = true;

                dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);

            } else if (parent[u] != v)
                dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);

        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            int n = input.nextInt();

            if (n == 0)
                break;

            g = allocateArrayList(n);

            while (true) {
                StringTokenizer st = new StringTokenizer(input.nextLine());

                int cur = Integer.parseInt(st.nextToken()) - 1;

                if (cur < 0)
                    break;

                while (st.hasMoreTokens()) {
                    int next = Integer.parseInt(st.nextToken()) - 1;
                    g[cur].add(next);
                    g[next].add(cur);
                }

            }

            dfsNum = new int[n];
            dfsLow = new int[n];
            parent = new int[n];
            Arrays.fill(parent, -1);
            articulationPoint = new boolean[n];
            dfsRoot = 0;
            rootChildren = 0;

            doTarjan(0);

            articulationPoint[0] = rootChildren > 1;

            int sum = 0;

            for (int i = 0; i < n; i++) { sum += articulationPoint[i] ? 1 : 0; }

            out.println(sum);

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