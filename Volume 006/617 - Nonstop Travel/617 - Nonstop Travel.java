import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {
        int caseNo = 1;
        while (true) {
            int n = input.nextInt();

            if (caseNo != 1)
                out.println();

            if (n == -1)
                break;

            double a[][] = new double[n][4];

            for (int i = 0; i < n; i++) { for (int j = 0; j < 4; j++) { a[i][j] = input.nextDouble(); } }

            Queue<Integer> q = new LinkedList<>();

            for (int speed = 30; speed <= 60; speed++) {
                int mask = 0;
                for (int traffic = 0; traffic < n; traffic++) {
                    double time = (a[traffic][0] * 60 * 60) / ((double) speed);

                    int fullPeriod = (int) (a[traffic][1] + a[traffic][2] + a[traffic][3]);
                    time = time % fullPeriod;

                    double goodPeriod = a[traffic][1] + a[traffic][2];
                    if (time < goodPeriod || Math.abs(time - goodPeriod) < 1e-9) {
                        mask |= (1 << traffic);
                    }
                }
                if (mask == (1 << n) - 1) {
                    q.add(speed);
                }

            }

            out.print("Case " + caseNo + ": ");
            if (q.isEmpty()) {
                out.print("No acceptable speeds.");
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                int start = cur;
                while (!q.isEmpty() && q.peek() - cur == 1) { cur = q.poll(); }
                int end = cur;
                if (end != start) {
                    out.print(start + "-" + end);
                    if (!q.isEmpty())
                        out.print(", ");

                } else {
                    out.print(cur);
                    if (!q.isEmpty()) {
                        out.print(", ");
                    }
                }
            }
            caseNo++;

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