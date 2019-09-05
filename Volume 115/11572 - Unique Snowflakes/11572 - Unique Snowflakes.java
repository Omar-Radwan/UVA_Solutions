import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int max = 0;
            int first = 0;
            int last = 0;

            while (n-- > 0) {
                int x = input.nextInt();
                if (map.containsKey(x)) {
                    first = Math.max(first, map.get(x));
                }

                map.put(x, ++last);
                max = Math.max(max, last - first);
            }
            out.println(max);

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