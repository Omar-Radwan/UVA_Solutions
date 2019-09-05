import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        while (true) {

            TreeMap<Character, Integer> map = new TreeMap<>();

            int n = input.nextInt();
            int m = input.nextInt();

            int hash = 0;

            char[] c = input.nextLine().toCharArray();

            for (int i = 0; i < 3; i++) { map.put(c[i], hash++); }

            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++)
                g[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                char[] c2 = input.nextLine().toCharArray();

                Integer xm = map.get(c2[0]);
                if (xm == null) {
                    xm = hash;
                    map.put(c2[0], hash++);
                }

                Integer ym = map.get(c2[1]);
                if (ym == null) {
                    ym = hash;
                    map.put(c2[1], hash++);
                }

                g[xm].add(ym);
                g[ym].add(xm);

            }

            TreeSet<Integer> done = new TreeSet<>();

            done.add(0);
            done.add(1);
            done.add(2);

            int f = 0;

            while (true) {

                int x = done.size();

                ArrayList<Integer> tmp = new ArrayList<>();

                for (int i = 0; i < g.length; i++) {
                    if (done.contains(i))
                        continue;
                    int can = 0;
                    for (int v : g[i]) {
                        if (done.contains(v)) {
                            can++;
                        }
                    }
                    if (can >= 3) {
                        tmp.add(i);
                    }
                }

                for (int p : tmp) { done.add(p); }
                if (done.size() == x) {
                    break;
                }
                f++;
            }

            if (done.size() == n) {
                out.println("WAKE UP IN, " + f + ", YEARS");
            } else {
                out.println("THIS BRAIN NEVER WAKES UP");
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