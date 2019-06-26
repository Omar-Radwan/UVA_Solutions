import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {

        
        
        
        
        
        
        
        
        
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

    static class con {
        static final int IINF = (int) (1e9 + 20);
        static final int _IINF = (int) (-1e9 - 20);
        static final long LINF = (long) (1e15);
        static final long _LINF = (long) (-1e15);
        static final double EPS = 1e-5;
    }

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
}