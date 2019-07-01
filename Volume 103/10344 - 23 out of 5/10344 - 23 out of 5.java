import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] a;
    static boolean[] visited;
    static boolean found23;

    static void find23(int sum, int length) {

        if (!found23) {
            if (length >= 5) {
                if (sum == 23) {
                    found23 = true;
                }
                return;
            }

            for (int i = 0; i < 5; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    find23(sum + a[i], length + 1);
                    if (length > 0) {
                        find23(sum - a[i], length + 1);
                        find23(sum * a[i], length + 1);
                    }
                    visited[i] = false;
                }

            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            found23 = false;
            visited = new boolean[5];
            if (s.equals("0 0 0 0 0")) {
                break;
            }

            StringTokenizer input = new StringTokenizer(s);

            a = new int[5];

            for (int i = 0; i < 5; i++)
                a[i] = Integer.parseInt(input.nextToken());
            find23(0, 0);
            if (found23) {
                System.out.println("Possible");
            } else
                System.out.println("Impossible");

        }
    }

}
