import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        while (input.hasNext()) {
            int n = input.nextInt();
            int ans = 0;

            for (int i = 0; i < 8; i++) {
                if (((1 << i) & n) != 0) {
                    ans |= (1 << (24 + i));
                }
            }

            for (int i = 8; i < 16; i++) {
                if (((1 << i) & n) != 0) {
                    ans |= (1 << (8 + i));
                }
            }

            for (int i = 16; i < 24; i++) {
                if (((1 << i) & n) != 0) {
                    ans |= (1 << (i - 8));
                }
            }

            for (int i = 24; i < 32; i++) {
                if (((1 << i) & n) != 0) {
                    ans |= (1 << (i - 24));
                }
            }

            System.out.println(n + " converts to " + ans);

        }

    }

}
