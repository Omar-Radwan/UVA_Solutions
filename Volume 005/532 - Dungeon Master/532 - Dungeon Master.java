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
    static int L, R, C;
    static Triple s, e;
    static char g[][][];
    static int dist[][][];
    static final int INF = (int) 1e9;

    static int dx[] = { 0, 0, 0, 0, -1, 1 };
    static int dy[] = { 0, 0, -1, 1, 0, 0 };
    static int dz[] = { -1, 1, 0, 0, 0, 0 };

    static int bfs() {

        Queue<Triple> q = new LinkedList<Triple>();
        q.add(new Triple(s.x, s.y, s.z));
        dist[s.x][s.y][s.z] = 0;

        while (!q.isEmpty()) {
            Triple cr = q.poll();
            int d = dist[cr.x][cr.y][cr.z];

            for (int i = 0; i < dx.length; i++) {
                int nx = cr.x + dx[i];
                int ny = cr.y + dy[i];
                int nz = cr.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C || g[nx][ny][nz] == '#'
                        || dist[nx][ny][nz] <= d + 1)
                    continue;
                q.add(new Triple(nx, ny, nz));
                dist[nx][ny][nz] = d + 1;

            }
        }
        return dist[e.x][e.y][e.z];
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            L = input.nextInt();
            R = input.nextInt();
            C = input.nextInt();
            if (L == 0)
                break;

            g = new char[L][R][];
            dist = new int[L][R][C];

            for (int i = 0; i < L; i++) {

                for (int j = 0; j < R; j++) {
                    g[i][j] = input.nextLine().toCharArray();
                    Arrays.fill(dist[i][j], INF);
                    for (int k = 0; k < C; k++) {

                        if (g[i][j][k] == 'S')
                            s = new Triple(i, j, k);

                        if (g[i][j][k] == 'E') {
                            e = new Triple(i, j, k);

                        }

                    }
                }

                input.nextLine();
            }

            int ans = bfs();

            out.println(ans == INF ? "Trapped!" : "Escaped in " + ans + " minute(s).");

        }
        out.flush();

    }

    static class Triple implements Comparable<Triple> {
        int x;
        int y;
        int z;

        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Triple o) {
            if (x == o.x && y == o.y)
                return z - o.z;
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + x + ", " + y + ", " + z + ")"; }
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