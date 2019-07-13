import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean isA(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        int freq[] = new int[26];

        while (t-- > 0) {
            String s = input.nextLine();
            s = s.toUpperCase();
            char c[] = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (isA(c[i])) {
                    freq[c[i] - 'A']++;
                }
            }

        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                pq.add(new Pair(freq[i], i));
            }
        }
        while (!pq.isEmpty()) {
            Pair x = pq.poll();
            out.println((char) (x.y + 'A') + " " + x.x);
        }
        out.flush();

    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(Pair o) {
            if (x == o.x)
                return y - o.y;
            return o.x - x;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
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

        boolean hasNext() throws IOException {
            return br.ready();
        }
    }

}