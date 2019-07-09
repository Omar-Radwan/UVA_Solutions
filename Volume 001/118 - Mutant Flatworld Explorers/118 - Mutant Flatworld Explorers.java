import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int rx, ry, lx, ly, o;
    static boolean grid[][];
    static char[] inst;

    // N E W S
    static int dx[] = { 0, 1, -1, 0 };
    static int dy[] = { 1, 0, 0, -1 };

    static void move(int x, int y, int curO, int i) {

        while (i < inst.length && inst[i] != 'F')
            curO = inst[i++] == 'R' ? R(curO) : L(curO);

        if (i >= inst.length) {
            out.println(x + " " + y + " " + ((char) curO));
            return;
        }

        int d = i(curO);
        int newX = x + dx[d];
        int newY = y + dy[d];

        if (newX >= grid[y].length || newX < 0 || newY >= grid.length || newY < 0) {
            if (!grid[y][x]) {
                grid[y][x] = true;
                out.println(x + " " + y + " " + ((char) curO) + " LOST");
                return;
            } else {
                move(x, y, curO, i + 1);
            }
        } else
            move(newX, newY, curO, i + 1);

    }

    static int R(int o) {
        if (o == 'E')
            return 'S';
        if (o == 'S')
            return 'W';
        if (o == 'W')
            return 'N';
        return 'E';
    }

    static int L(int o) {
        return R(R(R(o)));
    }

    static int i(int c) {
        if (c == 'N')
            return 0;
        if (c == 'E')
            return 1;
        if (c == 'W')
            return 2;
        return 3;
    }

    public static void main(String[] args) throws IOException {
        rx = input.nextInt();
        ry = input.nextInt();

        grid = new boolean[ry + 1][rx + 1];

        while (true) {

            lx = input.nextInt();
            ly = input.nextInt();
            o = input.next().charAt(0);

            inst = input.nextLine().toCharArray();

            move(lx, ly, o, 0);

            if (!input.hasNext())
                break;
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