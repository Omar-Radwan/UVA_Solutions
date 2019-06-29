import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<String> a;
    static int[][] x;
    static int n, m;

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            a = new ArrayList<>();
            while (input.hasNext()) {
                String s = input.nextLine();
                if (s == null || s.isEmpty()) {
                    break;
                }
                a.add(s);
            }
            n = a.size();
            m = a.get(0).length();
            x = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int curr = a.get(i).charAt(j) - '0';
                    x[i][j] = curr;

                    x[i][j] += i > 0 ? x[i - 1][j] : 0;
                    x[i][j] += j > 0 ? x[i][j - 1] : 0;
                    x[i][j] -= i > 0 && j > 0 ? x[i - 1][j - 1] : 0;

                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int l = i; l < n; l++) {
                        for (int k = j; k < m; k++) {
                            int area = (l - i + 1) * (k - j + 1);
                            int sum = x[l][k];
                            sum -= i > 0 ? x[i - 1][k] : 0;
                            sum -= j > 0 ? x[l][j - 1] : 0;
                            sum += i > 0 && j > 0 ? x[i - 1][j - 1] : 0;
                            max = sum == area ? Math.max(max, sum) : max;
                        }
                    }
                }
            }
            System.out.println(max);
            if (t > 0)
                System.out.println();

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