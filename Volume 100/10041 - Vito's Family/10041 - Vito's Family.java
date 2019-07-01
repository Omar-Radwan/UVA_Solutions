import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {
            int n = input.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();

            Arrays.sort(a);
            int best = a[n / 2];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(a[i] - best);
            }

            System.out.println(sum);
        }

    }

}
