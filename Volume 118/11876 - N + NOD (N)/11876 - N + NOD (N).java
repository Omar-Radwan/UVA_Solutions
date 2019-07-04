import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MAXN = (int) (1e6);

    static boolean v[];
    static ArrayList<Integer> p;
    static ArrayList<Integer> s;

    static int NOD(int x) {
        int sum = 1;
        for (int i = 0; x != 1 && i < p.size(); i++) {
            int c = p.get(i);
            int curr = 0;
            while (x % c == 0) {
                x /= c;
                curr++;
            }
            sum *= (curr + 1);

        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        v = new boolean[MAXN + 1];
        p = new ArrayList<>();
        s = new ArrayList<>();
        Arrays.fill(v, true);
        v[0] = v[1] = false;

        for (int i = 2; i * i <= MAXN; i++) {
            for (int j = 2 * i; j <= MAXN; j += i) {
                if (j % i == 0)
                    v[j] = false;
            }
        }

        for (int i = 2; i <= MAXN; i++) {
            if (v[i])
                p.add(i);
        }

        s.add(1);
        for (int i = 1; true; i++) {
            int x = s.get(i - 1);
            x += (NOD(x));
            s.add(x);

            if (s.get(i) >= MAXN)
                break;

        }
        // out.println(s.size());
        // out.println(p);
        int t = input.nextInt();

        for (int j = 1; j <= t; j++) {
            int f = input.nextInt();
            int g = input.nextInt();

            int x = Collections.binarySearch(s, f);
            int y = Collections.binarySearch(s, g);

            x = x < 0 ? -(x + 1) : x;
            y = y < 0 ? -(y + 1) : y;

            if (y > s.size() || s.get(y) > g) {
                y--;
            }

            out.println("Case " + j + ": " + Math.max(y - x + 1, 0));
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