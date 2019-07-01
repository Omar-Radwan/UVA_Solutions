import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    static boolean[] isPrime;
    static ArrayList<Integer> primes = new ArrayList<>();
    static ArrayList<int[]> twinPrimes = new ArrayList<>();

    static void sieve(int x) {

        isPrime = new boolean[x + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= x; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= x; j += i) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        for (int i = 0; i < x; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

    }

    static void findTwis() {

        for (int i = 0; i < primes.size() - 1; i++) {
            if (primes.get(i + 1) - primes.get(i) == 2) {
                twinPrimes.add(new int[] { primes.get(i), primes.get(i + 1) });
            }
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        sieve((int) (2 * 1E7));
        findTwis();

        while (input.hasNext()) {

            int n = input.nextInt();

            System.out.println("(" + twinPrimes.get(n - 1)[0] + ", " + twinPrimes.get(n - 1)[1] + ")");

        }

    }

}
