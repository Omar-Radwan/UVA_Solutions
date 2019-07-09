import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static char[][] grid;
    static int n, m, dist[][];
    static boolean v[][];

    static int i(int o) {
        if (o == 'N')
            return 0;
        if (o == 'E')
            return 1;
        if (o == 'W')
            return 2;
        return 3;
    }

    // N E W S
    static int dr[] = { -1, 0, 0, 1 };
    static int dc[] = { 0, 1, -1, 0 };

    static boolean isOut(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m)
            return true;
        return false;
    }

    static void move(int r, int c, int steps) {

        if (isOut(r, c)) {
            out.println(steps + " step(s) to exit");
            return;
        }
        if (v[r][c]) {
            int beforeLoop = dist[r][c];
            int afterLoop = steps - dist[r][c];
            out.println(beforeLoop + " step(s) before a loop of " + afterLoop + " step(s)");
            return;
        } else {
            v[r][c] = true;
            dist[r][c] = steps;

            int d = i(grid[r][c]);
            int nr = r + dr[d];
            int nc = c + dc[d];
            move(nr, nc, steps + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            n = input.nextInt();
            m = input.nextInt();
            int sC = input.nextInt() - 1;
            if (sC == -1)
                break;
            int sR = 0;

            grid = new char[n][m];
            v = new boolean[n][m];
            dist = new int[n][m];

            for (int i = 0; i < n; i++) {
                grid[i] = input.nextLine().toCharArray();

            }
            move(sR, sC, 0);
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