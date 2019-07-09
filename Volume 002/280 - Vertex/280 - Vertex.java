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
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        while (true) {

            int n = input.nextInt();

            if (n == 0)
                break;

            g = new ArrayList[n + 1];

            for (int i = 1; i < g.length; i++)
                g[i] = new ArrayList<>();

            while (true) {
                StringTokenizer st = new StringTokenizer(input.nextLine());

                int s = Integer.parseInt(st.nextToken());

                if (s == 0)
                    break;

                while (true) {
                    int c = Integer.parseInt(st.nextToken());

                    if (c == 0)
                        break;

                    g[s].add(c);
                }
            }

            int z = input.nextInt();
            while (z-- > 0) {
                int x = input.nextInt();
                visited = new boolean[g.length];

                Queue<Integer> q = new LinkedList<Integer>();
                q.add(x);

                while (!q.isEmpty()) {
                    int p = q.poll();

                    for (int v : g[p]) {
                        if (!visited[v]) {
                            visited[v] = true;
                            q.add(v);
                        }
                    }

                }
                StringBuilder ans = new StringBuilder();
                int cnt = 0;
                for (int i = 1; i < visited.length; i++) {
                    if (!visited[i]) {
                        ans.append(i + " ");
                        cnt++;
                    }
                }
                if (ans.length() != 0)
                    ans.delete(ans.length() - 1, ans.length());
                out.print(cnt);
                out.println(cnt != 0 ? " " + ans : "");
                out.flush();
            }

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

        boolean hasNext() throws IOException {
            return br.ready();
        }
    }

}