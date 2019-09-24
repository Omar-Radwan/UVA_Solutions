import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        while (true) {
            String in = input.nextLine();
            String[] s = in.split("\\s+");
            int w[] = new int[s.length];
            int n = s.length;

            for (int i = 0; i < s.length; i++) {
                char[] c = s[i].toCharArray();
                int shift = 1;
                for (int k = c.length - 1; k >= 0; k--) {
                    w[i] += (c[k] - 'a' + 1) * shift;
                    shift <<= 5;
                }
            }

            int floor[] = new int[s.length];

            for (int c = 1; true;) {

                for (int i = 0; i < s.length; i++) { floor[i] = c / w[i]; }

                boolean allDiff = true;

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j == k)
                            continue;
                        if (floor[j] % n == floor[k] % n) {
                            int cand = Math.min((floor[j] + 1) * w[j], (floor[k] + 1) * w[k]);

                            c = Math.max(c, cand);
                            allDiff = false;
                        }

                    }
                }

                if (allDiff) {
                    out.println(in);
                    out.println(c);
                    out.println();
                    break;
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