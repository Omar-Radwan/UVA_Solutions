import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer>[] g;
    static int dist[], n, m;
    static final int INF = (int) 1e9;

    static void bfs(int s, int d) {
        Arrays.fill(dist, INF);

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        dist[s] = 0;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int v : g[p]) {
                if (dist[v] == INF) {
                    q.add(v);
                    dist[v] = dist[p] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char) (d + 'A'));
        q.add(d);
        int l = dist[d];
        while (!q.isEmpty() && l > 0) {
            int p = q.poll();
            for (int v : g[p]) {
                if (dist[v] == l - 1) {
                    q.add(v);
                    l--;
                    sb.append((char) (v + 'A'));
                    break;
                }
            }
        }
        out.println(sb.reverse());

    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        input.nextLine();

        while (t-- > 0) {
            m = input.nextInt();
            n = input.nextInt();

            g = new ArrayList[26];
            for (int i = 0; i < 26; i++)
                g[i] = new ArrayList<>();
            dist = new int[26];

            for (int i = 0; i < m; i++) {
                char x = input.next().charAt(0);
                char y = input.next().charAt(0);
                g[x - 'A'].add(y - 'A');
                g[y - 'A'].add(x - 'A');
            }

            for (int i = 0; i < n; i++) {
                char x = input.next().charAt(0);
                char y = input.next().charAt(0);
                bfs(x - 'A', y - 'A');
            }

            if (t != 0) {
                input.nextLine();
                out.println();
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