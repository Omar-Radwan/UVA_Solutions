import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m, freq[];

    static char grid[][];

    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };

    static final char VISITED = 'V';

    static void floodFill(int r, int c, char color) {
        if (isInvalid(r, c, color))
            return;

        grid[r][c] = VISITED;

        for (int i = 0; i < dr.length; i++)
            floodFill(r + dr[i], c + dc[i], color);

    }

    static boolean isInvalid(int r, int c, char color) {
        if (r >= n || c >= m || r < 0 || c < 0 || grid[r][c] != color)
            return true;
        return false;

    }

    public static void main(String[] args) throws IOException {

        int f = input.nextInt();

        for (int q = 1; q <= f; q++) {

            n = input.nextInt();
            m = input.nextInt();

            grid = new char[n][];
            freq = new int[26];
            for (int i = 0; i < n; i++)
                grid[i] = input.nextLine().toCharArray();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] != VISITED) {
                        freq[grid[i][j] - 'a']++;
                        floodFill(i, j, grid[i][j]);
                    }
                }
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    Pair x = new Pair(freq[i], i + 'a');
                    pq.add(x);
                }
            }

            out.println("World #" + q);
            while (!pq.isEmpty()) {
                Pair x = pq.poll();
                out.println((char) x.y + ": " + x.x);
            }

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
            return o.x - x;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
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