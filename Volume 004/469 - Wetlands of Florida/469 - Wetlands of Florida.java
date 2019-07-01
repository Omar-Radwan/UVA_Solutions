import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    static Scanner input = new Scanner(System.in);
    static char[][] g;
    static int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 };
    static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

    static int floodfill(int x, int y) {

        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length)
            return 0;

        if (g[x][y] != 'W')
            return 0;

        int ans = 1;

        g[x][y] = '.';

        for (int i = 0; i < 8; i++) {
            ans += floodfill(x + dx[i], y + dy[i]);
        }

        return ans;

    }

    static public class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x - o.x;
        }

        public Pair clone() {
            return new Pair(this.x, this.y);
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        int t = input.nextInt();
        input.nextLine();
        input.nextLine();

        while (t-- > 0) {

            ArrayList<String> s = new ArrayList<>();

            String x;

            while (true) {
                x = input.nextLine();
                if (x.contains(" ")) {
                    break;
                }
                s.add(x);
            }

            g = new char[s.size()][];

            st = new StringTokenizer(x);
            ArrayList<Pair> point = new ArrayList<>();
            point.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            x = "";

            while (true) {
                if (input.hasNext())
                    x = input.nextLine();
                else
                    break;
                if (x.length() == 0)
                    break;
                st = new StringTokenizer(x);
                point.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            for (int j = 0; j < point.size(); j++) {

                for (int i = 0; i < s.size(); i++) {
                    g[i] = s.get(i).toCharArray();
                }

                System.out.println(floodfill(point.get(j).x - 1, point.get(j).y - 1));
            }

            if (t > 0)
                System.out.println();

        }

    }

}