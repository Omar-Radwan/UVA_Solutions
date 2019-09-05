import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out, true);

    static boolean lit[], done;
    static int k;
    static StringBuilder ans;
    static final int n = 26;
    static int count = 0;
    static ArrayList<Integer> g[];

    static int findNext(int parent, int node) {
        boolean putCandle = false;

        for (int i : g[node]) {
            if (!lit[i] && i != parent && !done) {
                if (!putCandle && count == k) {
                    lit[node] = true;
                    ans.append((char) (node + 'A') + " ");
                    count = 0;
                    putCandle = true;
                }
                count++;
                return i;
            }
        }

        if (done == false) {
            done = true;
            ans.append("/" + (char) (node + 'A'));
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            g = new ArrayList[n];
            for (int i = 0; i < n; i++)
                g[i] = new ArrayList<>();

            lit = new boolean[n];
            done = false;
            ans = new StringBuilder();

            String line = input.nextLine();

            if (line.equals("#")) {
                break;
            }

            String bef = "", aft = "";
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '.') {
                    bef = line.substring(0, i);
                    aft = line.substring(i + 1);
                }
            }

            StringTokenizer st = new StringTokenizer(bef, " ;:");

            String[] tokens = bef.split(";");
            for (int i = 0; i < tokens.length; i++) {
                int p = tokens[i].charAt(0) - 'A';
                for (int j = 2; j < tokens[i].length(); j++) { g[p].add(tokens[i].charAt(j) - 'A'); }
            }

            st = new StringTokenizer(aft);
            int s = st.nextToken().charAt(0) - 'A';
            int l = st.nextToken().charAt(0) - 'A';

            k = Integer.parseInt(st.nextToken());

            int curr = l;
            int next = s;
            count = 1;

            while (true) {
                int tmp = findNext(curr, next);
                curr = next;
                next = tmp;
                if (next == -1)
                    break;
            }

            out.println(ans);

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