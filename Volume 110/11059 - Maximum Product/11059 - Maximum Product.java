import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {
        int z = 1;
        while (true) {
            int n = input.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) { a[i] = input.nextInt(); }
            input.nextLine();
            long max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    long p = a[i];
                    for (int k = i + 1; k <= j; k++) { p *= a[k]; }
                    max = Math.max(max, p);
                }
            }

         
            out.println("Case #" + z++ + ": The maximum product is " + max + ".");
                out.println();
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
