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

    static int r, c, dist[][];
    static char[][] grid;

    static int dr[] = { 1, -1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };

    static final char BOMB = 'X';
    static final int INF = (int) 1e9;

    static void bfs(int sr, int sc, int er, int ec) {

        for (int i = 0; i < r; i++) { Arrays.fill(dist[i], INF); }

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sr, sc));
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            for (int i = 0; i < dr.length; i++) {
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];
                if ((nr >= 0 && nr < r && nc >= 0 && nc < c) && (dist[nr][nc] == INF) && (grid[nr][nc] != 'X')) {
                    q.add(new Pair(nr, nc));
                    dist[nr][nc] = dist[p.x][p.y] + 1;
                }
            }

        }

        out.println(dist[er][ec]);

    }

    public static void main(String[] args) throws IOException {

        while (true) {
            r = input.nextInt();
            c = input.nextInt();
            if (r == 0 && c == 0)
                break;

            dist = new int[r][c];
            grid = new char[r][c];

            int n = input.nextInt();
            while (n-- > 0) {
                int x = input.nextInt();
                int m = input.nextInt();
                while (m-- > 0) {
                    int y = input.nextInt();
                    grid[x][y] = BOMB;
                }
            }

            int sr = input.nextInt();
            int sc = input.nextInt();

            int er = input.nextInt();
            int ec = input.nextInt();

            bfs(sr, sc, er, ec);

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