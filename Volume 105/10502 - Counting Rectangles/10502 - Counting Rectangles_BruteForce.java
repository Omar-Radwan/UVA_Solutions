import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (true) {

            int n = input.nextInt();
            if (n == 0)
                break;
            int m = input.nextInt();
            if (m == 0)
                break;

            char c[][] = new char[n][m];

            for (int i = 0; i < n; i++) { c[i] = input.nextLine().toCharArray(); }

            // i j start ... k l end ... p q checkers

            long sum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    for (int k = i; k < n; k++) {
                        for (int l = j; l < m; l++) {

                            boolean good = true;
                            for (int p = i; p <= k && good; p++) {
                                for (int q = j; q <= l; q++) {
                                    if (c[p][q] == '0') {
                                        good = false;
                                        break;
                                    }
                                }
                            }
                            if (good)
                                sum++;
                        }
                    }
                }
            }

            out.println(sum);

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
