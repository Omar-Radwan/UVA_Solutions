import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static TreeMap<String, Data> dist;

    static String build(String cur, boolean h, int s) {
        char[] ret = new char[9];
        if (h) {
            for (int i = 3 * s; i < 3 * s + 3; i++) {
                int x = (s * 3) + ((3 + (i + 1)) % 3);
                ret[i] = cur.charAt(x);
            }

        } else {
            for (int i = s; i < 9; i += 3) {
                int x = (9 + (i - 3)) % 9;
                ret[i] = cur.charAt(x);
            }
        }

        for (int i = 0; i < 9; i++) {
            if (ret[i] == 0) {
                ret[i] = cur.charAt(i);
            }
        }
        return new String(ret);
    }

    static String buildBackward(String cur, boolean h, int s) {
        char[] ret = new char[9];
        if (h) {
            for (int i = 3 * s; i < 3 * s + 3; i++) {
                int x = (s * 3) + ((3 + (i - 1)) % 3);
                ret[i] = cur.charAt(x);
            }

        } else {
            for (int i = s; i < 9; i += 3) {
                int x = (9 + (i + 3)) % 9;
                ret[i] = cur.charAt(x);
            }
        }

        for (int i = 0; i < 9; i++) {
            if (ret[i] == 0) {
                ret[i] = cur.charAt(i);
            }
        }
        return new String(ret);
    }

    static int bfs() {
        dist = new TreeMap<>();
        String source = "123456789";
        Data sourData = new Data(0, "");
        Queue<Data> q = new LinkedList<>();
        Queue<String> stringq = new LinkedList();

        stringq.add(source);
        q.add(sourData);
        dist.put(source, sourData);

        while (!q.isEmpty()) {
            Data cur = q.poll();
            String s = stringq.poll();

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    boolean b = i == 0 ? false : true;
                    String next = build(s, b, j);
                    Data ndata = dist.get(next);

                    if (ndata != null && ndata.dist <= cur.dist + 1)
                        continue;

                    String step = i == 0 ? "V" + (int) (j + 1) : "H" + (int) (j + 1);
                    ndata = new Data(cur.dist + 1, step);
                    dist.put(next, ndata);
                    q.add(ndata);
                    stringq.add(next);
                }

            }

        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        bfs();

        while (true) {
            char x[] = new char[9];
            boolean breakable = false;
            for (int i = 0; i < 3 && !breakable; i++) {
                String s[] = input.nextLine().split(" ");

                for (int j = 0; j < 3 && !breakable; j++) {
                    if (s[j].charAt(0) == '0')
                        breakable = true;
                    x[i * 3 + j] = s[j].charAt(0);
                }
            }
            if (breakable)
                break;
            String y = new String(x);
            Data f = dist.get(y);
            if (f == null) {
                out.println("Not solvable");
            } else {
                out.print(f.dist + " ");
                Data cur = f;
                String curString = y;

                while (!cur.step.isEmpty()) {
                    out.print(cur.step);
                    boolean b = cur.step.charAt(0) == 'H' ? true : false;
                    int n = cur.step.charAt(1) - '0' - 1;
                    curString = buildBackward(curString, b, n);
                    cur = dist.get(curString);
                }
                out.println();
            }
        }

        out.flush();

    }

    static class Data {
        int dist;
        String step;

        Data(int dist, String step) {
            this.dist = dist;
            this.step = step;
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