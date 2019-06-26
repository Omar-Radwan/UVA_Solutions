import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    
    static int[][] memo;
    static boolean[][] v;

    static int solve(int k, int n) {

        if (k == 0) {
            if (n == 0)
                return 1;
            return 0;
        }

        if (v[k][n])
            return memo[k][n];

        v[k][n] = true;

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += solve(k - 1, n - i);
        }
        return memo[k][n] = sum % (int) 1e6;

    }

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            int k = input.nextInt();

            if (n == 0 && k == 0)
                break;
            memo = new int[k + 5][n + 5];
            v = new boolean[k + 5][n + 5];
            
            out.println(solve(k, n));
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