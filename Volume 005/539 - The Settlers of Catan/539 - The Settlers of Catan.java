import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static int MAX;
    static boolean[][] visited;
    static ArrayList<Integer> a[];

    static void dfs(int o, int pathValue) {

        boolean isDone = true;

        for (int i = 0; i < a[o].size(); i++) {
            int y = a[o].get(i);

            if (!visited[o][y]) {
                visited[o][y] = true;
                visited[y][o] = true;
                dfs(y, pathValue + 1);
                visited[o][y] = false;
                visited[y][o] = false;
                isDone = false;
            }
        }

        if (isDone) {
            if (pathValue > MAX) {
                MAX = pathValue;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);

        while (true) {
            int n = input.nextInt();
            int m = input.nextInt();
            if (n == 0 && m == 0)
                break;
            MAX = Integer.MIN_VALUE;

            a = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                a[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                a[x].add(y);
                a[y].add(x);
            }

            for (int i = 0; i < n; i++) {
                visited = new boolean[n][26];
                dfs(i, 0);
            }

            System.out.println(MAX);

        }

    }

}
