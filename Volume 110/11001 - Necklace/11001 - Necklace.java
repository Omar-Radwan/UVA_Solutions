import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        while (true) {
            int vT = input.nextInt();
            int vN = input.nextInt();

            if (vT == 0 && vN == 0)
                break;

            double bestLength = 0;
            int bestNumber = -1;

            boolean isUnique = false;

            for (int i = 1; true; i++) {
                double temp = (double) vT / i;

                if (temp - vN <= 1e-9)
                    break;

                double length = i * .3 * (Math.sqrt(temp - vN));

                if (Math.abs(length - bestLength) <= 1e-9)
                    isUnique = false;

                if (length - bestLength > 1e-9) {
                    isUnique = true;
                    bestLength = length;
                    bestNumber = i;
                }
            }

            if (!isUnique)
                System.out.println(0);
            else
                System.out.println(bestNumber);
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
