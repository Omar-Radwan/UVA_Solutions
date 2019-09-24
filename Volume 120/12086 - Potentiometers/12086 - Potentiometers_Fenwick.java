import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    static int fenwick[], n, a[];

    static void update(int indx, int value, boolean build) {

        int diff = build ? a[indx] : value - a[indx];
        a[indx] = value;
        for (; indx <= n; indx += (indx & -indx)) { fenwick[indx] += diff; }

    }

    static int query(int r) {
        if (r == 0)
            return 0;
        int sum = 0;
        for (; r > 0; r -= (r & -r)) { sum += fenwick[r]; }
        return sum;
    }

    static void buildFenwick() { for (int i = 1; i <= n; i++) { update(i, a[i], true); } }

    public static void main(String[] args) throws IOException {
        int p = 1;
        while (true) {
            n = input.nextInt();
            if (n == 0)
                break;

            if (p != 1)
                out.println();

            out.println("Case " + p + ":");
            a = new int[n + 1];
            fenwick = new int[n + 1];

            for (int i = 1; i <= n; i++) { a[i] = input.nextInt(); }
            buildFenwick();

            // out.println(Arrays.toString(fenwick));
            while (true) {
                String s = input.nextLine();
                if (s.equals("END"))
                    break;

                StringTokenizer st = new StringTokenizer(s, " ");
                char x = st.nextToken().charAt(0);
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                if (x == 'S') {
                    update(y, z, false);
                } else {
                    out.println(query(z) - query(y - 1));
                }

            }
            p++;
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