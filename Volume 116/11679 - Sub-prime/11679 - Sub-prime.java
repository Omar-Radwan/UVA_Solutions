import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(System.out);

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (b == 0 && n == 0)
                break;

            int[] a = new int[b + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i < b + 1; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int debtor = Integer.parseInt(st.nextToken());
                int creditor = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                a[debtor] -= value;
                a[creditor] += value;
            }

            boolean isPossible = true;

            for (int x : a) {
                if (x < 0)
                    isPossible = false;
            }

            if (isPossible)
                System.out.println("S");
            else
                System.out.println("N");

        }

        out.flush();

    }
}