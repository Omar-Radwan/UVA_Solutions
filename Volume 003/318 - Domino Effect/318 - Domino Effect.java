import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {

        for (int z = 1; true; z++) {
            int n = input.nextInt();
            int m = input.nextInt();
            if (n == 0)
                break;

            int dist[] = new int[n];
            int[][] adjMat = new int[n][n];
            for (int i = 0; i < n; i++) { Arrays.fill(adjMat[i], -1); }
            Arrays.fill(dist, INF);

            for (int i = 0; i < m; i++) {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                int w = input.nextInt();
                adjMat[x][y] = w;
                adjMat[y][x] = w;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(0, 0));
            dist[0] = 0;
            while (!pq.isEmpty()) {
                Pair parent = pq.poll();
                if (parent.x > dist[parent.y])
                    continue;

                for (int v = 0; v < adjMat[parent.y].length; v++) {
                    if (adjMat[parent.y][v] == -1)
                        continue;
                    int d = adjMat[parent.y][v] + parent.x;
                    if (d < dist[v]) {
                        pq.add(new Pair(d, v));
                        dist[v] = d;
                    }
                }

            }

            double[][] time = new double[n][n];

            int x = 0;
            int y = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjMat[i][j] == -1)
                        continue;
                    int min = Math.min(dist[i], dist[j]);
                    int max = Math.max(dist[i], dist[j]);
                    if (min + adjMat[i][j] == max) {
                        time[i][j] = max;
                    }

                    else {
                        int diff = max - min;
                        int t = adjMat[i][j];
                        t -= diff;

                        time[i][j] = max + ((double) t / 2);

                    }

                    if (time[i][j] > time[x][y]) {
                        x = i;
                        y = j;
                    }
                    time[i][j] = Math.round(time[i][j] * 10.0) / 10.0;
                }

            }

            out.println("System #" + z);
            out.print("The last domino falls after " + time[x][y] + " seconds, ");
            if (Math.abs(time[x][y] - Math.max(dist[x], dist[y])) <= 1e-9) {
                int maxIndx = y;
                if (dist[x] > dist[y]) {
                    maxIndx = x;
                }
                out.println("at key domino " + (int) (maxIndx + 1) + ".");

            }

            else {
                out.println("between key dominoes " + (int) (x + 1) + " and " + (int) (y + 1) + ".");
            }

            out.println();

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
            return x - o.x;
        }

        @Override
        public String toString() { return "(" + this.x + "," + this.y + ")"; }
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