import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer> missile;
    static int[][] memo;
    static boolean[][] v;

    static int solve(int i, int h) {

        if (i >= missile.size())
            return 0;

        if (v[i][h])
            return memo[i][h];

        v[i][h] = true;

        int x = 0;
        if (h >= missile.get(i)) {
            x = 1 + solve(i + 1, missile.get(i));
        }
        int y = solve(i + 1, h);
        return memo[i][h] = Math.max(x, y);

    }

    public static void main(String[] args) throws IOException {
        int k = 1;
        while (true) {

            missile = new ArrayList<>();
            int x = input.nextInt();

            if (x == -1)
                break;

            if (k != 1)
                out.println();

            missile.add(x);
            while (true) {
                x = input.nextInt();
                if (x == -1)
                    break;
                missile.add(x);
            }

            memo = new int[missile.size() + 4][32769];
            v = new boolean[missile.size() + 4][32769];
            out.println("Test #" + k++ + ":");
            out.println("  maximum possible interceptions: " + solve(0, 32768));

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