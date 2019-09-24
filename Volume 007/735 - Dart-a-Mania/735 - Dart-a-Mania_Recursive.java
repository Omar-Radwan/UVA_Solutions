import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static Integer can[];

    static int permutations(int n, int level) {
        if (level == 3) {

            if (n == 0)
                return 1;

            return 0;
        }
        int sum = 0;
        for (int i = 0; i < can.length; i++) { sum += permutations(n - can[i], level + 1); }
        return sum;

    }

    static int combination(int n, int level, int indx) {
        if (level == 3) {
            if (n == 0)
                return 1;
            return 0;
        }
        if (indx >= can.length)
            return 0;
        return combination(n - can[indx], level + 1, indx) + combination(n, level, indx + 1);
    }

    public static void main(String args[]) throws IOException {

        TreeSet<Integer> x = new TreeSet<>();
        x.add(0);
        x.add(50);
        for (int i = 1; i <= 20; i++) {
            x.add(i);
            x.add(i * 2);
            x.add(i * 3);
        }
        can = new Integer[x.size()];
        x.toArray(can);

        while (true) {

            int n = input.nextInt();
            if (n <= 0) {
                out.println("END OF OUTPUT");
                break;

            }

            int c = combination(n, 0, 0);
            int p = permutations(n, 0);
            if (c != 0) {
                out.println("NUMBER OF COMBINATIONS THAT SCORES " + n + " IS " + c + ".");
                out.println("NUMBER OF PERMUTATIONS THAT SCORES " + n + " IS " + p + ".");
            } else {
                out.println("THE SCORE OF " + n + " CANNOT BE MADE WITH THREE DARTS.");
            }

            out.println("**********************************************************************");

        }
        out.flush();
    }

    static class Triple implements Comparable<Triple> {
        int x;
        int y;
        int z;

        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Triple o) {
            if (x == o.x && y == o.y)
                return z - o.z;
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + x + ", " + y + ", " + z + ")"; }
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
