import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static PrintWriter out = new PrintWriter(System.out);

    static boolean[] sieve(int n) {

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;

        for (int i = 2; i * i <= n; i++) {

            if (primes[i] == false)
                continue;

            for (int j = i * i; j <= n; j += i) {
                if (j % i == 0) {
                    primes[j] = false;
                }
            }

        }

        return primes;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean[] primes = sieve(1000);

        while (input.hasNext()) {

            int n = input.nextInt();
            int c = input.nextInt();

            ArrayList<Integer> primesInRange = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                if (primes[i]) {
                    primesInRange.add(i);
                }

            }

            int m = (primesInRange.size() + 1) / 2 - 1;
            out.print(n + " " + c + ": ");

            int end;

            if (primesInRange.size() % 2 == 0)
                end = m + c + 1;
            else
                end = m + c;

            int start = m - c + 1;

            if (2 * c > primesInRange.size()) {
                start = 0;
                end = primesInRange.size();
            }

            for (int i = start; i < end; i++) {
                if (i < end - 1) {
                    out.print(primesInRange.get(i) + " ");
                } else {
                    out.print(primesInRange.get(i));
                }
            }
            out.println();
            if (input.hasNextLine()) {
                out.println();
            }

        }
        out.flush();

    }

}
