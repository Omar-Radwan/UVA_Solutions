import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m;
    static char grid[][];

    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };

    static final char EXPLORED1 = '#';
    static final char EXPLORED2 = 'P';

    static void markAll(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 'X') {
            return;
        }
        grid[i][j] = EXPLORED1;
        for (int x = 0; x < dx.length; x++) { markAll(i + dx[x], j + dy[x]); }

    }

    static int floodfill(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || (grid[i][j] == EXPLORED2 || grid[i][j] == '.')) {
            return 0;
        }
        int sum = 0;
        if (grid[i][j] == 'X') {
            markAll(i, j);
            sum++;
        }

        grid[i][j] = EXPLORED2;

        for (int x = 0; x < dx.length; x++) { sum += floodfill(i + dx[x], j + dy[x]); }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        int z = 0;
        while (true) {
            z++;
            m = input.nextInt();
            n = input.nextInt();

            if (n == 0) {
                break;
            }
            grid = new char[n][];

            for (int i = 0; i < n; i++) { grid[i] = input.nextLine().toCharArray(); }

            ArrayList<Integer> points = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 'X') {
                        int sum = floodfill(i, j);
                        points.add(sum);

                        // for (int k = 0 ; k < n ; k++)out.println(Arrays.toString(grid[k]));
                    }
                }
            }
            Collections.sort(points);
            out.println("Throw " + z);
            for (int i = 0; i < points.size(); i++) {
                out.print(points.get(i));
                if (i < points.size() - 1)
                    out.print(" ");
            }
            out.println();
            out.println();

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