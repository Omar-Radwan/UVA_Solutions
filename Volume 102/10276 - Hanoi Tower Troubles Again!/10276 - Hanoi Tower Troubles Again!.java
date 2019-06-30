import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {

            int n = input.nextInt();
            int ans = 0;
            boolean isOk = true;
            int[] pegs = new int[n];

            for (int i = 1; isOk; i++) {
                boolean couldPlace = false;
                for (int j = 0; j < n; j++) {

                    int x = (int) Math.round(Math.sqrt(pegs[j] + i));

                    if (pegs[j] == 0) {
                        pegs[j] = i;
                        couldPlace = true;
                        ans++;
                        break;
                    }

                    else if (x * x == pegs[j] + i) {
                        pegs[j] = i;
                        couldPlace = true;
                        ans++;
                        break;
                    }

                }
                if (!couldPlace)
                    isOk = false;
            }

            System.out.println(ans);
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
                st = new StringTokenizer(br.readLine(), "\0\n ");
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
