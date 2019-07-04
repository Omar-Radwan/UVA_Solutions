import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static ArrayList<Integer> a[];

    static int i(char c) {
        return c >= 'a' && c <= 'z' ? c - 'a' : c - 'A' + 26;
    }

    static int firstTrue(int i, int l, int last) {

        int r = a[i].size() - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (a[i].get(mid) > last)
                r = mid;
            else
                l = mid + 1;
        }
        return l < a[i].size() && a[i].get(l) > last ? l : -1;
    }

    public static void main(String[] args) throws IOException {

        char[] c = input.nextLine().toCharArray();

        a = new ArrayList[52];

        for (int i = 0; i < a.length; i++)
            a[i] = new ArrayList<>();

        for (int i = 0; i < c.length; i++) {
            a[i(c[i])].add(i);
        }

        for (int i = 0; i < a.length; i++) {
            Collections.sort(a[i]);
        }

        int t = input.nextInt();

        while (t-- > 0) {

            char[] x = input.nextLine().toCharArray();
            int[] L = new int[52];

            int u = -1;
            int v = -1;
            int last = -1;

            boolean isGood = true;

            for (int i = 0; i < x.length; i++) {

                char cur = x[i];
                int indx = firstTrue(i(cur), L[i(cur)], last);

                if (indx == -1) {
                    isGood = false;
                    break;
                }

                L[i(cur)] = indx + 1;

                last = a[i(cur)].get(indx);

                if (i == 0)
                    u = last;

            }
            v = last;

            out.println(isGood ? "Matched " + u + " " + v : "Not matched");
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