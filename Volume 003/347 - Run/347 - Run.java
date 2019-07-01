import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static boolean check(int x) {
        boolean[] visited = new boolean[10];
        char[] a = Integer.toString(x).toCharArray();
        for (char c : a) {
            if (visited[c - '0'] || c == '0') {
                return false;
            }
            visited[c - '0'] = true;
        }

        visited = new boolean[10];
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            visited[a[j] - '0'] = true;
            j = (a[j] - '0') + j;
            j %= (a.length);
        }
        for (int i = 0; i < a.length; i++) {
            if (!(visited[a[i] - '0']))
                return false;
        }

        if (j != 0)
            return false;

        return true;
    }

    public static void main(String args[]) throws IOException {

        int t = 1;
        while (true) {
            int n = input.nextInt();
            if (n == 0)
                break;
            int ans = 0;

            for (int i = n; true; i++) {
                if (check(i)) {
                    ans = i;
                    break;
                }
            }

            out.print("Case " + t++ + ": " + ans + "\n");
        }
        out.flush();

    }

}