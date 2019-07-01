import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);

    static int n, minAns;
    static String[] s;

    static int[] order = new int[6];
    static boolean[] visited = new boolean[6];

    static int minimizeLength() {
        StringBuilder x = new StringBuilder("");
        x.append(s[order[0]]);

        for (int i = 1; i < n; i++) {
            String curr = s[order[i]];
            int j = 0;

            for (int k = 0; k < x.length(); k++) {
                if (j >= curr.length() || curr.charAt(j) != x.charAt(k)) {
                    j = 0;
                }
                if (curr.charAt(j) == x.charAt(k)) {
                    j++;
                }

            }

            x.append(curr.substring(j));

        }

        return x.length();
    }

    static void solve(int indx) {

        if (indx == n) {
            minAns = Math.min(minimizeLength(), minAns);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                order[indx] = i;
                visited[i] = true;
                solve(indx + 1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {

            n = input.nextInt();
            s = new String[n];

            minAns = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++)
                s[j] = input.next();

            solve(0);

            System.out.println("Case " + i + ": " + minAns);

        }

    }

}