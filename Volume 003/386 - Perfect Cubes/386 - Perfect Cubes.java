import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        String[] x = new String[201];

        for (int i = 2; i <= 200; i++) {
            x[i] = "";
            for (int j = 2; j < i; j++) {
                for (int k = j + 1; k < i; k++) {
                    int res = i * i * i - j * j * j - k * k * k;
                    if (res > 0) {
                        double root = Math.cbrt(res);
                        int intRoot = (int) Math.round(root);
                        if (intRoot > 1 && intRoot < 200 && intRoot * intRoot * intRoot == res && intRoot >= j
                                && intRoot >= k) {

                            System.out.println("Cube = " + i + ", Triple = (" + j + "," + k + "," + intRoot + ")");

                        }
                    }

                }
            }
        }
    }

}
