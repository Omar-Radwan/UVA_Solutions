import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static int MAXN = 50;
    static long[] memo;

    static long solve(int n) {
        if (memo[n] != -1)
            return memo[n];
        return memo[n] = solve(n - 1) + solve(n - 2);
    }

    public static void main(String args[]) throws IOException {
        memo = new long[MAXN + 5];
        Arrays.fill(memo, -1);

        memo[1] = 1;
        memo[2] = 2;

        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;
            System.out.println(solve(n));

        }

    }

}