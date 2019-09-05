import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static char s1[], s2[];
    static int memo[][];
    static boolean v[][];

    static int solve(int i, int j) {
        if (i >= s1.length || j >= s2.length)
            return 0;

        if (v[i][j]) {
            return memo[i][j];
        }
        v[i][j] = true;
        if (s1[i] == s2[j]) {
            return memo[i][j] = 1 + solve(i + 1, j + 1);
        } else {
            return memo[i][j] = Math.max(solve(i + 1, j), solve(i, j + 1));
        }
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            s1 = input.nextLine().toCharArray();
            s2 = input.nextLine().toCharArray();
            memo = new int[s1.length][s2.length];
            v = new boolean[s1.length][s2.length];
            out.println(solve(0, 0));
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