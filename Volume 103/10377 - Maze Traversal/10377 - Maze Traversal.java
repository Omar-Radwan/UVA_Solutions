import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, m, r, c, o;

    static char[][] s;

    // N E S W
    static int dr[] = { -1, 0, 1, 0 };
    static int dc[] = { 0, 1, 0, -1 };

    static boolean move(char[] inst, int i) {

        while (i < inst.length && inst[i] != 'F' && inst[i] != 'Q')
            o = inst[i++] == 'R' ? R(o) : L(o);

        if (i >= inst.length)
            return false;

        if (inst[i] == 'Q')
            return true;

        int d = i(o);

        int nR = r + dr[d];
        int nC = c + dc[d];

        if (!isInvalid(nR, nC)) {
            r = nR;
            c = nC;
        }
        return move(inst, i + 1);

    }

    static int i(int o) {
        if (o == 'N')
            return 0;
        if (o == 'E')
            return 1;
        if (o == 'S')
            return 2;
        return 3;
    }

    static boolean isInvalid(int nR, int nC) {
        if (nR < 0 || nR >= n || nC < 0 || nC >= m || s[nR][nC] == '*')
            return true;
        return false;
    }

    static int R(int o) {
        if (o == 'N')
            return 'E';
        if (o == 'E')
            return 'S';
        if (o == 'S')
            return 'W';
        return 'N';

    }

    static int L(int o) {
        return R(R(R(o)));
    }

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            n = input.nextInt();
            m = input.nextInt();
            s = new char[n][m];
            for (int i = 0; i < n; i++) {
                String x = input.nextLine();
                for (int j = 0; j < m; j++) {
                    s[i][j] = x.charAt(j);
                }
            }

            r = input.nextInt() - 1;
            c = input.nextInt() - 1;
            o = 'N';

            while (true) {
                char[] inst = input.next().toCharArray();
                boolean isDone = move(inst, 0);
                if (isDone) {
                    r++;
                    c++;
                    out.println(r + " " + c + " " + (char) o);
                    break;
                }

            }
            if (t > 0) {
                input.nextLine();
                out.println();
            }

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