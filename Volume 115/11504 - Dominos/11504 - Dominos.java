import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static ArrayList<Integer> topo;
    static ArrayList<Integer>[] g;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < g[node].size(); i++) {
            int u = g[node].get(i);
            if (!visited[u]) {
                dfs(u);
            }
        }
        topo.add(node);
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            g = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            topo = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                g[input.nextInt()].add(input.nextInt());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i])
                    dfs(i);
            }

            Integer[] tSort = new Integer[n];
            topo.toArray(tSort);

            visited = new boolean[n + 1];
            int count = 0;

            for (int i = topo.size() - 1; i >= 0; i--) {
                int u = topo.get(i);
                if (!visited[u]) {
                    dfs(u);
                    count++;
                }
            }
            System.out.println(count);

        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }
    }

}
