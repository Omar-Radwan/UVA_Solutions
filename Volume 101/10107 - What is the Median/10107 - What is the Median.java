import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Stack<Integer> s = new Stack<>();

        while (true) {
            int x = input.nextInt();
            q.add(x);
            int n = q.size();
            int f = (n + 1) / 2;

            while (f-- > 0) {
                s.push(q.poll());
            }

            if (n % 2 == 0) {
                int a = s.pop();
                int b = q.peek();

                out.println((a + b) / 2);
                s.push(a);

            } else {
                out.println(s.peek());
            }
            if (!input.hasNext())
                break;

            while (!s.isEmpty())
                q.add(s.pop());

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