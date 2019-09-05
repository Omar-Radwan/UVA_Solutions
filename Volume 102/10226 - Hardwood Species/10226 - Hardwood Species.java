import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            int total = 0;
            TreeMap<String, Integer> treecnt = new TreeMap<>();

            while (true) {
                String s = input.nextLine();
                if (s == null || s.isEmpty())
                    break;
                Integer x = treecnt.get(s);
                x = x == null ? 0 : x;
                treecnt.put(s, x + 1);
                total++;
            }

            for (String tree : treecnt.keySet()) {
                double cnt = treecnt.get(tree);
                String x = String.format("%.4f", (cnt / total)*100);
                out.println(tree + " " + x);
            }

            if (t > 0)
                out.println();

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