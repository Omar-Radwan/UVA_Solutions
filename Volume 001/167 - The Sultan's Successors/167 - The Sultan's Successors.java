import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);
    static FastReader input = new FastReader();
    static int[][] grid;
    static int[] occupiedRows;

    static boolean available(int row, int col) {

        for (int i = 1; i < row; i++) {
            if (Math.abs(row - i) == Math.abs(col - occupiedRows[i])) {
                return false;
            } else if (occupiedRows[i] == col) {
                return false;
            }
        }

        return true;
    }

    static int findMaxSum(int row, int col) {

        if (col >= 9)
            return Integer.MIN_VALUE;

        if (row >= 9) {
            return 0;
        }

        int x = Integer.MIN_VALUE, y = 0;

        if (available(row, col)) {
            occupiedRows[row] = col;
            x = grid[row][col] + findMaxSum(row + 1, 1);
        }

        y = findMaxSum(row, col + 1);

        return Math.max(x, y);

    }

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {

            occupiedRows = new int[9];
            grid = new int[9][9];

            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    grid[i][j] = input.nextInt();
                }
            }

            out.printf("%5d\n", findMaxSum(1, 1));
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