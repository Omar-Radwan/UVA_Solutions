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
    static int d[][][][];
    static final int INF = (int) 1e5;
    static Info s, e;

    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, -1, 0, 1 };

    static int bfs() {
        Queue<Info> q = new LinkedList<>();
        q.add(s);
        d[s.x][s.y][s.c][s.d] = 0;

        while (!q.isEmpty()) {
            Info cur = q.poll();

            for (int dir = cur.d, cost = 0; cost <= 3; dir++, dir %= 4, cost++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nd = dir;
                int nc = (cur.c + 1) % 5;

                int newCost = d[cur.x][cur.y][cur.c][cur.d] + cost + 1;
                if (cost == 3) {
                    newCost -= 2;
                }
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || d[nx][ny][nc][nd] <= newCost || g[nx][ny] == '#')
                    continue;
                q.add(new Info(nx, ny, nc, nd));
                d[nx][ny][nc][nd] = newCost;
            }

        }

        int min = INF;

        for (int i = 0; i < 4; i++) { min = Math.min(min, d[e.x][e.y][e.c][i]); }
        return min;
    }

    public static void main(String[] args) throws IOException {

        int z = 1;
        while (true) {

            n = input.nextInt();
            m = input.nextInt();

            if (n == 0 && m == 0)
                break;
            if (z != 1)
                out.println();
            g = new char[n][];
            d = new int[n][m][5][4];

            for (int i = 0; i < n; i++) {
                g[i] = input.nextLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < 5; k++) { Arrays.fill(d[i][j][k], INF); }

                    if (g[i][j] == 'S') {
                        s = new Info(i, j, 0, 0);
                    }
                    if (g[i][j] == 'T') {
                        e = new Info(i, j, 0, -1);
                    }
                }

            }
            out.println("Case #" + z++);

            int ans = bfs();
            out.println(ans >= INF ? "destination not reachable" : "minimum time = " + ans + " sec");
        }

        out.flush();

    }

    static class Info {
        int x;
        int y;
        int c;
        int d;

        public Info(int x, int y, int c, int d) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.d = d;
        }

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