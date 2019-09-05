import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m;
    static char g[][];
    static Pair J;
    static int fireDist[][], joeyDist[][];
    static final int INF = (int) 1e9;
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { -1, 1, 0, 0 };

    static void bfsFire() {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 'F') {
                    q.add(new Pair(i, j));
                    fireDist[i][j] = 0;

                }
            }

        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int z = 0; z < dx.length; z++) {
                int nx = cur.x + dx[z];
                int ny = cur.y + dy[z];
                int ndist = fireDist[cur.x][cur.y] + 1;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || g[nx][ny] == '#' || fireDist[nx][ny] <= ndist)
                    continue;
                q.add(new Pair(nx, ny));
                fireDist[nx][ny] = ndist;
            }

        }

    }

    static int bfs() {
        bfsFire();

        Queue<Pair> q = new LinkedList<>();
        q.add(J);
        joeyDist[J.x][J.y] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ndist = joeyDist[cur.x][cur.y] + 1;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || g[nx][ny] == '#' || ndist >= fireDist[nx][ny]
                        || joeyDist[nx][ny] <= ndist)
                    continue;

                q.add(new Pair(nx, ny));
                joeyDist[nx][ny] = ndist;
            }

        }
        int min = INF;

        for (int i = 0; i < m; i++) {
            min = Math.min(min, joeyDist[0][i]);
            min = Math.min(min, joeyDist[n - 1][i]);
        }

        for (int i = 1; i < n - 1; i++) {
            min = Math.min(min, joeyDist[i][0]);
            min = Math.min(min, joeyDist[i][m - 1]);
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();

        while (t-- > 0) {
            n = input.nextInt();
            m = input.nextInt();

            g = new char[n][];
            joeyDist = new int[n][m];
            fireDist = new int[n][m];

            for (int i = 0; i < n; i++) {
                g[i] = input.nextLine().toCharArray();

                for (int j = 0; j < m; j++) {
                    if (g[i][j] == 'J') {
                        J = new Pair(i, j);
                    }

                }

                Arrays.fill(joeyDist[i], INF);
                Arrays.fill(fireDist[i], INF);

            }
            int ans = bfs();
            out.println(ans == INF ? "IMPOSSIBLE" : ans + 1);
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