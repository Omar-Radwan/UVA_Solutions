import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static int g[], n, ans[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();
        for (int z = 1; z <= t; z++) {
            n = input.nextInt();

            g = new int[n];
            ans = new int[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                g[x] = y;
            }

            for (int i = 0; i < n; i++) {
                if (visited[i])
                    continue;

                Stack<Integer> s = new Stack<>();
                s.push(i);
                visited[i] = true;

                while (!s.isEmpty()) {
                    int p = s.peek();
                    int c = g[p];

                    if (!visited[c]) {
                        s.push(c);
                        visited[c] = true;
                    } else if (visited[c] && ans[c] != 0) {
                        int cnt = ans[c];
                        while (!s.isEmpty()) { ans[s.pop()] = ++cnt; }

                    } else if (visited[c] && ans[c] == 0) {

                        Queue<Integer> q = new LinkedList<Integer>();

                        while (true) {
                            int cur = s.pop();
                            q.add(cur);
                            if (cur == c)
                                break;
                        }

                        int cnt = q.size();
                        while (!q.isEmpty()) { ans[q.poll()] = cnt; }

                        while (!s.isEmpty()) { ans[s.pop()] = ++cnt; }

                    }
                }
            }

            int maxIndx = 0;
            for (int i = 1; i < n; i++) {
                if (ans[i] > ans[maxIndx]) {
                    maxIndx = i;
                }
            }
            // out.println(Arrays.toString(ans));

            out.println("Case " + z + ": " + (maxIndx + 1));
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