import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static FastReader input = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n, k, size;
    static long memo[][][];
    static boolean v[][][];
    static ArrayList<Integer> primes;

    static long solve(int indx, int rem, int sum) {
        if (sum == 0 && rem == 0)
            return 1;

        if (rem < 0 || sum < 0 || indx >= size)
            return 0;
        if (v[indx][rem][sum])
            return memo[indx][rem][sum];
        v[indx][rem][sum] = true;

        long x = solve(indx + 1, rem - 1, sum - primes.get(indx));
        long y = solve(indx + 1, rem, sum);

        return memo[indx][rem][sum] = x + y;
    }

    public static void main(String[] args) throws IOException {
        primes = new ArrayList<>();
        boolean[] isPrime = new boolean[1221];

        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= 1220; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= 1220; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= 1220; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        size = primes.size();

        while (true) {
            n = input.nextInt();
            k = input.nextInt();
            if (n == 0 && k == 0)
                break;
            memo = new long[size + 1][k + 1][n + 1];
            v = new boolean[size + 1][k + 1][n + 1];

            long sol = solve(0, k, n);
            out.println(sol);
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