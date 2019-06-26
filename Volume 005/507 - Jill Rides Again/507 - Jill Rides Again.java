import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    /*
    * 
    */

    static int[][] a;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {

        int b = input.nextInt();

        for (int z = 1; z <= b; z++) {
            int r = input.nextInt();
            int[] a = new int[r - 1];
            for (int i = 0; i < a.length; i++) {
                a[i] = input.nextInt();
            }

            int sum = 0;
            int max = Integer.MIN_VALUE;

            int cS = 0;
            int cE = -1;

            int bS = 0;
            int bE = -1;

            for (int i = 0; i < a.length; i++) {
                sum += a[i];
                if (sum < 0) {
                    sum = 0;
                    cS = i + 1;
                } else if (sum >= max) {
                    cE = i;
                    if (sum > max) {
                        max = sum;
                        bS = cS;
                        bE = cE;
                    } else if (sum == max) {
                        if (cE - cS > bE - bS) {
                            bS = cS;
                            bE = cE;
                        }
                    }
                }
            }
            out.println(max <= 0 ? "Route " + z + " has no nice parts"
                    : "The nicest part of route " + z + " is between stops " + (bS + 1) + " and " + (bE + 2));
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
    }

}