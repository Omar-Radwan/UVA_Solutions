import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m;
    static ArrayList<Integer> g[];
    static boolean visited[];
    static Stack<Integer> s;

    static void dfs(int p) {
        visited[p] = true;
        for (int v : g[p])
            if (!visited[v])
                dfs(v);
        s.push(p);
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            s = new Stack<>();
            n = input.nextInt();
            m = input.nextInt();
            if (n == 0)
                break;

            g = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i < g.length; i++)
                g[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                g[x].add(y);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            while (true) {
                out.print(s.pop());
                if (s.isEmpty())
                    break;
                out.print(" ");
            }
            out.println();

        }

        out.flush();

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

        boolean hasNext() throws IOException {
            return br.ready();
        }
    }

}