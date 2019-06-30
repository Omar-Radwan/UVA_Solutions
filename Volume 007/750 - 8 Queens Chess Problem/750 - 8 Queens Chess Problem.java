import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();

    static int x, y;
    static int[] occupiedColumns;
    static ArrayList<String> solutions;

    static boolean availablePlace(int i, int j) {

        for (int k = 0; k < 8; k++) {
            if (occupiedColumns[k] != -1) {
                if (j == k || i == occupiedColumns[k] || (Math.abs(k - j) == Math.abs(occupiedColumns[k] - i))) {
                    return false;
                }
            }
        }

        return true;

    }

    static void solve(int i, int j) {

        if (j >= 8) {
            StringBuilder s = new StringBuilder("");

            for (int k = 0; k < 8; k++) {

                s.append(Integer.toString(occupiedColumns[k] + 1));
                if (k < 7)
                    s.append(" ");
            }

            solutions.add(s.toString());
            return;
        }

        if (i >= 8)
            return;

        if (j == y)
            solve(0, j + 1);

        else {

            if (availablePlace(i, j)) {
                occupiedColumns[j] = i;
                solve(0, j + 1);
            }

            occupiedColumns[j] = -1;
            solve(i + 1, j);

        }

    }

    public static void main(String[] args) throws IOException {

        int n = input.nextInt();

        while (n-- > 0) {

            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
            occupiedColumns = new int[8];
            Arrays.fill(occupiedColumns, -1);

            occupiedColumns[y] = x;
            solutions = new ArrayList<>();

            solve(0, 0);

            Collections.sort(solutions);
            out.printf("SOLN       COLUMN\n");
            out.printf(" #      1 2 3 4 5 6 7 8\n\n");

            for (int i = 0; i < solutions.size(); i++) {
                out.printf("%2d      ", i + 1);
                out.println(solutions.get(i));
            }

            if (n > 0)
                out.printf("\n");

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
    }

}
