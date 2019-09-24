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
            int m = input.nextInt();

            char c[][] = new char[m][];

            for (int i = 0; i < m; i++) { c[i] = input.nextLine().toCharArray(); }

            int max = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (c[i][j] != '1')
                        continue;
                    int cur = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            if (c[k][l] != '3')
                                continue;
                            int dist = Math.abs(i - k) + Math.abs(j - l);
                            cur = Math.min(cur, dist);

                        }
                    }

                    max = Math.max(max, cur);
                }
            }

            out.println(max);
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
