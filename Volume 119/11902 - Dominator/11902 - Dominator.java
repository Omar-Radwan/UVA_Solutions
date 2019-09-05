import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int t, n;
    static boolean adjMat[][], reachable[][];

    static void dfs(int p, int turnedOff) {
        if (p == turnedOff)
            return;
        reachable[turnedOff][p] = true;

        for (int i = 0; i < n; i++) {
            if (!reachable[turnedOff][i] && adjMat[p][i])
                dfs(i, turnedOff);
        }

    }

    public static void main(String[] args) throws IOException {

        t = input.nextInt();

        for (int z = 1; z <= t; z++) {

            n = input.nextInt();

            adjMat = new boolean[n][n];
            reachable = new boolean[n + 1][n + 1];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = input.nextInt();
                    if (x == 1)
                        adjMat[i][j] = true;
                }
            }

            for (int i = n; i >= 0; i--) { dfs(0, i); }

            out.println("Case " + z + ":");
            for (int i = 0; i < n; i++) {

                out.print("+");
                for (int l = 0; l < 2 * n - 1; l++)
                    out.print("-");
                out.println("+");

                for (int j = 0; j < n; j++) {
                    if (reachable[n][j] && !reachable[i][j]) {
                        out.print("|Y");
                    } else {
                        out.print("|N");
                    }

                }
                out.println("|");

                if (i == n - 1) {

                    out.print("+");
                    for (int l = 0; l < 2 * n - 1; l++)
                        out.print("-");
                    out.println("+");

                }
            }

        }
        out.flush();
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