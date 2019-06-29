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

    static class E implements Comparable<E> {
        int w;
        int iq;
        int i;

        @Override
        public int compareTo(E o) {
            return w - o.w;
        }

    }

    static ArrayList<E> a;
    static int[] memo;
    static boolean[] v;
    static int n;

    static int fillTable(int n) {
        if (v[n])
            return memo[n];
        v[n] = true;

        int max = 1;
        E stateE = a.get(n);

        for (int i = n - 1; i >= 0; i--) {
            int sol = fillTable(i);
            E currE = a.get(i);
            if (stateE.iq < currE.iq && stateE.w > currE.w) {
                max = Math.max(max, sol + 1);
            }
        }
        return memo[n] = max;
    }

    static void print(int n) {

        int opt = fillTable(n);
        if (opt == 1) {
            out.println(a.get(n).i);
            return;
        }
        E stateE = a.get(n);

        for (int i = n - 1; i >= 0; i--) {
            int sol = fillTable(i);
            E currE = a.get(i);
            if (opt - sol == 1 && stateE.iq < currE.iq && stateE.w > currE.w) {
                print(i);
                out.println(a.get(n).i);
                return;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        a = new ArrayList<>();
        int f = 1;
        while (input.hasNext()) {
            E x = new E();
            x.w = input.nextInt();
            x.iq = input.nextInt();
            x.i = f++;
            a.add(x);
        }
        n = a.size();
        Collections.sort(a);
        memo = new int[n];
        v = new boolean[n];
        fillTable(n - 1);

        int max = 0;
        int maxIndx = -1;

        for (int i = 0; i < n; i++) {
            if (memo[i] > max) {
                max = memo[i];
                maxIndx = i;
            }
        }
        out.println(max);
        print(maxIndx);
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