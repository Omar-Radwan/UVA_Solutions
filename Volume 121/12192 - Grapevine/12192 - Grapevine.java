import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m, a[][];
    static int L[], R[];

    static int firstTrue(int a[], int key) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= key)
                r = mid;
            else
                l = mid + 1;

        }
        return a[r] >= key ? r : -1;
    }

    static int lastTrue(int[] a, int key) {
        int l = 0;
        int r = a.length - 1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (a[mid] <= key)
                l = mid;
            else
                r = mid - 1;
        }
        return a[l] <= key ? l : -1;
    }

    static int lastTrue2(int j) {
        int l = j;
        int r = a.length - 1;

        while (l < r) {
            int i = l + (r - l + 1) / 2;
            if (R[i] - L[j] + 1 >= i - j + 1)
                l = i;
            else
                r = i - 1;
        }
        return R[r] - L[j] + 1 >= r - j + 1 ? r : -1;

    }

    public static void main(String[] args) throws IOException {

        while (true) {
            n = input.nextInt();
            m = input.nextInt();
            if (n == 0 && m == 0)
                break;

            a = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    a[i][j] = input.nextInt();
            }

            int q = input.nextInt();

            for (int f = 0; f < q; f++) {
                int sV = input.nextInt();
                int eV = input.nextInt();

                int max = 0;

                L = new int[n];
                R = new int[n];
                for (int rows = 0; rows < n; rows++) {

                    int l = firstTrue(a[rows], sV);
                    int r = lastTrue(a[rows], eV);

                    L[rows] = l;
                    R[rows] = r;
                }

                for (int j = 0; j < n; j++) {
                    if (L[j] != -1 && R[j] != -1) {
                        int i = lastTrue2(j);
                        if (i != -1) {
                            int size = i - j + 1;
                            max = Math.max(max, size);
                        }

                    }

                }
                out.println(max);
            }
            out.println("-");
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