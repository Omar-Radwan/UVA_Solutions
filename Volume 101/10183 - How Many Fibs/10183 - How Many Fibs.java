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

    public static void main(String[] args) throws IOException {

        ArrayList<BigInteger> memo = new ArrayList<>();

        memo.add(BigInteger.ONE);
        memo.add(BigInteger.valueOf(2));

        for (int i = 2; true; i++) {
            memo.add(memo.get(i - 1).add(memo.get(i - 2)));
            if (memo.get(i).toString().length() > 100)
                break;
        }

        while (true) {
            BigInteger a = new BigInteger(input.next());
            BigInteger b = new BigInteger(input.next());

            if (a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO))
                break;

            int cnt = 0;

            for (BigInteger x : memo) {
                if (x.compareTo(a) >= 0 && x.compareTo(b) <= 0) {
                    cnt++;
                }
            }

            out.println(cnt);

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