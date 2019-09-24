import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void build(QuadNode root, int depth) {
        if (depth == 6)
            return;

        for (int i = 0; i < root.children.length; i++) {
            root.children[i] = new QuadNode(false);
            build(root.children[i], depth + 1);
        }

    }

    static int mark(QuadNode root, int i, char pre[]) {
        if (pre[i] == 'f') {
            root.black = true;
        } else if (pre[i] == 'p') {
            for (int j = 0; j < root.children.length; j++) { i = mark(root.children[j], i + 1, pre); }
        }
        return i;
    }

    static int count(int val, QuadNode root) {
        if (val == 0)
            return 0;
        if (root.black) {
            return val;
        } else {
            int sum = 0;
            for (int i = 0; i < root.children.length; i++) { sum += count(val / 4, root.children[i]); }
            return sum;
        }

    }

    public static void main(String args[]) throws IOException {

        int n = input.nextInt();
        while (n-- > 0) {
            tree = new boolean[4000];
            char s1[] = input.nextLine().toCharArray();
            char s2[] = input.nextLine().toCharArray();
            QuadNode root = new QuadNode(false);
            build(root, 0);

            mark(root, 0, s1);
            mark(root, 0, s2);
            out.println(count(1024, root));

        }
        out.flush();
    }

    static class QuadNode {
        boolean black;
        QuadNode children[];

        QuadNode(boolean black) {
            this.black = black;
            children = new QuadNode[4];
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
