import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        ArrayList<int[]> a = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[2 * (int) 1e4];

        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()) });
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = a.get(i)[0]; j < a.get(i)[2]; j++) {
                x[j] = Math.max(x[j], a.get(i)[1]);
            }
        }

        int currentH = 0;
        boolean firstTime = true;

        for (int i = 0; i < x.length; i++) {
            if (x[i] != currentH) {
                if (!firstTime)
                    out.print(" ");
                out.print(i + " " + x[i]);
                currentH = x[i];
                firstTime = false;
            }
        }
        out.println();
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
