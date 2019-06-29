import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    static int[] price, weight, person;
    static int n, g;

    static int[][] memo;
    static boolean[][] v;

    static final int _INF = (int) -1e9;

    static int solve(int i, int maxWeight) {

        if (maxWeight < 0)
            return _INF;

        if (maxWeight == 0 || i >= n)
            return 0;

        if (v[i][maxWeight])
            return memo[i][maxWeight];

        v[i][maxWeight] = true;

        return memo[i][maxWeight] = Math.max(price[i] + solve(i + 1, maxWeight - weight[i]), solve(i + 1, maxWeight));
    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            n = input.nextInt();
            price = new int[n];
            weight = new int[n];

            for (int i = 0; i < n; i++) {
                price[i] = input.nextInt();
                weight[i] = input.nextInt();
            }

            g = input.nextInt();
            person = new int[g];

            for (int i = 0; i < g; i++) {
                person[i] = input.nextInt();
            }

            memo = new int[n + 5][30 + 5];
            v = new boolean[n + 5][30 + 5];

            int sum = 0;

            for (int i = 0; i < g; i++) {
                int ans = solve(0, person[i]);
                sum += ans;
            }
            out.println(sum);

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