import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        while (true) {
            char a[] = input.nextLine().toCharArray();
            char b[] = input.nextLine().toCharArray();

            int af[] = new int[26];
            int bf[] = new int[26];

            for (int i = 0; i < a.length; i++) {
                af[a[i] - 'a']++;
            }
            for (int i = 0; i < b.length; i++) {
                bf[b[i] - 'a']++;
            }

            int l = 0;
            for (int i = 0; i < af.length; i++) {
                int min = Math.min(af[i], bf[i]);
                while (min-- > 0) {
                    a[l++] = (char) (i + 'a');
                }

            }

            String ans = new String(a);
            out.println(ans.substring(0, l));

            if (!input.hasNext())
                break;

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