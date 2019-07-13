import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, a[];

    static void shuffle(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int r = i + ((int) Math.random() * (a.length - i));
            int tmp = a[r];
            a[r] = a[i];
            a[i] = tmp;
        }
    }

    static int firstTrue(int l, int r, int k) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= k)
                r = m;
            else
                l = m + 1;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            n = input.nextInt();
            if (n == 0)
                break;
            a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();

            shuffle(a);
            Arrays.sort(a);

            int ans = Integer.MIN_VALUE;

            for (int d = n - 1; d >= 0; d--) {
                int x = 0;
                int y = n - 1;

                while (y >= x + 2) {
                    while (y >= x + 2 && a[y] + a[y - 1] + a[x] < a[d])
                        x++;

                    while (y >= x + 2 && a[y] + a[x] + a[x + 1] > a[d])
                        y--;

                    int f = firstTrue(x, y, a[d] - a[x] - a[y]);
                    if (a[x] + a[y] + a[f] == a[d]) {
                        ans = a[d];
                        break;
                    } else {
                        x++;
                    }
                }

            }

            out.println(ans == Integer.MIN_VALUE ? "no solution" : ans);

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