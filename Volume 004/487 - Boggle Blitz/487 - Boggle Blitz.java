import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static char[][] x;

    static TreeSet<String> d;

    static void solve(int i, int j, String s) {

        if (s.length() >= 2) {
            if (s.charAt(s.length() - 1) <= s.charAt(s.length() - 2)) {
                return;
            }
        }

        if (s.length() >= 3) {
            d.add(s);
        }

        if (i >= n || j >= n || i < 0 || j < 0) {
            return;
        }

        s += x[i][j];

        solve(i + 1, j + 1, s);
        solve(i - 1, j - 1, s);

        solve(i + 1, j - 1, s);
        solve(i - 1, j + 1, s);

        solve(i + 1, j, s);
        solve(i - 1, j, s);

        solve(i, j + 1, s);
        solve(i, j - 1, s);

    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {
            n = input.nextInt();
            x = new char[n][n];
            for (int i = 0; i < n; i++) {
                x[i] = input.next().toCharArray();
            }
            d = new TreeSet<String>(new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {
                    return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
                }
            });

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    solve(i, j, "");
                }
            }

            for (String s : d) {
                System.out.println(s);
            }

            if (t >= 1)
                System.out.println();

        }

    }

}