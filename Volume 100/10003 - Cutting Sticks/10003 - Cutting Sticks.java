import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;

import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

 class Main{

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;
    static int[][] memo;
    static boolean[][] v;

    static int solve(int s, int e) {

        if (s + 1 >= e)
            return 0;

        if (v[s][e])
            return memo[s][e];
        
            v[s][e] = true;

        int min = (int) 1e9;

        for (int i = s + 1; i < e; i++) {
            min = Math.min(min, solve(s, i) + solve(i, e));
        }

        return memo[s][e] = a[e] - a[s] + min;

    }

    public static void main(String[] args) throws IOException {

        while (true) {
            int l = input.nextInt();

            if (l == 0)
                break;

            n = input.nextInt();

            a = new int[n + 2];
            memo = new int[1005][10005];
            v = new boolean[1005][1005];

            for (int i = 1; i < n + 1; i++)
                a[i] = input.nextInt();

            a[0] = 0;
            a[n + 1] = l;
            out.println("The minimum cutting is " + solve(0, n + 1) + ".");

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