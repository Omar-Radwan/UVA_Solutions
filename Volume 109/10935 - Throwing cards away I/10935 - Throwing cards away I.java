import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();

    public static void main(String[] args) throws IOException {

        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;

            Deque<Integer> dq = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                dq.add(i);
            }

            System.out.print("Discarded cards:");
            boolean firstCard = true;

            while (dq.size() > 1) {
                if (!firstCard) {
                    System.out.print(", " + dq.removeFirst());
                } else {
                    System.out.print(" " + dq.removeFirst());
                    firstCard = false;
                }
                dq.add(dq.removeFirst());
            }
            System.out.println();

            System.out.println("Remaining card: " + dq.removeFirst());

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
