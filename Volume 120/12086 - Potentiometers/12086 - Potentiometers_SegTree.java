import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, st[], a[];

    static void build(int i, int l, int r) {
        if (l == r) {
            st[i] = a[l];
        } else {
            int m = (l + r) >> 1, im = i << 1;

            build(im, l, m);
            build(im + 1, m + 1, r);

            st[i] = st[im] + st[im + 1];

        }
    }

    static void update(int i, int l, int r, int ti, int v) {
        if (l == r)
            st[i] = v;

        else {

            int m = (l + r) >> 1, im = i << 1;

            if (ti >= l && ti <= m)
                update(im, l, m, ti, v);

            else
                update(im + 1, m + 1, r, ti, v);

            st[i] = st[im] + st[im + 1];

        }

    }

    static int query(int i, int l, int r, int tl, int tr) {
        if (l > tr || r < tl)
            return 0;
        else if (l >= tl && r <= tr) {
            return st[i];
        } else {
            int m = (l + r) >> 1, im = i << 1;
            return query(im, l, m, tl, tr) + query(im + 1, m + 1, r, tl, tr);
        }

    }

    public static void main(String args[]) throws IOException {

        int caseNo = 1;

        while (true) {

            n = input.nextInt();
            if (n == 0)
                break;
            if (caseNo > 1)
                out.println();
            out.println("Case " + caseNo++ + ":");
            a = new int[n];
            st = new int[n << 2];

            for (int i = 0; i < n; i++) { a[i] = input.nextInt(); }

            build(1, 0, n - 1);

            while (true) {
                String s = input.nextLine();
                if (s.equals("END"))
                    break;

                String tokens[] = s.split(" ");
                if (s.charAt(0) == 'M') {
                    int l = Integer.parseInt(tokens[1]);
                    int r = Integer.parseInt(tokens[2]);
                    out.println(query(1, 0, n - 1, l - 1, r - 1));
                } else {
                    int indx = Integer.parseInt(tokens[1]);
                    int val = Integer.parseInt(tokens[2]);
                    update(1, 0, n - 1, indx - 1, val);
                }
            }

            if (!input.hasNext())
                break;

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