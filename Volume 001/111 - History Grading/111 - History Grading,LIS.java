import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int[] correct; // maps event to rank
    static int[] student; // maps rank to event
    static int[] memo;
    static boolean[] v;

    static int solve(int rank) {
        if (v[rank])
            return memo[rank];

        v[rank] = true;

        int stateEvent = student[rank];
        int max = 1;

        for (int i = rank - 1; i >= 0; i--) {

            int currentEvent = student[i];

            int sol = solve(i);

            if (correct[stateEvent] > correct[currentEvent]) {
                sol++;

                max = Math.max(max, sol);
            }

        }
        return memo[rank] = max;
    }

    public static void main(String[] args) throws IOException {

        String s = input.nextLine();
        while (input.hasNext()) {

            n = Integer.parseInt(s);

            correct = new int[n];
            for (int i = 0; i < n; i++) {
                correct[i] = input.nextInt() - 1;
            }

            while (input.hasNext()) {
                s = input.nextLine();

                StringTokenizer st = new StringTokenizer(s);

                if (st.countTokens() == 1) {
                    break;
                }

                student = new int[n];

                for (int i = 0; i < n; i++) {
                    int rank = Integer.parseInt(st.nextToken()) - 1;
                    student[rank] = i;
                }

                memo = new int[n + 5];
                v = new boolean[n + 5];

                solve(n - 1);
                int best = -1;
                for (int i = 0; i < n; i++) {
                    best = Math.max(best, memo[i]);
                }
                System.out.println(best);
            }

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