import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws IOException {
        int l = 1;
        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = input.nextInt();
            int m = input.nextInt();

            System.out.println("Case " + l + ":");
            while (m-- > 0) {
                int q = input.nextInt();
                int bestAns = Integer.MIN_VALUE;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j == i)
                            continue;
                        int currDiff = Math.abs(a[i] + a[j] - q);
                        int bestDiff = Math.abs(q - bestAns);
                        if (currDiff < bestDiff)
                            bestAns = a[i] + a[j];
                    }
                }
                System.out.println("Closest sum to " + q + " is " + bestAns + ".");
            }
            l++;

        }

    }

}
