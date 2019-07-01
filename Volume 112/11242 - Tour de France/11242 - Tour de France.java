import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String args[]) throws IOException {

        while (true) {
            int f = input.nextInt();
            if (f == 0)
                break;
            int r = input.nextInt();

            int[] a = new int[f];
            int[] b = new int[r];

            ArrayList<Double> x = new ArrayList<>();

            for (int i = 0; i < f; i++)
                a[i] = input.nextInt();
            for (int j = 0; j < r; j++)
                b[j] = input.nextInt();

            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    double d = b[i] * 1.0D / a[j] * 1.0D;
                    x.add(d);
                }
            }

            Collections.sort(x);
            double max = 0;
            for (int i = 1; i < x.size(); i++) {
                max = Math.max(max, x.get(i) / x.get(i - 1));
            }
            System.out.printf("%.2f\n", max);
        }
    }

}
