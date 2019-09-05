import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer>[] g;
    static int dist[], n, m;
    static final int INF = (int) 1e9;
    static TreeMap<String, Integer> map;

    static ArrayList<String> words;

    static int bfs(int x, int y) {
        Arrays.fill(dist, INF);

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (int v : g[p]) {
                if (dist[v] == INF) {
                    q.add(v);
                    dist[v] = dist[p] + 1;
                }
            }
        }

        return dist[y];

    }

    public static void main(String[] args) throws IOException {
        int sets = input.nextInt();
        input.nextLine();

        while (sets-- > 0) {

            words = new ArrayList<>();
            int mappedValue = 0;
            map = new TreeMap<String, Integer>();

            while (true) {
                String s = input.next();
                if (s.equals("*"))
                    break;
                map.put(s, ++mappedValue);
                words.add(s);
            }

            n = words.size();
            g = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) { g[i] = new ArrayList<>(); }

            dist = new int[n + 1];

            for (int i = 0; i < words.size(); i++) {
                for (int j = i + 1; j < words.size(); j++) {
                    if (i == j)
                        continue;
                    if (words.get(i).length() == words.get(j).length()) {
                        int diff = 0;
                        for (int k = 0; k < words.get(i).length(); k++) {
                            if (words.get(i).charAt(k) != words.get(j).charAt(k)) {
                                diff++;
                            }
                        }

                        if (diff == 1) {
                            int x = map.get(words.get(i));
                            int y = map.get(words.get(j));
                            g[x].add(y);
                            g[y].add(x);
                        }
                    }

                }
            }

            while (true) {
                String s = input.nextLine();
                if (s == null || s.isEmpty())
                    break;
                StringTokenizer st = new StringTokenizer(s, " ");
                String x = st.nextToken();
                String y = st.nextToken();

                int ans = bfs(map.get(x), map.get(y));
                out.println(x + " " + y + " " + ans);
            }

            if (sets > 0) {
                out.println();
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