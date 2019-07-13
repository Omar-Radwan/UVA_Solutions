import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer>[] g;
    static int color[];

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;

            int m = input.nextInt();
            g = new ArrayList[n];
            color = new int[n];

            for (int i = 0; i < g.length; i++)
                g[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                g[x].add(y);
                g[y].add(x);
            }

            Queue<Integer> q = new LinkedList<Integer>();
            q.add(0);
            color[0] = 1;
            boolean isBi = true;

            while (!q.isEmpty()) {
                int p = q.poll();
                int c = Math.abs(color[p] - 1);
                for (int v : g[p]) {
                    if (color[v] == 0) {
                        color[v] = c;
                        q.add(v);
                    } else if (color[v] == color[p]) {
                        isBi = false;
                        break;
                    }
                }
            }
            out.println(isBi ? "BICOLORABLE." : "NOT BICOLORABLE.");

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