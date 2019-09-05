import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        for (int z = 1; z <= t; z++) {

            char[] c = input.nextLine().toCharArray();
            Stack<Character> s = new Stack<>();
            int count[] = new int[26];
            for (int i = 0; i < c.length; i++) {
                if (s.isEmpty())
                    s.push(c[i]);
                else {
                    if (c[i] == s.peek()) {
                        s.pop();
                    } else {
                        count[s.peek() - 'A']++;
                        count[c[i] - 'A']++;
                        s.push(c[i]);
                    }
                }

            }
            out.println("Case " + z);
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 0)
                    continue;

                out.println((char) (i + 'A') + " = " + count[i]);
            }
        }

        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) { st = new StringTokenizer(br.readLine()); }
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException { return Integer.parseInt(next()); }

        long nextLong() throws NumberFormatException, IOException { return Long.parseLong(next()); }

        double nextDouble() throws NumberFormatException, IOException { return Double.parseDouble(next()); }

        String nextLine() throws IOException {
            String str = "";
            str = br.readLine();
            return str;
        }

        boolean hasNext() throws IOException { return br.ready(); }
    }

}