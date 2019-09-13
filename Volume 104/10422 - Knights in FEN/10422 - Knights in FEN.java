import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int dx[] = { -2, -2, 2, 2, -1, 1, -1, 1 };
    static int dy[] = { -1, 1, -1, 1, -2, -2, 2, 2 };

    static TreeMap<Grid, Integer> map;

    static Grid buildGrid(Grid grid, int deltax, int deltay) {

        int newX = grid.x + deltax;
        int newY = grid.y + deltay;

        if (newX >= 5 || newX < 0 || newY >= 5 || newY < 0)
            return null;

        int oldRowMajor = grid.x * 5 + grid.y;
        int newRowMajor = newX * 5 + newY;

        char[] c = grid.s.toCharArray();

        char tmp = c[oldRowMajor];
        c[oldRowMajor] = c[newRowMajor];
        c[newRowMajor] = tmp;

        Grid ret = new Grid(new String(c), newX, newY);
        return ret;

    }

    static void bfs() {
        map = new TreeMap<>();
        String s = "111110111100 110000100000";
        Grid source = new Grid(s, 2, 2);
        map.put(source, 0);
        Queue<Grid> q = new LinkedList<Grid>();
        q.add(source);
        while (!q.isEmpty()) {
            Grid cur = q.poll();
            int dist = map.get(cur);
            for (int i = 0; i < dx.length; i++) {
                Grid newGrid = buildGrid(cur, dx[i], dy[i]);

                if ((newGrid == null) || dist >= 10)
                    continue;

                Integer newDist = map.get(newGrid);
                if (newDist != null && 1 + dist >= newDist) {
                    continue;
                }

                map.put(newGrid, dist + 1);
                q.add(newGrid);

            }

        }
    }

    public static void main(String args[]) throws NumberFormatException, IOException {
        bfs();
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {

            StringBuilder cur = new StringBuilder();

            int x = 0, y = 0;
            for (int j = 0; j < 5; j++) {
                String s = input.nextLine();
                cur.append(s);
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == ' ') {
                        x = j;
                        y = k;
                    }
                }

            }

            Grid g = new Grid(cur.toString(), x, y);

            Integer ans = map.get(g);
            if (ans == null) {
                out.println("Unsolvable in less than 11 move(s).");
            } else {
                out.println("Solvable in " + ans + " move(s).");
            }

        }
        out.flush();

    }

    static class Grid implements Comparable<Grid> {
        String s;
        int x, y;

        public Grid(String s, int x, int y) {
            this.s = s;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Grid o) { return (this.s).compareTo(o.s); }

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