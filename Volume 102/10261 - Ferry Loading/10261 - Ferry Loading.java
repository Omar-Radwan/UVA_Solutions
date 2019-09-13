import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int t, L, memo[][], n;
    static boolean v[][];
    static ArrayList<Integer> a;
    static final int _INF = (int) -1e9;

    static int solve(int indx, int port, int starboard) {
        if (port < 0 || starboard < 0)
            return _INF;

        if (indx >= n || (port < a.get(indx) && starboard < a.get(indx)))
            return 0;

        if (v[indx][port])
            return memo[indx][port];

        v[indx][port] = true;

        return memo[indx][port] = 1 + Math.max(solve(indx + 1, port - a.get(indx), starboard),
                solve(indx + 1, port, starboard - a.get(indx)));
    }

    static void print(int indx, int port, int starboard) {
        if (indx >= n || (port < a.get(indx) && starboard < a.get(indx)))
            return;
        int opt = solve(indx, port, starboard);
        int s1 = 1 + solve(indx + 1, port - a.get(indx), starboard);
        int s2 = 1 + solve(indx + 1, port, starboard - a.get(indx));
        if (s1 == opt) {
            out.println("port");
            print(indx + 1, port - a.get(indx), starboard);
        } else if (opt == s2) {
            out.println("starboard");
            print(indx + 1, port, starboard - a.get(indx));
        }
    }

    public static void main(String args[]) throws NumberFormatException, IOException {

        t = input.nextInt();
        input.nextLine();

        for (int z = 1; z <= t; z++) {
            a = new ArrayList<>();
            L = input.nextInt() * 100;

            while (true) {
                int x = input.nextInt();
                if (x == 0)
                    break;
                a.add(x);
            }
            n = a.size();

            v = new boolean[Math.min(205, n)][L + 1];
            memo = new int[Math.min(205, n)][L + 1];

            int ans = solve(0, L, L);
            out.println(ans);
            print(0, L, L);

            if (z < t) {
                input.nextLine();
                out.println();
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