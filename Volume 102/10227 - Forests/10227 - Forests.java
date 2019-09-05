import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static class UF {
        int size[], p[], r[];
        int count;

        UF(int n) {
            p = new int[n];
            r = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        void connect(int x, int y) {

            if (!query(x, y)) {
                int i = findParent(x);
                int j = findParent(y);
                count--;
                if (r[i] > r[j]) {
                    p[j] = i;
                    size[i] += size[j];
                } else {
                    p[i] = j;
                    size[j] += size[i];
                    if (r[j] == r[i]) {
                        r[j]++;
                    }
                }

            }
        }

        boolean query(int x, int y) { return findParent(x) == findParent(y); }

        int findParent(int x) { return p[x] == x ? x : findParent(p[x]); }

        int size(int x) { return size[findParent(x)]; }
    }

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        input.nextLine();

        while (t-- > 0) {
            int persons = input.nextInt();
            int trees = input.nextInt();

            UF uf = new UF(persons);

            boolean heard[][] = new boolean[persons][trees];
            boolean visited[] = new boolean[persons];

            while (true) {

                String s = input.nextLine();

                if (s == null || s.isEmpty())
                    break;

                StringTokenizer st = new StringTokenizer(s);

                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;

                heard[i][j] = true;

            }

            for (int i = 0; i < persons; i++) {
                if (visited[i])
                    continue;

                for (int j = i + 1; j < persons; j++) {

                    if (visited[j])
                        continue;

                    boolean broke = false;

                    for (int k = 0; k < trees; k++) {
                        if (heard[i][k] != heard[j][k]) {
                            broke = true;
                            break;
                        }
                    }

                    if (!broke) {
                        uf.connect(i, j);
                    }
                }
            }
            out.println(uf.count);
            if (t > 0) {
                out.println();
            }

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