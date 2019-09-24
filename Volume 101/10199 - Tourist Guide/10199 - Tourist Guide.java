import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static ArrayList<Integer>[] g;
    static TreeMap<String, Integer> map;
    static String stoi[];
    static int n, hash;

    static ArrayList<Integer>[] allocateArrayList(int n) {
        ArrayList<Integer> a[] = new ArrayList[n];
        for (int i = 0; i < n; i++) { a[i] = new ArrayList<>(); }
        return a;
    }

    static final int UNVISITED = 0;
    static int dfsLow[], dfsNum[], parent[], timer, root, rootChildren;
    static boolean artPoints[];

    static void tarjan(int u) {
        dfsLow[u] = dfsNum[u] = timer++;

        for (int v : g[u]) {

            if (dfsNum[v] == UNVISITED) {
                parent[v] = u;

                if (u == root)
                    rootChildren++;

                tarjan(v);

                if (dfsLow[v] >= dfsNum[u])
                    artPoints[u] = true;

                dfsLow[u] = Math.min(dfsLow[u], dfsLow[v]);

            }

            else if (parent[u] != v)
                dfsLow[u] = Math.min(dfsLow[u], dfsNum[v]);

        }

    }

    public static void main(String[] args) throws IOException {

        int z = 1;
        while (true) {

            n = input.nextInt();
            if (n == 0)
                break;
            if (z != 1)
                out.println();

            g = allocateArrayList(n);

            map = new TreeMap();
            stoi = new String[n];
            hash = 0;

            for (int i = 0; i < n; i++) {
                String s = input.nextLine();
                map.put(s, hash);
                stoi[hash++] = s;
            }

            int r = input.nextInt();

            while (r-- > 0) {
                String x = input.next();
                String y = input.next();

                int xi = map.get(x);
                int yi = map.get(y);

                g[xi].add(yi);
                g[yi].add(xi);

            }

            dfsLow = new int[n];
            dfsNum = new int[n];
            parent = new int[n];
            Arrays.fill(parent, -1);
            artPoints = new boolean[n];
            timer = 1;
            for (int i = 0; i < n; i++) {
                if (dfsNum[i] == UNVISITED) {
                    rootChildren = 0;
                    root = i;
                    tarjan(i);
                    artPoints[i] = rootChildren > 1;
                }
            }

            PriorityQueue<String> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                if (artPoints[i]) {
                    pq.add(stoi[i]);
                }
            }

            out.println("City map #" + z + ": " + pq.size() + " camera(s) found");
            while (!pq.isEmpty()) { out.println(pq.poll()); }
            z++;
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