import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    static int memo[];
    static boolean visited[];

    public static int solve(long n) {
        if (n == 1)
            return 1;

        if (n < memo.length) {
            if (visited[(int) n]) {
                return memo[(int) n];
            }
            visited[(int) n] = true;
        }
        int ans = 0;
        if ((n & 1) == 1)
            ans = 1 + solve(3 * n + 1);

        else
            ans = 1 + solve(n >> 1);
        if (n < memo.length)
            memo[(int) n] = ans;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        memo = new int[(int) 1e7];
        visited = new boolean[(int) 1e7];

        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int start = Math.min(x, y);
            int end = Math.max(x, y);

            int max = Integer.MIN_VALUE;

            for (int i = start; i <= end; i++) {
                max = Math.max(solve((long) i), max);
            }
            out.println((int) x + " " + (int) y + " " + (int) max);
            out.flush();
        }

    }

}
