import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        int n = input.nextInt();

        while (n-- > 0) {
            int minAns = Integer.MAX_VALUE;
            int x = input.nextInt();

            for (int i = 1; i <= x; i++) {
                for (int j = i; j <= x; j++) {
                    if (x % (i * j) == 0) {
                        int k = x / (i * j);
                        minAns = Math.min(minAns, (i * j + j * k + i * k) * 2);

                    }
                }
            }

            System.out.println(minAns);

        }

    }
}
