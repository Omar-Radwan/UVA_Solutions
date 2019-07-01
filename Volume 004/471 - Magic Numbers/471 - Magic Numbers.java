import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static boolean checkUnique(String s) {
        boolean[] visited = new boolean[10];
        for (int i = 0; i < s.length(); i++) {
            if (visited[s.charAt(i) - '0'])
                return false;
            visited[s.charAt(i) - '0'] = true;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {

        int t = input.nextInt();

        while (t-- > 0) {

            long n = input.nextLong();

            long l = n;

            for (long i = 1; true; i++) {
                l = n * i;
                if (l > 1e11) {
                    break;
                }

                if (checkUnique(Long.toString(l)) && checkUnique(Long.toString(i))) {
                    out.println(l + " / " + i + " = " + n);

                }
            }
            if (t > 0)
                out.println();
        }
        out.flush();

    }
}
