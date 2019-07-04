import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        int speed = 0;
        long last = 0;
        double sum = 0;
        while (input.hasNext()) {
            String line = input.nextLine();
            StringTokenizer st = new StringTokenizer(line, ": ");

            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            long toSec = s + m * 60 + h * 60 * 60 - last;
            double speedInSec = (double) speed / (60 * 60);

            last += toSec;
            sum += speedInSec * toSec;
            if (st.hasMoreTokens()) {
                speed = Integer.parseInt(st.nextToken());
            } else {
                out.printf("%s %.2f km\n", line, sum);
            }
            out.flush();
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