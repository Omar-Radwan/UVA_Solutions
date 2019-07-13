import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m;

    static char grid[][];

    static int dr[] = { -1, -1, 0, 0, 1, 1 };
    static int dc[] = { -1, 0, -1, 1, 0, 1 };

    static boolean floodFill(int r, int c, char color) {
        if (isInvalid(r, c, color))
            return false;

        if (color == 'w' && c == n - 1)
            return true;
        if (color == 'b' && r == n - 1)
            return true;

        grid[r][c] = 'v';

        boolean done = false;
        for (int i = 0; i < dr.length; i++)
            done |= floodFill(r + dr[i], c + dc[i], color);

        return done;
    }

    static boolean isInvalid(int r, int c, char color) {
        if (r >= n || c >= n || r < 0 || c < 0 || grid[r][c] != color)
            return true;
        return false;

    }

    public static void main(String[] args) throws IOException {
        int t = 1;

        while (true) {

            n = input.nextInt();

            if (n == 0)
                break;

            grid = new char[n][];

            for (int i = 0; i < n; i++)
                grid[i] = input.nextLine().toCharArray();

            boolean ans = false;

            for (int i = 0; i < n; i++) {
                ans = floodFill(i, 0, 'w');
                if (ans) {
                    out.println(t++ + " W");
                    break;
                }
                ans = floodFill(0, i, 'b');
                if (ans) {
                    out.println(t++ + " B");
                    break;
                }

            }

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