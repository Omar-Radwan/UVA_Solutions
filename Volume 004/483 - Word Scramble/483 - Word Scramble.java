import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        while (true) {
            char c[] = input.nextLine().toCharArray();
            StringBuilder s = new StringBuilder("");
            for (int i = c.length - 1; i >= 0; i--) {
                s.append(c[i]);
            }

            StringTokenizer st = new StringTokenizer(s.toString());
            Stack<String> stack = new Stack<>();
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            s = new StringBuilder("");

            while (!stack.isEmpty()) {
                s.append(stack.pop());
                if (stack.size() > 0)
                    s.append(" ");
            }

            out.println(s);
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