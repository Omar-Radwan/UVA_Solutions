import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int findMaxSum(int[] a, int n, int i) {

        if (n < 0)
            return -9999999;
        if (i == a.length || n == 0)
            return 0;

        int x = findMaxSum(a, n, i + 1);
        int y = findMaxSum(a, n - a[i], i + 1) + a[i];

        return Math.max(x, y);

    }

    static boolean foundTracks;

    static void tracksFinder(int n, int sum, int[] a, String s, int i) {

        if (sum == n) {
            System.out.print(s);
            foundTracks = true;
            return;
        }
        if (sum > n || i >= a.length)
            return;

        tracksFinder(n, sum, a, s, i + 1);
        if (foundTracks)
            return;
        tracksFinder(n, sum + a[i], a, s + a[i] + " ", i + 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String f = br.readLine();
            if (f == null || f.equals(""))
                break;
            StringTokenizer in = new StringTokenizer(f);

            int n = Integer.parseInt(in.nextToken());

            int x = Integer.parseInt(in.nextToken());

            int[] a = new int[x];

            while (--x >= 0) {
                a[x] = Integer.parseInt(in.nextToken());
            }

            int sum = findMaxSum(a, n, 0);
            foundTracks = false;
            tracksFinder(sum, 0, a, "", 0);
            System.out.println("sum:" + sum);

        }

    }

}
