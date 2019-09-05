import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    static int[][] state;
    static int[][] count;

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        for (int z = 1; z <= t; z++) {
            int r = input.nextInt();
            int c = input.nextInt();
            state = new int[r][c];
            count = new int[r][c];

            int m = input.nextInt();
            int n = input.nextInt();

            int w = input.nextInt();
            while (w-- > 0) {
                int x = input.nextInt();
                int y = input.nextInt();
                state[x][y] = -1;
            }

            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(0, 0));
            state[0][0] = 1;

            int dx[] = { n, n, -n, -n, m, m, -m, -m };
            int dy[] = { m, -m, m, -m, n, -n, n, -n };

            int e = 0;
            int o = 0;
            while (!q.isEmpty()) {
                Pair cur = q.poll();
                TreeSet<Pair> visited = new TreeSet<>();
                for (int i = 0; i < dx.length; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (visited.contains(new Pair(nx, ny)))
                        continue;

                    visited.add(new Pair(nx, ny));
                    if (nx < r && nx >= 0 && ny < c && ny >= 0) {
                        if (state[nx][ny] != -1)
                            count[nx][ny]++;

                        if (state[nx][ny] == 0) {
                            q.add(new Pair(nx, ny));
                            state[nx][ny] = 1;
                        }

                    }

                }

            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (state[i][j] == 1) {
                        if (count[i][j] % 2 == 0) {
                            e++;
                        } else {
                            o++;
                        }
                    }
                }
            }
            out.println("Case " + z + ": " + e + " " + o);
        }

        out.flush();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(Pair o) {
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + this.x + "," + this.y + ")"; }
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