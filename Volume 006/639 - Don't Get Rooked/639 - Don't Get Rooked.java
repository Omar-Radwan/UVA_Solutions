import java.io.IOException;
import java.util.Scanner;

class Main {

    static Scanner input = new Scanner(System.in);
    static char[][] grid;
    static int n;
    static int maxAns;

    static boolean check() {
        for (int i = 0; i < n; i++) {
            boolean foundR = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'R' && foundR) {
                    return false;
                } else if (grid[i][j] == 'R' && !foundR) {
                    foundR = true;
                } else if (grid[i][j] == 'X') {
                    foundR = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean foundR = false;
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 'R' && foundR) {
                    return false;
                } else if (grid[j][i] == 'R' && !foundR) {
                    foundR = true;
                } else if (grid[j][i] == 'X') {
                    foundR = false;
                }
            }
        }
        return true;
    }

    static void solve(int x, int y, int count) {

        if (!check())
            return;

        if (y == n) {
            x = x + 1;
            y = 0;
        }

        if (x == n) {
            maxAns = Math.max(maxAns, count);
            return;
        }

        if (grid[x][y] == '.') {
            grid[x][y] = 'R';
            solve(x, y + 1, count + 1);
            grid[x][y] = '.';
        }

        solve(x, y + 1, count);

    }

    public static void main(String args[]) throws IOException {

        while (true) {
            n = input.nextInt();
            input.nextLine();
            if (n == 0)
                break;
            maxAns = Integer.MIN_VALUE;
            grid = new char[n][n];

            for (int i = 0; i < n; i++) {
                String s = input.nextLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }
            solve(0, 0, 0);
            System.out.println(maxAns);

        }

    }
}
