import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int l, m, c;

    public static void main(String[] args) throws IOException {

        c = input.nextInt();
        while (c-- > 0) {
            l = input.nextInt() * 100;
            m = input.nextInt();

            Queue<Integer> q[] = new Queue[2];
            q[0] = new LinkedList<>();
            q[1] = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                int f = input.nextInt();
                String s = input.next();
                if (s.equals("left")) {
                    q[0].add(f);
                } else {
                    q[1].add(f);
                }
            }

            int cnt = 0;
            int cur = 0;

            while (q[0].size() > 0 || q[1].size() > 0) {
                int load = 0;
                while (q[cur].size() > 0 && load + q[cur].peek() <= l) {
                    load += q[cur].poll();
                }
                cnt++;
                cur = Math.abs(1 - cur);
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