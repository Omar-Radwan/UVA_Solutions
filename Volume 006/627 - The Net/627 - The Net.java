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

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int INF = (int) 1e9;

    static ArrayList<Integer>[] allocateArrayList(int n) {
        ArrayList<Integer> a[] = new ArrayList[n];
        for (int i = 0; i < n; i++) { a[i] = new ArrayList<>(); }
        return a;
    }

    static ArrayList<Integer> g[];
    static int n, dist[][], parent[][];

    static void bfs() {

        dist = new int[n][n];
        parent = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(parent[i], INF);
        }

        for (int i = 0; i < n; i++) {

            Queue<Integer> q = new LinkedList<Integer>();
            q.add(i);
            dist[i][i] = 0;
            parent[i][i] = -1;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int v : g[cur]) {
                    if (1 + dist[i][cur] < dist[i][v] || (1 + dist[i][cur] == dist[i][v] && cur < parent[i][v])) {
                        q.add(v);
                        dist[i][v] = dist[i][cur] + 1;
                        parent[i][v] = cur;
                    }

                }

            }

        }

    }

    public static void main(String args[]) throws NumberFormatException, IOException {

        while (true) {
            n = input.nextInt();
            g = allocateArrayList(n);

            for (int i = 0; i < n; i++) {
                String str = input.nextLine();
                StringTokenizer st = new StringTokenizer(str, ", -");
                int cur = Integer.parseInt(st.nextToken()) - 1;

                while (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken()) - 1;
                    g[cur].add(x);

                }
                out.flush();
            }

            bfs();
            out.println("-----");
            int m = input.nextInt();

            while (m-- > 0) {
                int l = input.nextInt() - 1;
                int r = input.nextInt() - 1;

                if (dist[l][r] == INF) {
                    out.println("connection impossible");
                }

                else {
                    Stack<Integer> ans = new Stack<>();

                    int cur = r;
                    while (cur != -1) {
                        ans.add(cur + 1);

                        cur = parent[l][cur];
                    }
                    while (!ans.isEmpty()) {
                        out.print(ans.pop());
                        if (ans.size() != 0)
                            out.print(" ");
                        else
                            out.println();

                    }

                }

            }

            if (!input.hasNext())
                break;
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