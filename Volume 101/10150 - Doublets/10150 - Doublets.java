import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<String> words;
    static TreeMap<String, Integer> stri;
    static String istr[];
    static int hash = 0;
    static ArrayList<Integer> g[];
    static final int INF = (int) 1e9;
    static int n;

    static int countDiff(String x, String y) {

        if (x.length() != y.length())
            return 100000;

        int diff = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diff++;
            }
        }

        return diff;

    }

    static void buildGraph() {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (countDiff(words.get(i), words.get(j)) == 1) {
                    int x = stri.get(words.get(i));
                    int y = stri.get(words.get(j));
                    g[x].add(y);
                    g[y].add(x);
                }
            }
        }

    }

    static void bfs(String s, String e) {
        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[n];
        Arrays.fill(dist, INF);
        int parent[] = new int[n];

        int x = stri.get(s);
        int y = stri.get(e);
        q.add(x);
        dist[x] = 0;
        parent[x] = -1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int v : g[cur]) {
                if (dist[cur] + 1 < dist[v]) {
                    q.add(v);
                    parent[v] = cur;
                    dist[v] = dist[cur] + 1;
                }
            }
        }
        if (dist[y] == INF) {
            out.println("No solution.");
        } else {
            Stack<String> stack = new Stack<>();
            stack.push(istr[y]);
            int cur = y;
            while (parent[cur] != -1) {
                stack.push(istr[parent[cur]]);
                cur = parent[cur];
            }
            while (!stack.isEmpty()) { out.println(stack.pop()); }
        }
    }

    public static void main(String[] args) throws IOException {

        words = new ArrayList<>();

        while (true) {
            String s = input.nextLine();
            if (s == null || s.isEmpty())
                break;
            words.add(s);

        }

        n = words.size();

        istr = new String[n];
        g = new ArrayList[n];
        stri = new TreeMap<>();

        for (int i = 0; i < n; i++) { g[i] = new ArrayList<>(); }

        for (int i = 0; i < n; i++) {
            stri.put(words.get(i), hash);
            istr[hash++] = words.get(i);
        }

        buildGraph();

        while (true) {
            String s = input.next();
            String e = input.next();
            bfs(s, e);
            if (!input.hasNext()) break;
            out.println();
    
            
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