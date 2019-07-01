import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {

    static int n;

    static char[][] g;

    static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
    static int[] dy = { 1, -1, -1, 0, 1, -1, 0, 1 };

    static void floodfill(int x, int y, char c1, char c2) {

        if (x < 0 || y < 0 || x >= n || y >= n)
            return;

        if (g[x][y] != c1)
            return;

        g[x][y] = c2;

        for (int i = 0; i < 8; i++) {
            floodfill(x + dx[i], y + dy[i], c1, c2);
        }
    }

    public static void main(String args[]) throws IOException {

        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = 1;
        while (input.hasNext()) {

            n = input.nextInt();
            input.nextLine();

            g = new char[n][n];

            for (int i = 0; i < n; i++) {
                String s = input.nextLine();
                g[i] = s.toCharArray();
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == '1') {
                        floodfill(i, j, '1', '.');
                        count++;
                    }
                }
            }

            out.println("Image number " + t + " contains " + count + " war eagles.");
            out.flush();
            t++;

        }

    }

}
