import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    static boolean[] isPrime;
    static ArrayList<Integer> primes = new ArrayList<>();

    static void sieve(int n) {

        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j++) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (isPrime[i] == true) {
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) {

        sieve((int) Math.pow(2, 15));
        Scanner input = new Scanner(System.in);
        int count;
        while (true) {

            int x = input.nextInt();

            if (x == 0) {
                break;
            }

            int i = 0;
            count = 0;
            while (true) {

                int a = primes.get(i);
                if (2 * a > x) {
                    break;
                }
                if (isPrime[x - a]) {
                    count++;
                }
                i++;
            }
            System.out.println(count);
        }

    }

}
