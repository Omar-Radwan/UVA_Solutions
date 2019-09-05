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
    static int dist[], e;
    static final int INF = (int) 1e9;

    static void bfs(int s) {
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
        int freq[] = new int[e + 5];
        for (int i = 0; i < e; i++) {
            if (dist[i] == INF)
                continue;
            freq[dist[i]]++;
        }
        int max = 0;
        int firstocc = -1;
        for (int i = 1; i < e; i++) {
            if (freq[i] > max) {
                max = freq[i];
                firstocc = i;
            }
        }

        if (max == 0) {
            out.println(0);
        } else {
            out.println(max + " " + firstocc);
        }

    }

    public static void main(String[] args) throws IOException {

        e = input.nextInt();

        g = new ArrayList[e];
        for (int i = 0; i < e; i++)
            g[i] = new ArrayList<>();

        dist = new int[e];

        for (int i = 0; i < e; i++) {
            int n = input.nextInt();
            for (int j = 0; j < n; j++) { g[i].add(input.nextInt()); }
        }

        int t = input.nextInt();

        while (t-- > 0) { bfs(input.nextInt()); }

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