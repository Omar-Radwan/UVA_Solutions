import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m;

    static char grid[][], c1 = '@', c2 = '*';

    static int dr[] = { 0, 0, 1, 1, 1, -1, -1, -1 };
    static int dc[] = { 1, -1, 1, 0, -1, 1, 0, -1 };

    static void floodFill(int r, int c) {
        if (isInvalid(r, c))
            return;
        grid[r][c] = c2;

        for (int i = 0; i < dr.length; i++)
            floodFill(r + dr[i], c + dc[i]);

    }

    static boolean isInvalid(int r, int c) {
        if (r >= n || c >= m || r < 0 || c < 0 || grid[r][c] == c2)
            return true;
        return false;

    }

    public static void main(String[] args) throws IOException {

        while (true) {

            n = input.nextInt();
            m = input.nextInt();
            if (n == 0)
                break;
            grid = new char[n][];

            for (int i = 0; i < n; i++)
                grid[i] = input.nextLine().toCharArray();
            int x = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == c1) {
                        floodFill(i, j);
                        x++;
                    }
                }
            }
            out.println(x);

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