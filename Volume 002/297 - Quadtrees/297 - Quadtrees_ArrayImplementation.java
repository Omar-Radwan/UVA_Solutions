import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

 class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean tree[];

    static int mark(int treeIndx, int preIndx, char pre[]) {

        if (pre[preIndx] == 'f') {
            tree[treeIndx] = true;
        } else if (pre[preIndx] == 'p') {

            for (int j = 0; j < 4; j++) { preIndx = mark(treeIndx * 4 + j, preIndx + 1, pre); }

        }

        return preIndx;
    }

    static int evaluate(int treeIndx, int val) {
        if (val == 0)
            return 0;

        if (tree[treeIndx]) {
            return val;
        } else {
            int sum = 0;
            for (int j = 0; j < 4; j++) { sum += evaluate(treeIndx * 4 + j, val / 4); }
            return sum;
        }
    }

    public static void main(String args[]) throws IOException {

        int n = input.nextInt();
        while (n-- > 0) {
            tree = new boolean[4000];
            char s1[] = input.nextLine().toCharArray();
            char s2[] = input.nextLine().toCharArray();
            mark(1, 0, s1);
            mark(1, 0, s2);
            out.println("There are "+evaluate(1, 1024)+" black pixels.");
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