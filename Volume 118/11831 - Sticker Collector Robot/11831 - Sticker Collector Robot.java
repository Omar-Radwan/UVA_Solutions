import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m;
    static char[] inst, grid[];
    // NSLO //NSEW
    // D right E left
    static int dR[] = { -1, 1, 0, 0 };
    static int dC[] = { 0, 0, 1, -1 };

    static int i(int c) {
        if (c == 'N')
            return 0;
        if (c == 'S')
            return 1;
        if (c == 'L')
            return 2;
        return 3;
    }

    static int D(int c) {
        if (c == 'N')
            return 'L';
        if (c == 'L')
            return 'S';
        if (c == 'S')
            return 'O';
        return 'N';
    }

    static int E(int c) {
        return D(D(D(c)));
    }

    static boolean isInvalid(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '#')
            return true;
        return false;
    }

    public static int move(int r, int c, int o, int i) {

        int ret = 0;

        if (grid[r][c] == '*') {
            ret = 1;
            grid[r][c] = '.';
        }

        while (i < inst.length && inst[i] != 'F')
            o = inst[i++] == 'D' ? D(o) : E(o);

        if (i >= inst.length)
            return ret;
        int d = i(o);

        int nR = r + dR[d];
        int nC = c + dC[d];

        if (!isInvalid(nR, nC))
            return ret + move(nR, nC, o, i + 1);
        return ret + move(r, c, o, i + 1);
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            n = input.nextInt();
            m = input.nextInt();
            input.nextInt();

            if (n == 0)
                break;
            grid = new char[n][];

            int o = ' ';
            int r = 0;
            int c = 0;

            for (int i = 0; i < n; i++) {
                grid[i] = input.nextLine().toCharArray();
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != '.' && grid[i][j] != '*' && grid[i][j] != '#') {
                        r = i;
                        c = j;
                        o = grid[i][j];
                        grid[i][j] = '.';
                    }
                }
            }

            inst = input.nextLine().toCharArray();
            int ans = move(r, c, o, 0);
            out.println(ans);
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