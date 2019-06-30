import java.util.Scanner;

class Main {

    static int[][] a;
    static boolean[] visited;

    static void dfs(int s, int remove) {
        if (s != remove) {
            visited[s] = true;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && a[s][i] == 1) {
                    dfs(i, remove);
                }
            }
        }
    }

    static void printLine(int n) {
        System.out.print("+");
        for (int j = 0; j < 2 * n - 1; j++) {
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for (int k = 1; k <= t; k++) {

            int n = input.nextInt();

            a = new int[n][n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    a[i][j] = input.nextInt();
                }

            }

            boolean[][] dominance = new boolean[n][n];
            visited = new boolean[n];
            boolean[] isReachableFromS = new boolean[n];
            dfs(0, 1000);
            for (int i = 0; i < n; i++) {
                isReachableFromS[i] = visited[i];
            }

            for (int i = 0; i < n; i++) {
                visited = new boolean[n];
                dfs(0, i);
                for (int j = 0; j < visited.length; j++) {
                    if (isReachableFromS[j] && !visited[j]) {
                        dominance[i][j] = true;
                    }
                }
            }
            System.out.println("Case " + k + ":");
            printLine(n);
            for (int i = 0; i < n; i++) {
                System.out.print("|");
                for (int j = 0; j < n; j++) {
                    if (dominance[i][j]) {
                        System.out.print("Y|");
                    } else {
                        System.out.print("N|");
                    }
                }
                System.out.println();
                printLine(n);
            }

        }

    }

}
