import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
            }

            int sum = 0, max = 0;

            for (int i = 0; i < a.length; i++) {
                sum += a[i];
                max = Math.max(sum, max);
                if (sum < 0)
                    sum = 0;
            }
            System.out.println(max > 0 ? "The maximum winning streak is " + max + "." : "Losing streak.");
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
    }

}