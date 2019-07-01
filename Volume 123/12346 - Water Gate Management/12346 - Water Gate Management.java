import java.util.Scanner;

class Main {
    static long[][] a;
    static int t;
    static long v;

    static long findMin(long c, long f, int i) {
        if (f >= v)
            return c;
        else if (i >= a.length && f < v)
            return (long) Long.MAX_VALUE;

        long x = findMin(c, f, i + 1);
        long y = findMin(c + (a[i][1]), f + (a[i][0] * t), i + 1);

        return Math.min(x, y);

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        a = new long[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = input.nextLong();
            }
        }

        int m = input.nextInt();

        for (int i = 1; i < m + 1; i++) {

            v = input.nextLong();
            t = input.nextInt();

            long ans = findMin(0, 0, 0);
            System.out.print("Case " + i + ": ");
            if (ans == Long.MAX_VALUE)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(ans);

        }

    }

}
