import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Long> a;
    static int n;

    public static void main(String[] args) throws IOException {

        while (input.hasNext()) {
            String s = input.nextLine();

            StringTokenizer st = new StringTokenizer(s);
            a = new ArrayList<>();

            while (true) {
                s = st.nextToken();
                if (s.equals("-999999"))
                    break;

                a.add(Long.parseLong(s));
            }

            n = a.size();

            BigInteger x[] = new BigInteger[n + 1];
            x[0] = new BigInteger("1");

            for (int i = 1; i < n + 1; i++) {
                x[i] = new BigInteger("1");
                x[i] = x[i].multiply(BigInteger.valueOf(a.get(i - 1)));
                x[i] = x[i].multiply(x[i - 1]);
            }

            BigInteger best = new BigInteger("-9999999999");

            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < i; j++) {
                    if (!x[j].toString().equals("0")) {
                        BigInteger f = x[i].divide(x[j]);
                        best = best.max(f);
                    }
                }
                BigInteger tmp = BigInteger.valueOf(a.get(i - 1));
                best = best.max(tmp);
            }
            out.println(best.toString());

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