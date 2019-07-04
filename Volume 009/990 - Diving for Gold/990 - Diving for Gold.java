import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int t, w, n, a[][], memo[][];
    static boolean v[][];
    static final int _IINF = (int) (-1e8);
    static StringBuilder items;

    static int solve(int indx, int rem) {
        if (rem < 0)
            return _IINF;

        if (indx >= n || rem == 0)
            return 0;

        if (v[indx][rem])
            return memo[indx][rem];
        v[indx][rem] = true;

        int cost = 3 * w * a[indx][0];
        int gold = a[indx][1];

        int x = gold + solve(indx + 1, rem - cost);
        int y = solve(indx + 1, rem);

        return memo[indx][rem] = Math.max(x, y);
    }

    static void print(int indx, int rem, int count) {

        if (indx >= n || rem == 0) {
            out.println(count);
            return;
        }
        v[indx][rem] = true;

        int cost = 3 * w * a[indx][0];
        int gold = a[indx][1];

        int x = gold + solve(indx + 1, rem - cost);

        int opt = solve(indx, rem);

        if (opt == x) {
            items.append(a[indx][0] + " " + a[indx][1] + "\n");
            print(indx + 1, rem - cost, count + 1);
        } else {
            print(indx + 1, rem, count);
        }

    }

    public static void main(String[] args) throws IOException {
        while (input.hasNext()) {
            t = input.nextInt();
            w = input.nextInt();
            n = input.nextInt();

            memo = new int[n + 5][t + 5];
            v = new boolean[n + 5][t + 5];

            a = new int[n][2];

            for (int i = 0; i < n; i++) {
                a[i][0] = input.nextInt();
                a[i][1] = input.nextInt();
            }

            out.println(solve(0, t));
            items = new StringBuilder();
            print(0, t, 0);
            out.print(items);
            if (input.hasNext())
                out.println();
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