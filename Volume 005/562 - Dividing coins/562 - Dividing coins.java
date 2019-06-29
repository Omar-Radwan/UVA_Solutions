import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static int[][] memo;
    static boolean[][] v;
    static int n;
    static int[] coins;
    static int sum;

    static int solve(int i, int money) {
        if (i >= n)
            return Math.abs(sum - 2 * money);

        if (v[i][money])
            return memo[i][money];
        v[i][money] = true;

        return memo[i][money] = Math.min(solve(i + 1, money), solve(i + 1, money + coins[i]));

    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {

            n = input.nextInt();

            coins = new int[n];

            sum = 0;

            for (int i = 0; i < n; i++) {
                coins[i] = input.nextInt();
                sum += coins[i];
            }

            // indx and money one of them has

            memo = new int[n + 5][sum + 5];
            v = new boolean[n + 5][sum + 5];

            System.out.println(solve(0, 0));
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