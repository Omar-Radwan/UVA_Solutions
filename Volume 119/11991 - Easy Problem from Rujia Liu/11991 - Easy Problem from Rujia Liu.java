import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static PrintWriter out = new PrintWriter(System.out);

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
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String s = br.readLine();
            if (s == null)
                break;

            StringTokenizer st = new StringTokenizer(s);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Pair[] a = new Pair[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = new Pair(Integer.parseInt(st.nextToken()), i + 1);
            }

            Arrays.sort(a);

            while (m-- > 0) {

                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int l = 0;
                int r = a.length - 1;

                while (l < r) {
                    int z = l + (r - l) / 2;
                    if (a[z].x >= x)
                        r = z;
                    else
                        l = z + 1;
                }

                if (l + k - 1 < n && a[l + k - 1].x == x) {
                    out.println(a[l + k - 1].y);
                } else
                    out.println(0);

            }

        }

        out.flush();

    }

}