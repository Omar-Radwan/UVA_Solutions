import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, d[][], memo[][];
    static boolean v[][];

    static final int IINF = (int) (1e9);

    static int solve(int pos, int mask) {
        if (mask == (1 << n) - 1)
            return d[pos][0];

        if (v[pos][mask])
            return memo[pos][mask];
        v[pos][mask] = true;

        int min = IINF;
        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0)
                min = Math.min(min, d[pos][i] + solve(i, mask | 1 << i));
        }

        return memo[pos][mask] = min;
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            ArrayList<Pair> pos = new ArrayList<>();

            input.nextInt();
            input.nextInt();

            pos.add(new Pair(input.nextInt() - 1, input.nextInt() - 1));

            int x = input.nextInt();

            while (x-- > 0)
                pos.add(new Pair(input.nextInt() - 1, input.nextInt() - 1));
            n = pos.size();

            memo = new int[n + 1][1 << n];
            v = new boolean[n + 1][1 << n];

            d = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = +1; j < n; j++) {
                    int distance = Math.abs(pos.get(i).x - pos.get(j).x) + Math.abs(pos.get(i).y - pos.get(j).y);
                    d[i][j] = d[j][i] = distance;
                }
            }
            int sol = solve(0, 1);
            out.println("The shortest path has length " + sol);
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