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
    static int m;
    static char c[][];
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };

    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        int dist[][] = new int[m][m];
        for (int i = 0; i < m; i++) { Arrays.fill(dist[i], Integer.MAX_VALUE); }

        dist[x][y] = 0;
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int ndist = dist[cur.x][cur.y] + 1;

                if (ny >= m || ny < 0 || nx >= m || nx < 0 || dist[nx][ny] <= ndist)
                    continue;

                dist[nx][ny] = ndist;
                q.add(new Pair(nx, ny));
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (c[i][j] == '3') {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }

        return min;

    }

    public static void main(String args[]) throws IOException {

        while (true) {
            m = input.nextInt();

            c = new char[m][];

            for (int i = 0; i < m; i++) { c[i] = input.nextLine().toCharArray(); }

            int max = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (c[i][j] == '1') {
                        max = Math.max(max, bfs(i, j));
                    }

                }
            }

            out.println(max);
            if (!input.hasNext())
                break;

        }
        out.flush();
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
