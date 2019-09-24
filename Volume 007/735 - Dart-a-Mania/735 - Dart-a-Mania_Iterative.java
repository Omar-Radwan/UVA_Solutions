import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        set.add(50);

        for (int i = 1; i <= 20; i++) {
            set.add(i);
            set.add(i * 2);
            set.add(i * 3);
        }

        Integer can[] = new Integer[set.size()];
        set.toArray(can);

        while (true) {
            int n = input.nextInt();
            if (n <= 0) {
                out.println("END OF OUTPUT");
                break;
            }

            int p = 0;
            int c = 0;
            TreeSet<Triple> visited = new TreeSet<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            
            for (int i = 0; i < can.length; i++) {
                for (int j = 0; j < can.length; j++) {
                    for (int k = 0; k < can.length; k++) {
                        if (can[i] + can[j] + can[k] == n) {
                            p++;
                            pq.add(can[i]);
                            pq.add(can[j]);
                            pq.add(can[k]);
                            Triple cur = new Triple(pq.poll(), pq.poll(), pq.poll());

                            if (!visited.contains(cur)) {
                                c++;
                                visited.add(cur);
                            }

                        }
                    }
                }
            }

            if (c != 0) {
                out.println("NUMBER OF COMBINATIONS THAT SCORES " + n + " IS " + c + ".");
                out.println("NUMBER OF PERMUTATIONS THAT SCORES " + n + " IS " + p + ".");
            } else {
                out.println("THE SCORE OF " + n + " CANNOT BE MADE WITH THREE DARTS.");
            }

            out.println("**********************************************************************");

        }
        out.flush();
    }

    static class Triple implements Comparable<Triple> {
        int x, y, z;

        Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Triple o) {
            if (o.x == x && o.y == y)
                return z - o.z;
            if (o.x == x)
                return y - o.y;
            return x - o.x;
        }

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
