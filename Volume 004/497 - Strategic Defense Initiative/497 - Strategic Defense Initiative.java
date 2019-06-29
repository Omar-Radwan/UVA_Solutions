import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer> a;
    static int n;
    static int[][] memo;
    static boolean[][] v;

    static int solve(int i, int prevIndx) {
        if (i >= n)
            return 0;

        if (v[i][prevIndx])
            return memo[i][prevIndx];
        v[i][prevIndx] = true;

        int current = a.get(i);
        int prev = prevIndx == n + 2 ? Integer.MIN_VALUE : a.get(prevIndx);

        int x = 0;

        if (current > prev)
            x = solve(i + 1, i) + 1;

        return memo[i][prevIndx] = Math.max(x, solve(i + 1, prevIndx));

    }

    static void print(int i, int prevIndx) {
        if (i >= n)
            return;
        int current = a.get(i);
        int prev = prevIndx == n + 2 ? Integer.MIN_VALUE : a.get(prevIndx);

        int x = 0;

        if (current > prev)
            x = solve(i + 1, i) + 1;

        int y = solve(i + 1, prevIndx);

        int opt = solve(i, prevIndx);
        if (opt == 1) {
            out.println(current);
        } else if (opt == x) {
            out.println(current);
            print(i + 1, i);
        } else {
            print(i + 1, prevIndx);
        }

    }

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            a = new ArrayList<>();

            while (true) {
                String s = input.nextLine();
                if (s == null || s.equals(""))
                    break;
                a.add(Integer.parseInt(s));
            }
            n = a.size();

            memo = new int[n + 5][n + 5];
            v = new boolean[n + 5][n + 5];
            int ans = solve(0, n + 2);

            out.println("Max hits: " + ans);
            print(0, n + 2);
            if (t != 0)
                out.println();
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