import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        while (t > 0) {

            int n = input.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = input.nextLong();
            }

            long maxDifference = -Integer.MAX_VALUE;
            long maxScore = a[0];

            for (int i = 1; i < n; i++) {
                long diff = maxScore - a[i];
                if (diff > maxDifference)
                    maxDifference = diff;
                if (a[i] > maxScore)
                    maxScore = a[i];
            }

            System.out.println(maxDifference);

            t--;
        }
    }

}
