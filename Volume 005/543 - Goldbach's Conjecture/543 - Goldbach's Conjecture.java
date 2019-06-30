import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static boolean[] isPrime;

    static ArrayList<Integer> sieve(int n) {
        isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n + 1; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> primes = sieve((int) 1E6);

        while (true) {
            int x = input.nextInt();

            if (x == 0) {
                break;
            }

            int a = 0, b = 0, i = 0;
            boolean isFound = false;
            while (true) {

                a = primes.get(i);
                if (a > x) {
                    break;
                }

                b = x - a;

                if (isPrime[b]) {
                    isFound = true;
                    break;
                }
                i++;

            }

            if (isFound) {
                System.out.println(x + " = " + a + " + " + b);
            } else {
                System.out.println("Goldbach's conjecture is wrong.");

            }

        }

    }

}
