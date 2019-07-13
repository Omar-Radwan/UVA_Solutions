import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<char[]> in;
    static boolean g[][], v[];
    static Stack<Character> stack;

    static void dfs(int p) {
        v[p] = true;

        for (int i = 0; i < g[p].length; i++) {
            if (g[p][i] && !v[i]) {
                dfs(i);
            }
        }
        stack.push((char) (p + 'A'));
    }

    public static void main(String[] args) throws IOException {

        while (true) {
            in = new ArrayList<>();
            stack = new Stack<>();
            g = new boolean[26][26];
            v = new boolean[26];
            TreeSet<Integer> found = new TreeSet<>();
        
            while (true) {
            String s = input.nextLine();
                if (s.equals("#"))
                    break;
                in.add(s.toCharArray());
                for (int i = 0; i < s.length(); i++) {
                    found.add(s.charAt(i) - 'A');
                }
            }

            for (int i = 0; i < in.size(); i++) {
                char[] cur = in.get(i);
                for (int j = i + 1; j < in.size(); j++) {
                    char[] next = in.get(j);
                    int min = Math.min(cur.length, next.length);
                    for (int k = 0; k < min; k++) {
                        if (cur[k] != next[k]) {
                            g[cur[k] - 'A'][next[k] - 'A'] = true;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < g.length; i++) {
                if (found.contains(i) && !v[i]) {
                    dfs(i);
                }
            }
            while (!stack.isEmpty()) {
                out.print(stack.pop());
            }
               out.println();
            if (!input.hasNext())
                break;

         

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