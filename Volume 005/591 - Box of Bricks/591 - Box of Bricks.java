import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int f = 0;
        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;
            int a[] = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                sum += a[i];
            }
            int moves = 0;
            int one = sum / n;
            for (int i = 0; i < n; i++) {
                moves += a[i] > one ? a[i] - one : 0;
            }
            out.println("Set #" + ++f);
            out.println("The minimum number of moves is " + moves + ".");
            out.println();
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