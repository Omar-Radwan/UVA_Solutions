import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        while (true) {
            int m = input.nextInt();
            if (m == 0)
                break;
            long ans = Integer.MAX_VALUE;
            for (int i = 0; true; i++) {
                long result = (long) Math.pow(3, i);
                if (result > Integer.MAX_VALUE)
                    break;
                for (int j = 0; result < Integer.MAX_VALUE; j++) {
                    if (j > 0)
                        result *= 2;
                    if (result >= m) {
                        ans = Math.min(ans, result);
                        break;
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
