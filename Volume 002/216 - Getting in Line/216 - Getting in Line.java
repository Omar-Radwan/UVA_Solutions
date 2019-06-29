import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int[][] xy;
    static double[][] memo;
    static boolean[][] v;

    static double dist(int pos, int bestIndx) {
        double dist = Math.sqrt(((xy[pos][0] - xy[bestIndx][0]) * (xy[pos][0] - xy[bestIndx][0]))
                + ((xy[pos][1] - xy[bestIndx][1]) * (xy[pos][1] - xy[bestIndx][1])));
        return dist;
    }

    static double solve(int pos, int mask) {
        if (mask == (1 << n) - 1) {
            return 0;
        }

        double best = 1e9;

        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) {
                double curr = dist(pos, i) + 16.0 + solve(i, mask | 1 << i);
                best = Math.min(curr, best);
            }
        }

        return best;

    }

    static void print(int pos, int mask) {
        if (mask == (1 << n) - 1) {
            return;
        }

        double best = 1e9;
        double optimal = solve(pos, mask);

        for (int i = 0; i < n; i++) {
            if (((1 << i) & mask) == 0) {
                double curr = dist(pos, i) + 16.0 + solve(i, mask | 1 << i);
                best = Math.min(curr, best);
                if (best == optimal) {
                    out.print("Cable requirement to connect (" + xy[pos][0] + "," + xy[pos][1] + ") to (" + xy[i][0]
                            + "," + xy[i][1] + ") is ");
                    out.printf("%.2f feet.\n", dist(pos, i) + 16.0);
                    print(i, mask | 1 << i);
                    return;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        int f = 1;
        while (true) {

            n = input.nextInt();
            if (n == 0)
                break;

            xy = new int[n][2];

            for (int i = 0; i < n; i++) {
                xy[i][0] = input.nextInt();
                xy[i][1] = input.nextInt();
            }

            memo = new double[10][1 << 8 - 1];
            v = new boolean[10][1 << 8 - 1];

            double best = 1e9;
            int bestIndx = -1;

            for (int i = 0; i < n; i++) {
                double ans = solve(i, 1 << i);
                if (ans < best) {
                    best = ans;
                    bestIndx = i;
                }
            }
            out.println("**********************************************************");
            out.println("Network #" + (f++));
            print(bestIndx, 1 << bestIndx);
            out.printf("Number of feet of cable required is %.2f.\n", best);
            out.flush();
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