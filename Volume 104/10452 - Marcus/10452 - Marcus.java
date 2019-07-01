import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static char[][] road;
    static String answer;
    static int m, n;

    static void findPath(int i, int j, String acheived, String steps) {
        if (acheived.equals("IEHOVA#")) {
            answer = steps;
            return;
        }

        for (int l = 0; l < acheived.length(); l++) {
            if (acheived.charAt(l) != "IEHOVA#".charAt(l))
                return;
        }

        if ((i - 1) >= 0) {
            findPath(i - 1, j, acheived + road[i - 1][j], steps + "forth ");
        }

        if (j - 1 >= 0) {

            findPath(i, j - 1, acheived + road[i][j - 1], steps + "left ");
        }

        if (j + 1 < n) {

            findPath(i, j + 1, acheived + road[i][j + 1], steps + "right ");
        }
    }

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {

            m = input.nextInt();
            n = input.nextInt();

            road = new char[m][n];

            int x = 0, y = 0;

            for (int i = 0; i < m; i++) {

                String s = input.nextLine();
                road[i] = s.toCharArray();

                for (int j = 0; j < n && x == 0; j++) {
                    if (road[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }

            }

            findPath(x, y, "", "");

            System.out.println(answer.substring(0, answer.length() - 1));

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine(), "\0\n ");
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
