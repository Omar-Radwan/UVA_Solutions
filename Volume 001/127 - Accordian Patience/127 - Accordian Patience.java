import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static LinkedList<Stack<char[]>> a;

    static boolean doMove(int i, int x) {

        if (x >= 0) {
            if (a.get(i).peek()[0] == a.get(x).peek()[0] || a.get(i).peek()[1] == a.get(x).peek()[1]) {
                a.get(x).add(a.get(i).pop());
                if (a.get(i).isEmpty()) {
                    a.remove(i);
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            a = new LinkedList<>();

            String l1 = input.nextLine();
            if (l1.equals("#"))
                break;
            String l2 = input.nextLine();
            StringTokenizer st = new StringTokenizer(l1);

            while (st.hasMoreTokens()) {
                Stack<char[]> s = new Stack<>();
                s.add(st.nextToken().toCharArray());
                a.add(s);
            }
            st = new StringTokenizer(l2);
            while (st.hasMoreTokens()) {
                Stack<char[]> s = new Stack<>();
                s.add(st.nextToken().toCharArray());
                a.add(s);
            }

            while (true) {

                boolean didMove = false;

                for (int i = 0; i < a.size(); i++) {

                    didMove = doMove(i, i - 3);
                    if (didMove)
                        break;
                    didMove = doMove(i, i - 1);
                    if (didMove)
                        break;
                }

                if (!didMove) {
                    break;
                }

            }

            out.print(a.size() + " pile" + (a.size() >= 2 ? "s" : "") + " remaining:");
            for (int i = 0; i < a.size(); i++)
                out.print(" " + a.get(i).size());
            out.println();

        }
        out.flush();
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