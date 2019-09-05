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
    static ArrayList<Integer> g[];
    static int color[];

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;

            g = new ArrayList[n + 1];
            color = new int[n + 1];

            for (int i = 1; i < g.length; i++)
                g[i] = new ArrayList<>();

            while (true) {
                int x = input.nextInt();
                int y = input.nextInt();
                if (x == 0)
                    break;
                g[x].add(y);
                g[y].add(x);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            color[1] = 1;
            boolean isBi = true;

            while (!q.isEmpty()) {
                int p = q.poll();
                int c = (color[p] % 2) + 1;
                for (int v : g[p]) {
                    if (color[v] != c && color[v] != 0) {
                        isBi = false;
                        break;
                    } else if (color[v] == 0) {
                        color[v] = c;
                        q.add(v);
                    }
                }
            }
            out.println(isBi ? "YES" : "NO");
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